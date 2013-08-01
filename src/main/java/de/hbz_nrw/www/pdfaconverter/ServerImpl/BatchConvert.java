/**
 * 
 */
package de.hbz_nrw.www.pdfaconverter.ServerImpl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
			@QueryParam("parameterFile") String inputFileUrl){
		PilotResultList response = null;
		
		response = batchConvert(batchFileUrl, inputFileUrl);
		
		return response;
	}

	@Path("/batchConvert")
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public PilotResultList getBatchConvert(@QueryParam("batchFile") String batchFileUrl, 
			@QueryParam("parameterFile") String inputFileUrl){
		PilotResultList response = null;
		
		response = batchConvert(batchFileUrl, inputFileUrl);
		
		return response;
	}


	public PilotResultList batchConvert( String BatchFileUrl, String ParamFileUrl){
		
		log.info("User Dir: " + System.getProperty("user.dir"));

		String batchFileUrl = BatchFileUrl;
		String paramFileUrl = ParamFileUrl;
		log.info(batchFileUrl);
		log.info(paramFileUrl);
		//create a unique temporary file prefix
		String fileIdent = TimePrefix.getTimePrefix();
		String fileName = null;
		String paramString = null;
		ArrayList<PilotResult> rList = new ArrayList<PilotResult>();


		String batchFileName = FileUtil.saveUrlToFile(fileIdent + "_batch.txt", batchFileUrl);
		String paramFileName = FileUtil.saveUrlToFile(fileIdent + "_param.txt", paramFileUrl);
		List<String> documentList = null;
		ParameterType paramType = null;
		
		log.info("Batch File URL: " + batchFileName);
		
		try {
			log.info("Reading Batch File");
			documentList = BatchFileUtil.readBatchFile(new File(Configuration.getTempFileDir() + batchFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		float countJobs = documentList.size();
		float countSuccess = 0;
		StringBuffer resultBuffer = new StringBuffer();

		log.info("Starting Batch Job");
		Iterator<String> it = documentList.iterator();
		while(it.hasNext()){
			String fileUrl = it.next();
			log.info("File :" + fileUrl);
			
			PilotResult lineResult = new PilotResult();
			
			//create unique directory identifier
			fileIdent = TimePrefix.getTimePrefix();
			
			// Load File to temp dir
			fileName = FileUtil.saveUrlToFile(fileIdent + ".pdf", fileUrl);
			lineResult.setInputFileUrl(fileUrl);

			String reportType = null;
			try {
				//Read parameters from File
				Properties paramProp = PdfAPilotParameters.getDefaultProperties();
				log.info("Reading Parameters File");
	            FileInputStream fis = new FileInputStream(new File(Configuration.getTempFileDir() + paramFileName));
	            BufferedInputStream bis = new BufferedInputStream(fis);
				paramProp.load(bis);
				paramType = PdfAPilotParameters.createParamType(paramProp);
				paramString = PdfAPilotParameters.createParameterString(fileName, paramType);
				reportType = paramType.getReportFormat()[0].getValue().toLowerCase();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// we may should run threads? 
			PilotRunner pRunner = new PilotRunner();
			pRunner.executePdfATool(paramString, fileName);
			resultBuffer.append(Configuration.getResultDirUrl() 
					+ fileName + " Status-Meldung: " 
					+ pRunner.getExitStateStr() +  " " + Configuration.getResultDirUrl() +fileIdent + "." + reportType +"\n" );
			lineResult.setExitState(pRunner.getExitStateStr());

			if(pRunner.getExitStateStr() != null && pRunner.getExitStateStr().equals("0")){
				lineResult.setResultFileUrl(Configuration.getResultDirUrl() + fileName);
				countSuccess++;
			}
			rList.add(lineResult);
		}
		
		float percentSuccess = countSuccess/countJobs;
		resultBuffer.append(NumberFormat.getPercentInstance().format(percentSuccess) 
				+ " of Batch Jobs executed successfully. All Jobs : " 
				+ NumberFormat.getIntegerInstance().format(countJobs) 
				+ " successful Jobs:  " 
				+ NumberFormat.getIntegerInstance().format(countSuccess) + "\n");

		log.info(resultBuffer.toString());
		// Save results to file 
		String resultLogFile = FileUtil.saveStringToResultFile(fileIdent + ".log", resultBuffer.toString());
		
		PilotResultList prList = new PilotResultList();
		prList.setPilotResultList(rList);
		prList.setCountSuccess(NumberFormat.getIntegerInstance().format(countSuccess));
		prList.setTotalNumberOfJobs(NumberFormat.getIntegerInstance().format(countJobs));
		prList.setPercentSuccess(NumberFormat.getPercentInstance().format(percentSuccess));
		prList.setResultLogFileUrl(Configuration.getResultDirUrl()  + resultLogFile);

		return prList;

		
	}
	
}
