/**
 * 
 */
package de.hbz_nrw.www.pdfaconverter.ServerImpl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import org.apache.axis2.databinding.types.URI;
import org.apache.axis2.databinding.types.URI.MalformedURIException;
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
public class ConvertFromUrl {

	// Initiate Logger for PilotRunner
	private static Logger log = Logger.getLogger(ConvertFromUrl.class);
	
	//  Jersey annotated Methods 
	
	@Path("/convertFromUrl")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public PilotResult postBatchConvert(@QueryParam("batchFile") String inputFileUrl, 
			@QueryParam("parameterFile") String paramFileUrl){
		PilotResult response = null;

		String fileIdent = TimePrefix.getTimePrefix() + ".pdf";
		Properties prop = PdfAPilotParameters.getDefaultProperties();
		String paramFileName = FileUtil.saveUrlToFile(fileIdent + "_param.txt", paramFileUrl);

		Properties paramProp = PdfAPilotParameters.getDefaultProperties();
		
        try {
    		log.info("Reading Parameters File");
            FileInputStream fis;
			fis = new FileInputStream(new File(Configuration.getTempDirPath() + paramFileName));
	        BufferedInputStream bis = new BufferedInputStream(fis);
			paramProp.load(bis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response = convertFromUrl(prop, inputFileUrl);
		
		return response;
	}

	
	@Path("/convertFromUrl")
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public PilotResult getBatchConvert(@QueryParam("batchFile") String inputFileUrl, 
			@QueryParam("parameterFile") String paramFileUrl){
		PilotResult response = null;
		
		String fileIdent = TimePrefix.getTimePrefix() + ".pdf";
		Properties prop = PdfAPilotParameters.getDefaultProperties();
		String paramFileName = FileUtil.saveUrlToFile(fileIdent + "_param.txt", paramFileUrl);

		Properties paramProp = PdfAPilotParameters.getDefaultProperties();
		
        try {
    		log.info("Reading Parameters File");
            FileInputStream fis;
			fis = new FileInputStream(new File(Configuration.getTempDirPath() + paramFileName));
	        BufferedInputStream bis = new BufferedInputStream(fis);
			paramProp.load(bis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response = convertFromUrl(prop, inputFileUrl);
		
		return response;
	}


	public PilotResult convertFromUrl(Properties paramProp, String inputFileUrl){
		
		
		PilotResult pResult = new PilotResult();
		
		//create a unique temporary file prefix 
		String fileIdent = TimePrefix.getTimePrefix() + ".pdf";
		
		String paramString = null; 
		
		// connect Parameters to a generic method that parses them into
		// read line parameters
		ParameterType paramType = PdfAPilotParameters.createParamType(paramProp);
		paramString = PdfAPilotParameters.createParameterString(fileIdent, paramType);
		System.out.println(paramString);
		log.info(paramString);
		
		// copy remote Object to temporary Directory
		String fileName = FileUtil.saveUrlToFile(fileIdent, inputFileUrl);
		
		//executeString = "cp " + Configuration.getTempfiledir() + fileName + " " + Configuration.getTempfiledir() + "result_" + fileName;
		
		PilotRunner pRunner = new PilotRunner();
		pRunner.executePdfATool(paramString, fileName);

		/*
		URI documentUri = null;
		try {
			documentUri = new URI(Configuration.getResultDirUrl() + fileName);
		} catch (MalformedURIException e) {
			e.printStackTrace();
		}
		*/

		pResult.setInputFileUrl(inputFileUrl);
		pResult.setRecordFileUrl(Configuration.getResultDirUrl() + fileName.replace(".pdf", "." + paramProp.getProperty("reportType").toLowerCase()));
		pResult.setExitState(pRunner.getExitStateStr());
		
		if(pRunner.getExitStateStr() != null && pRunner.getExitStateStr().equals("0")){
			pResult.setResultFileUrl(Configuration.getResultDirUrl() + fileName);
		}
		return pResult;

		
	}
	
}
