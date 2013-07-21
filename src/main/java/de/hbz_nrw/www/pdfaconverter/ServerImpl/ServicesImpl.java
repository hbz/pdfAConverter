/**
 * ServicesImpl.java - This file is part of the DiPP Project by hbz
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

import java.lang.StringBuffer;
import java.io.InputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.axis2.databinding.types.URI;
import org.apache.axis2.databinding.types.URI.MalformedURIException;

import javax.activation.DataHandler;
import javax.servlet.ServletException;

import de.hbz_nrw.www.pdfaconverter.fileUtils.FileUtil;
import de.hbz_nrw.www.pdfaconverter.services.ConvertFromAttachment_faultMsg;
import de.hbz_nrw.www.pdfaconverter.services.ConvertFromStream_faultMsg;
import de.hbz_nrw.www.pdfaconverter.services.ConvertFromUrl_faultMsg;
import de.hbz_nrw.www.pdfaconverter.services.PdfAConverterSkeletonInterface;
import de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment;
import de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachmentResponse;
import de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream;
import de.hbz_nrw.www.pdfaconverter.types.ConvertFromStreamResponse;
import de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl;
import de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrlResponse;
import de.hbz_nrw.www.pdfaconverter.types.DocumentType;
import de.hbz_nrw.www.pdfaconverter.types.ParameterType;
import de.hbz_nrw.www.pdfaconverter.types.ReportFormatType;

/**
 * Class ServicesImpl
 * 
 * <p><em>Title: </em></p>
 * <p>Description: </p>
 * 
 * @author Andres Quast, quast@hbz-nrw.de
 * creation date: 21.09.2009
 *
 */
public class ServicesImpl implements PdfAConverterSkeletonInterface {

	/**
	 * Default Constructor for implementing logging
	 */
	public ServicesImpl(){
		Configuration.initLog();
	}
	// Initiate Logger for ServicesImpl
	private static Logger log = Logger.getLogger(ServicesImpl.class);

	/* (non-Javadoc)
	 * @see de.hbz_nrw.www.pdfaconverter.services.PdfAConverterSkeletonInterface#convertFromAttachment(de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment)
	 */
	public ConvertFromAttachmentResponse convertFromAttachment(
			ConvertFromAttachment convertFromAttachment)
			throws ConvertFromAttachment_faultMsg {
		// TODO Auto-generated method stub
		
		DataHandler documentHandler = convertFromAttachment.getDocument().getData();
		String fileName = convertFromAttachment.getDocument().getName();
		//pdfOriginal.
		
		// connect Parameters to a generic method that parses them into
		// read line parameters
		String paramString = createParameterString(fileName, convertFromAttachment.getConverterParameters());
		log.debug("created paramString: " + paramString);
		return null;
	}

	/* (non-Javadoc)
	 * @see de.hbz_nrw.www.pdfaconverter.services.PdfAConverterSkeletonInterface#convertFromStream(de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream)
	 */
	public ConvertFromStreamResponse convertFromStream(
			ConvertFromStream convertFromStream)
			throws ConvertFromStream_faultMsg {
		
		ConvertFromStreamResponse response= new ConvertFromStreamResponse();
		
		log.info("nun hier");
		//create a unique temporary file prefix 
		String fileIdent = getTimePrefix() + ".pdf";

		// connect Parameters to a generic method that parses them into
		// read line parameters
		String paramString = createParameterString(fileIdent, convertFromStream.getConverterParameters());
		log.debug("created paramString: " + paramString);
		
		// Write incoming PDF-Base64 Stream as file into temporary Directory
		String fileName = FileUtil.saveStreamToTempFile(fileIdent, convertFromStream.getByteStream());
		
		executePdfATool(paramString, fileName);
		
		//now create Response from temp dir content
		byte[] stream = null;
		if(new File(Configuration.getTempfiledir() + "result/" + fileName).isFile()){
			stream = FileUtil.loadFileIntoStream(new File(Configuration.getTempfiledir() + "result/" + fileName));

			try{
				response.setResponseDocumentStream(new String(stream, "UTF-8"));
				log.info("dokumentstream geschrieben");
			}catch(Exception e){
			 log.error("Problems with generating files from streams:" + e);	
			}
		
		}

		List<byte[]> reportStreams = new Vector<byte[]>();
		if(new File(Configuration.getTempfiledir() + "result/" + fileName + ".HTML").isFile()){
			reportStreams.add(FileUtil.loadFileIntoStream(new File(Configuration.getTempfiledir() + "result/" + fileName + ".html")));
		}
		if(new File(Configuration.getTempfiledir() + "result/" + fileName + ".XML").isFile()){
			reportStreams.add(FileUtil.loadFileIntoStream(new File(Configuration.getTempfiledir() + "result/" + fileName + ".xml")));
		}
		if(new File(Configuration.getTempfiledir() + "result/" + fileName + ".MHT").isFile()){
			reportStreams.add(FileUtil.loadFileIntoStream(new File(Configuration.getTempfiledir() + "result/" + fileName + ".mht")));
		}
		
		Iterator<byte[]> it = reportStreams.iterator();
		while(it.hasNext()){
			try{
				response.addReportStream(new String(it.next(), "UTF-8"));
			}catch(Exception e){
			 log.error("Problems with generating files from streams:" + e);	
			}
		}
		return response;
	}

