/**
 * 
 */
package de.hbz_nrw.www.pdfaconverter.ServerImpl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.apache.tools.ant.taskdefs.Definer.Format;

import de.hbz_nrw.www.pdfaconverter.fileUtil.BatchFileUtil;
import de.hbz_nrw.www.pdfaconverter.fileUtil.FileUtil;
import de.hbz_nrw.www.pdfaconverter.types.ParameterType;
import de.hbz_nrw.www.pdfaconverter.util.PdfAPilotParameters;
import de.hbz_nrw.www.pdfaconverter.util.PilotResult;
import de.hbz_nrw.www.pdfaconverter.util.PilotResultList;
import de.hbz_nrw.www.pdfaconverter.util.TimePrefix;

/**
 * @author aquast
 *
 */
@Path("/api")
public class BatchConvert {

	// Initiate Logger for PilotRunner
	private static Logger log = Logger.getLogger(BatchConvert.class);
	
	//  Jersey annotated Methods 
	
	@Path("/batchConvert")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public PilotResultList postBatchConvert(@QueryParam("batchFile") String batchFileUrl, 
			@QueryParam("parameterFile") String paramFileUrl){
		PilotResultList response = null;
		
		String jobIdent = TimePrefix.getTimePrefix();
		String batchFileName = FileUtil.saveUrlToFile(jobIdent + "_batch.txt", batchFileUrl);
		String paramFileName = FileUtil.saveUrlToFile(jobIdent + "_param.txt", paramFileUrl);

		response = batchConvert(batchFileName, paramFileName);
		
		return response;
	}

	@Path("/batchConvert")
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public PilotResultList getBatchConvert(@QueryParam("batchFile") String batchFileUrl, 
			@QueryParam("parameterFile") String paramFileUrl){
		PilotResultList response = null;
		
		String jobIdent = TimePrefix.getTimePrefix();
		String batchFileName = FileUtil.saveUrlToFile(jobIdent + "_batch.txt", batchFileUrl);
		String paramFileName = FileUtil.saveUrlToFile(jobIdent + "_param.txt", paramFileUrl);

		response = batchConvert(batchFileName, paramFileName);
		return response;
	}

