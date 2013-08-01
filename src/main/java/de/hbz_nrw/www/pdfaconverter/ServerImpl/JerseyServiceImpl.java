/**
 * JerseyServiceImpl.java - This file is part of the DiPP Project by hbz
 * Library Service Center North Rhine Westfalia, Cologne 
 *
 * -----------------------------------------------------------------------------
 *
 * <p><b>License and Copyright: </b>The contents of this file are subject to the
 * D-FSL License Version 1.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License
 * at <a href="http://www.dipp.nrw.de/dfsl/">http://www.dipp.nrw.de/dfsl/.</a></p>
 *
 * <p>Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.</p>
 *
 * <p>Portions created for the Fedora Repository System are Copyright &copy; 2002-2005
 * by The Rector and Visitors of the University of Virginia and Cornell
 * University. All rights reserved."</p>
 *
 * -----------------------------------------------------------------------------
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

import org.apache.log4j.Logger;

import de.hbz_nrw.www.pdfaconverter.fileUtil.BatchFileUtil;
import de.hbz_nrw.www.pdfaconverter.fileUtil.FileUtil;
import de.hbz_nrw.www.pdfaconverter.types.ParameterType;
import de.hbz_nrw.www.pdfaconverter.util.PdfAPilotParameters;
import de.hbz_nrw.www.pdfaconverter.util.PilotResult;
import de.hbz_nrw.www.pdfaconverter.util.PilotResultList;
import de.hbz_nrw.www.pdfaconverter.util.TimePrefix;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class JerseyServiceImpl
 * 
 * <p><em>Title: </em></p>
 * <p>Description: </p>
 * 
 * @author aquast, email
 * creation date: 26.07.2013
 *
 */
@Path("/api")
public class JerseyServiceImpl {

	// Initiate Logger for JerseyServiceImpl
	private static Logger log = Logger.getLogger(JerseyServiceImpl.class);

	@GET
	@Path("/convertFromUrl")
	@Produces({MediaType.TEXT_HTML})
	public String convertFromUrl(@QueryParam("fileUrl") String PdfFileUrl, 
			@QueryParam("parameter") String param){

		String pdfFileUrl = PdfFileUrl;
		String paramString = null;
		//create a unique temporary file prefix
		String fileIdent = TimePrefix.getTimePrefix();
		String fileName = FileUtil.saveUrlToFile(fileIdent + ".pdf", pdfFileUrl);
		
		PilotRunner pRunner = new PilotRunner();
		//pRunner.executePdfATool(paramString, fileName);
		
		return "<html> " + "<title>" + "Access to converted file" + "</title>"
		        + "<body><h1>" + "Converted file:" + "</h1>" +
		        	"<ul>" +
		        	"<li>Result: " + fileName + "</li>" +
		        	"<li>From :" + pdfFileUrl + "</li>" +
		        	"</ul></body>" + "</html> ";

	}
	
	public PilotResultList batchConvert( String BatchFileUrl, String ParamFileUrl){

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
			documentList = BatchFileUtil.readBatchFile(new File(Configuration.getTempfiledir() + batchFileName));
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
				//paramString = BatchFileUtil.readBatchFile(new File(Configuration.getTempfiledir() + batchFileName));
				Properties paramProp = PdfAPilotParameters.getDefaultProperties();
				log.info("Reading Parameters File");
	            FileInputStream fis = new FileInputStream(new File(Configuration.getTempfiledir() + paramFileName));
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
			resultBuffer.append(Configuration.getTempdirurl() + "result" 
					+ fileName + " Status-Meldung: " 
					+ pRunner.getExitStateStr() +  " " + Configuration.getTempdirurl() + "result/" +fileIdent + "." + reportType +"\n" );
			lineResult.setExitState(pRunner.getExitStateStr());

			if(pRunner.getExitStateStr() != null && pRunner.getExitStateStr().equals("0")){
				lineResult.setResultFileUrl(Configuration.getTempdirurl() + "result/" + fileName);
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
		FileUtil.saveStringToTempFile("result/" + fileIdent + ".result", resultBuffer.toString());
		
		PilotResultList prList = new PilotResultList();
		prList.setPilotResultList(rList);
		prList.setCountSuccess(NumberFormat.getIntegerInstance().format(countSuccess));
		prList.setTotalNumberOfJobs(NumberFormat.getIntegerInstance().format(countJobs));
		prList.setPercentSuccess(NumberFormat.getPercentInstance().format(percentSuccess));

		//log.info(prList.toString());
		return prList;

		
	}

	@Path("/batchConvert")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public PilotResultList postBatchConvert(@QueryParam("batchFile") String batchFileUrl, 
			@QueryParam("parameterFile") String inputFileUrl){
		PilotResultList response = null;
		
		response = batchConvert(batchFileUrl, inputFileUrl);
		
		return response;
	}
			  
}
