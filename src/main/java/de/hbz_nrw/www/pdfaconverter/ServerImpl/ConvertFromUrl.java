/**
 * 
 */
package de.hbz_nrw.www.pdfaconverter.ServerImpl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
@Path("/api/convertFromUrl")
public class ConvertFromUrl {

	// Initiate Logger for PilotRunner
	private static Logger log = Logger.getLogger(ConvertFromUrl.class);
	
	//  Jersey annotated Methods 
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public PilotResult postConvertFromUrl(@QueryParam("inputFile") String inputFileUrl, 
			@QueryParam("parameterFile") String paramFileUrl){
		PilotResult response = null;

		String fileIdent = TimePrefix.getTimePrefix();
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

	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public PilotResult postConvertFromUrl(@QueryParam("inputFile") String inputFileUrl){
		PilotResult response = null;

		// first run
		InputStream paramStream =  this.getClass().getResourceAsStream("/conf/defaultParam1.cfg");

		if(paramStream == null){
			log.error("Failed loading defaultParams: not found in classpath");
		}
		FileUtil.saveInputStreamToTempFile(paramStream, "defaultParam1.txt");

		String jobIdent = TimePrefix.getTimePrefix();

		Properties paramProp = PdfAPilotParameters.getDefaultProperties();
		
        try {
    		log.info("Reading Parameters File");
            FileInputStream fis;
			fis = new FileInputStream(new File(Configuration.getTempDirPath() + "defaultParam1.txt"));
	        BufferedInputStream bis = new BufferedInputStream(fis);
			paramProp.load(bis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response = convertFromUrl(paramProp, inputFileUrl);
		
		// second run only if required
		if(!response.getExitState().equals("0") && !response.getExitState().equals("105") ){
			paramStream = this.getClass().getResourceAsStream("/conf/defaultParam2.cfg");
			FileUtil.saveInputStreamToTempFile(paramStream, "defaultParam2.txt");
	        try {
	    		log.info("Reading Parameters File");
	            FileInputStream fis;
				fis = new FileInputStream(new File(Configuration.getTempDirPath() + "defaultParam2.txt"));
		        BufferedInputStream bis = new BufferedInputStream(fis);
				paramProp.load(bis);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response = convertFromUrl(paramProp, inputFileUrl);
			
		}
		
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
		log.info(paramString);
		
		// copy remote Object to temporary Directory
		String fileName = FileUtil.saveUrlToFile(fileIdent, inputFileUrl);
		
		//executeString = "cp " + Configuration.getTempfiledir() + fileName + " " + Configuration.getTempfiledir() + "result_" + fileName;
		
		PilotRunner pRunner = new PilotRunner();
		pRunner.executePdfATool(paramString, fileName);

		pResult.setInputFileUrl(inputFileUrl);

		String reportFile = Configuration.getResultDirPath() + fileName.replace(".pdf", "." + paramType.getReportFormat()[0].getValue().toLowerCase());

		log.info(reportFile);
		//append report if report exists
		if(new File(reportFile).isFile()){
			pResult.setReportFileUrl(Configuration.getResultDirUrl() + fileName.replace(".pdf", "." + paramType.getReportFormat()[0].getValue().toLowerCase()));
		}else{
			pResult.setReportFileUrl("no report file generated");
		}
		

		pResult.setExitState(pRunner.getExitStateStr());
		
		if(pRunner.getExitStateStr() != null && pRunner.getExitStateStr().equals("0")){
			pResult.setResultFileUrl(Configuration.getResultDirUrl() + fileName);
		}
		return pResult;

		
	}
	
}