	@Path("/batchConvert/autoConf")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public PilotResultList postBatchConvert(@QueryParam("batchFile") String batchFileUrl){
		PilotResultList response = null;
		
		// first run
		InputStream is = this.getClass().getResourceAsStream("/conf/defaultParam1.txt");
		
		/*try {
			log.info("stream: " + is.available());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		FileUtil.saveInputStreamToTempFile(is, "defaultParam1.txt");

		String jobIdent = TimePrefix.getTimePrefix();
		String batchFileName = FileUtil.saveUrlToFile(jobIdent + "_batch.txt", batchFileUrl);

		response = batchConvert(batchFileName, "defaultParam1.txt");

		// second run
		PilotResultList response2 = null;
		
		is = this.getClass().getResourceAsStream("/conf/defaultParam2.txt");
		FileUtil.saveInputStreamToTempFile(is, "defaultParam2.txt");
		
		batchFileName =  FileUtil.saveUrlToFile(jobIdent + "_batch2.txt", refineObjList(response));
		response2 = batchConvert(batchFileName, "defaultParam2.txt");
		
		ArrayList<PilotResult> r2List = response2.getPilotResultList();
		response.addPilotResultList(r2List);
		return response;
	}

	public PilotResultList batchConvert( String batchFileName, String paramFileName){
		
		//create a unique temporary file prefix
		String jobIdent = TimePrefix.getTimePrefix();

		String fileName = null;
		String paramString = null;


		ArrayList<PilotResult> rList = new ArrayList<PilotResult>();		
		List<String> documentList = null;
		
		log.info("Batch File URL: " + batchFileName);
		
		try {
			log.info("Reading Batch File");
			documentList = BatchFileUtil.readBatchFile(new File(Configuration.getTempDirPath() + batchFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		float countJobs = documentList.size();
		float countSuccess = 0;
		int countProgress = 0;
		int count4 = 0;
		int count105 = 0;
		int count10x = 0;
		
		StringBuffer resultBuffer = new StringBuffer();

		log.info("Starting Batch Job");
		Iterator<String> it = documentList.iterator();
		while(it.hasNext()){
			countProgress++;
			String fileUrl = it.next();
			log.info("Job " + countProgress + " of " + NumberFormat.getIntegerInstance().format(countJobs) + " File: " + fileUrl);
			StringBuffer lineBuffer = new StringBuffer();
			
			PilotResult lineResult = new PilotResult();
			
			//create unique file identifier
			String fileIdent = TimePrefix.getTimePrefix();
			
			// Load File to temp dir
			fileName = FileUtil.saveUrlToFile(fileIdent + ".pdf", fileUrl);
			lineResult.setInputFileUrl(fileUrl);

			String reportType = null;			
			ParameterType paramType = readParamFile(paramFileName, fileName);
			
			paramString = PdfAPilotParameters.createParameterString(fileName, paramType);
			reportType = paramType.getReportFormat()[0].getValue().toLowerCase();

			// we may should run threads? 
			PilotRunner pRunner = new PilotRunner();
			pRunner.executePdfATool(paramString, fileName);
			
			lineBuffer.append(fileUrl + ", Status: " + pRunner.getExitStateStr() + ", "); 
			
			//append report if report exists
			if(new File(Configuration.getResultDirUrl() +fileIdent + "." + reportType).isFile()){
				lineBuffer.append(Configuration.getResultDirUrl() +fileIdent + "." + reportType);
				lineResult.getReportFileUrl();
			}
			
			resultBuffer.append(Configuration.getResultDirUrl() 
					+ fileName + " Status: " 
					+ pRunner.getExitStateStr() +  " " + Configuration.getResultDirUrl() +fileIdent + "." + reportType +"\n" );
			
			lineResult.setExitState(pRunner.getExitStateStr());

			// prepare some additional information
			if(pRunner.getExitStateStr() != null && pRunner.getExitStateStr().equals("0")){
				// append result pdf
				lineResult.setResultFileUrl(Configuration.getResultDirUrl() + fileName);
				lineBuffer.append(Configuration.getResultDirUrl() + fileName);
				lineResult.setCompliancyLevel(paramType.getCompliancyLevel().toString());
				countSuccess++;
			}else if(pRunner.getExitStateStr() != null && !pRunner.getExitStateStr().equals("0")){
				String errorLogFile = FileUtil.appendStringToResultFile("error_" + jobIdent + ".log", lineBuffer.toString()+ "\n");
				if(pRunner.getExitStateStr().equals("4")){
					count4++;
				}else if(pRunner.getExitStateStr().equals("105")){
					count105++;
				}else{
					count10x++;

				}
			}
			
			rList.add(lineResult);
		}
		
		float percentSuccess = countSuccess/countJobs;
		resultBuffer.append(NumberFormat.getPercentInstance().format(percentSuccess) 
				+ " of Batch Jobs executed successfully. All Jobs : " 
				+ NumberFormat.getIntegerInstance().format(countJobs) 
				+ " successful Jobs:  " 
				+ NumberFormat.getIntegerInstance().format(countSuccess) + "\n"
				+ "Number of unknown errors: " + count10x
				+ ", Number of encrypted Files: " + count105);

		log.info(resultBuffer.toString());
		// Save results to file 
		String resultLogFile = FileUtil.saveStringToResultFile(jobIdent + ".log", resultBuffer.toString());
		
		PilotResultList prList = new PilotResultList();
		prList.setPilotResultList(rList);
		prList.setCountSuccess(NumberFormat.getIntegerInstance().format(countSuccess));
		prList.setTotalNumberOfJobs(NumberFormat.getIntegerInstance().format(countJobs));
		prList.setPercentSuccess(NumberFormat.getPercentInstance().format(percentSuccess));
		prList.setResultLogFileUrl(Configuration.getResultDirUrl()  + resultLogFile);

		return prList;

		
	}
	
	private ParameterType readParamFile(String paramFileName, String fileName){
		ParameterType paramType = null;
		try {
			//Read parameters from File
			Properties paramProp = PdfAPilotParameters.getDefaultProperties();
			log.debug("Reading Parameters File");
			
            FileInputStream fis = new FileInputStream(new File(Configuration.getTempDirPath() + paramFileName));
            BufferedInputStream bis = new BufferedInputStream(fis);
			paramProp.load(bis);
			paramType = PdfAPilotParameters.createParamType(paramProp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return paramType;
	}
	
	private String refineObjList(PilotResultList response){
		String batchFileName = null;
		StringBuffer refinedList = new StringBuffer();
		ArrayList<PilotResult> rList = response.getPilotResultList();
		for(int i = 0; i< rList.size(); i++){
			if(rList.get(i).getExitState().equals("4")){
				refinedList.append(rList.get(i).getInputFileUrl() + "\n");
			}
		}
		batchFileName = FileUtil.saveStringToResultFile("refinedBatch.txt" , refinedList.toString());
		return Configuration.getResultDirUrl() + "/" +  batchFileName;
		
	}
}