	/* (non-Javadoc)
	 * @see de.hbz_nrw.www.pdfaconverter.services.PdfAConverterSkeletonInterface#convertFromUrl(de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl)
	 */
	public ConvertFromUrlResponse convertFromUrl(ConvertFromUrl convertFromUrl)
			throws ConvertFromUrl_faultMsg {

		ConvertFromUrlResponse response= new ConvertFromUrlResponse();
		
		//create a unique temporary file prefix 
		String fileIdent = getTimePrefix() + ".pdf";

		// connect Parameters to a generic method that parses them into
		// read line parameters
		String paramString = createParameterString(fileIdent, convertFromUrl.getConverterParameters());
		System.out.println(paramString);
		log.info(paramString);
		
		// Write incoming PDF-Base64 Stream as file into temporary Directory
		String fileName = FileUtil.saveUrlToFile(fileIdent, convertFromUrl.getUrl());
		
		//executeString = "cp " + Configuration.getTempfiledir() + fileName + " " + Configuration.getTempfiledir() + "result_" + fileName;
		
		executePdfATool(paramString, fileName);

		URI documentUri = null;
		try {
			documentUri = new URI(Configuration.getTempdirurl() + "result/" + fileName);
		} catch (MalformedURIException e) {
			e.printStackTrace();
		}
		response.setResponseDocumentUrl(documentUri);
		return response;
	}
	
	/**
	 * <p><em>Title: Parse the ParameterType Object</em></p>
	 * <p>Description: method generates an String output from all Callas Parameters given 
	 * as Elements from ParameterType by WebService Operation calls.</p>
	 * 
	 * @param paramType <code>parameterType</code> a complex Data Type that provides all needed parameters for 
	 * the Callas PDF A Tool 
	 * @return <code>String</code> with all given parameters parsed from xml
	 */
	private String createParameterString(String fileIdent, ParameterType paramType){
		StringBuffer paramBuffer = new StringBuffer();
		
		// set Parameter Strings
		if(paramType.getReturnOnlyValidPDFA() && paramType.getReturnOnlyValidPDFA() == true){
			paramBuffer.append(" --onlypdfa");
		}
		
		if(paramType.getAnalyseOnly() && paramType.getAnalyseOnly() == true){
			paramBuffer.append(" --analyse");
		}
		
		if(paramType.getCreateEpub() && paramType.getCreateEpub() == true){
			paramBuffer.append(" --createepub " + fileIdent);
		}

		if(paramType.getQuickProcessing() && paramType.getQuickProcessing() == true){
			paramBuffer.append(" --quick");
		}

		if(paramType.getCompliancyLevel()!=null){
			paramBuffer.append(" --level=" + paramType.getCompliancyLevel());
		}
		
		if(paramType.getReportLang()!=null){
			paramBuffer.append(" --language=" + paramType.getReportLang());
		}
		

		for(int i=0; i < paramType.getReportFormat().length; i++){
			paramBuffer.append(" --report=" + paramType.getReportFormat()[i]);
			if(paramType.getReportTrigger()!=null){
				paramBuffer.append("," + paramType.getReportTrigger());
			}
			if(paramType.getReportFormat()[i].equals(ReportFormatType.HTML) && paramType.getHtmlReportOptions() != null){
				for(int j=0; j < paramType.getHtmlReportOptions().length; j++){
					paramBuffer.append("," + paramType.getHtmlReportOptions()[j]);
				}
			}
			paramBuffer.append(",PATH="+ Configuration.getTempfiledir() + "result/" + fileIdent + "." + paramType.getReportFormat()[i].toString().toLowerCase());
		}
		

		return paramBuffer.toString();
	}
	
	private String getTimePrefix(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'kkmmssSSS'Z'");
		Calendar cal = Calendar.getInstance();
		log.info(dateFormat.format(cal.getTime()));
		return dateFormat.format(cal.getTime());
	}
		
	/**
	 * <p><em>Title: </em></p>
	 * <p>Description: Method creates the command line string with all parameters given. 
	 * Then executes the shell command </p>
	 * 
	 * @param paramString
	 * @param fileName 
	 */
	private void executePdfATool(String paramString, String fileName){
		// call to execute PDFA-Tool
		
		// Complete execute String 
		String programPath = new String("/opt/pdfapilot/callas_pdfaPilot_CLI_4_x64/pdfaPilot"); 
		String defaultParams = new String("--noprogress --nohits --substitute  " 
				 + "--linkpath=http://nyx.hbz-nrw.de:8080/axis2/temp/reporttemplate "
				);
		String executeString = new String(programPath + " " 
				+ defaultParams 
				+ paramString 
				+ " --outputfile=" + Configuration.getTempfiledir() + "result/" + fileName 
				+ " " + Configuration.getTempfiledir() + fileName); 

		log.info("The execute String: " + executeString);
		try{
			//Process proc = java.lang.Runtime.getRuntime().exec("echo " + executeString);
			Process proc = java.lang.Runtime.getRuntime().exec(executeString);
			int exitState = proc.waitFor();
			InputStream stout = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(stout);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            StringBuffer lineBuffer = new StringBuffer();
            while ((line = br.readLine()) != null){
                lineBuffer.append(line + "\n");
            }
            log.info("STOUT: " + lineBuffer.toString());
            log.info("Exit State: " + exitState);
		}catch(Exception Exc){
			log.error(Exc);
		}	
		// TODO: das Ausführen des PDFA Tools kann etwas dauern... was mache
		// ich um festzustellen, dass Tool seine Arbeit beendet hat? 		
	}
}
