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
import java.io.BufferedInputStream;
import java.io.FileInputStream;
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

import de.hbz_nrw.www.pdfaconverter.fileUtil.BatchFileUtil;
import de.hbz_nrw.www.pdfaconverter.fileUtil.FileUtil;
import de.hbz_nrw.www.pdfaconverter.services.BatchConvert;
import de.hbz_nrw.www.pdfaconverter.services.BatchConvertResponse;
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
import de.hbz_nrw.www.pdfaconverter.util.PdfAPilotParameters;
import de.hbz_nrw.www.pdfaconverter.util.TimePrefix;

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
	@Override
	public ConvertFromAttachmentResponse convertFromAttachment(
			ConvertFromAttachment convertFromAttachment)
			throws ConvertFromAttachment_faultMsg {
		// TODO Auto-generated method stub
		
		DataHandler documentHandler = convertFromAttachment.getDocument().getData();
		String fileName = convertFromAttachment.getDocument().getName();
		//pdfOriginal.
		
		// connect Parameters to a generic method that parses them into
		// read line parameters
		String paramString = PdfAPilotParameters.createParameterString(fileName, convertFromAttachment.getConverterParameters());
		log.debug("created paramString: " + paramString);
		return null;
	}

	/* (non-Javadoc)
	 * @see de.hbz_nrw.www.pdfaconverter.services.PdfAConverterSkeletonInterface#convertFromStream(de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream)
	 */
	@Override
	public ConvertFromStreamResponse convertFromStream(
			ConvertFromStream convertFromStream)
			throws ConvertFromStream_faultMsg {
		
		ConvertFromStreamResponse response= new ConvertFromStreamResponse();
		
		//create a unique temporary file prefix 
		String jobIdent  = TimePrefix.getTimePrefix();
		String fileIdent = jobIdent + ".pdf";

		// connect Parameters to a generic method that parses them into
		// read line parameters
		String paramString = PdfAPilotParameters.createParameterString(fileIdent, convertFromStream.getConverterParameters());
		log.debug("created paramString: " + paramString);
		
		// Write incoming PDF-Base64 Stream as file into temporary Directory
		String fileName = FileUtil.saveStreamToTempFile(fileIdent, convertFromStream.getByteStream());
		
		new PilotRunner().executePdfATool(paramString, fileName);
		
		//now create Response from temp dir content
		byte[] stream = null;
		if(new File(Configuration.getTempDirPath() + "result/" + fileName).isFile()){
			stream = FileUtil.loadFileIntoStream(new File(Configuration.getTempDirPath() + "result/" + fileName));

			try{
				response.setResponseDocumentStream(new String(stream, "UTF-8"));
			}catch(Exception e){
			 log.error("Problems with generating files from streams:" + e);	
			}
		
		}

		List<byte[]> reportStreams = new Vector<byte[]>();
		if(new File(Configuration.getTempDirPath() + "result/" + fileName.replace(".pdf", ".html")).isFile()){
			reportStreams.add(FileUtil.loadFileIntoStream(new File(Configuration.getTempDirPath() + "result/" + fileName.replace(".pdf", ".html"))));
		}
		if(new File(Configuration.getTempDirPath() + "result/" + fileName.replace(".pdf", ".xml")).isFile()){
			reportStreams.add(FileUtil.loadFileIntoStream(new File(Configuration.getTempDirPath() + "result/" + fileName.replace(".pdf", ".xml"))));
		}
		if(new File(Configuration.getTempDirPath() + "result/" + fileName.replace(".pdf", ".mht")).isFile()){
			reportStreams.add(FileUtil.loadFileIntoStream(new File(Configuration.getTempDirPath() + "result/" + fileName.replace(".pdf", ".mht"))));
		}
		
		Iterator<byte[]> it = reportStreams.iterator();
		while(it.hasNext()){
			try{
				response.addReportStream(new String(it.next(), "UTF-8"));
			}catch(Exception e){
			 log.error("Problems with generating files from streams:" + e);	
			}
		}
		response.setJobIdentifier(jobIdent);
		return response;
	}

	@Override
	public BatchConvertResponse batchConvert(BatchConvert batchConvert) {
		// TODO Auto-generated method stub
		BatchConvertResponse batchResponse = new BatchConvertResponse(); 
		String paramString = null;
		String fileName = null;

		//create unique directory identifier
		String fileIdent = TimePrefix.getTimePrefix();

		String batchFileName = FileUtil.saveUrlToFile(fileIdent + "_batch.txt", batchConvert.getDocumentsFile());
		String paramFileName = FileUtil.saveUrlToFile(fileIdent + "_param.txt", batchConvert.getParameterFile());
		List<String> documentList = null;
		ParameterType paramType = null;
		
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
		StringBuffer resultBuffer = new StringBuffer();

		log.info("Starting Batch Job");
		Iterator<String> it = documentList.iterator();
		while(it.hasNext()){
			String fileUrl = it.next();
			log.info("File :" + fileUrl);

			//create unique directory identifier
			fileIdent = TimePrefix.getTimePrefix();
			
			// Load File to temp dir
			fileName = FileUtil.saveUrlToFile(fileIdent + ".pdf", fileUrl);
			String reportType = null;
			try {
				//paramString = BatchFileUtil.readBatchFile(new File(Configuration.getTempfiledir() + batchFileName));
				Properties paramProp = PdfAPilotParameters.getDefaultProperties();
				log.info("Reading Parameters File");
	            FileInputStream fis = new FileInputStream(new File(Configuration.getTempDirPath() + paramFileName));
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
			resultBuffer.append(Configuration.getTempDirUrl() + "result" + fileName + " Status-Meldung: " + pRunner.getExitStateStr() +  " " + Configuration.getTempDirUrl() + "result" +fileIdent + "." + reportType +"\n" );
			if(pRunner.getExitStateStr() != null && pRunner.getExitStateStr().equals("0")){
				countSuccess++;
			}			

		}
		
		float percentSuccess = countSuccess/countJobs;

		log.info(resultBuffer.toString());
		FileUtil.saveBase64ByteStringToFile(new File(Configuration.getTempDirPath() + "result" + fileName + ".result"), resultBuffer.toString());
		batchResponse.setResultsFile(Configuration.getTempDirUrl() + "result" + fileName + ".result");
		return batchResponse;
	}

	/* (non-Javadoc)
	 * @see de.hbz_nrw.www.pdfaconverter.services.PdfAConverterSkeletonInterface#convertFromUrl(de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl)
	 */
	public ConvertFromUrlResponse convertFromUrl(ConvertFromUrl convertFromUrl)
			throws ConvertFromUrl_faultMsg {

		ConvertFromUrlResponse response= new ConvertFromUrlResponse();
		
		//create a unique temporary file prefix 
		String fileIdent = TimePrefix.getTimePrefix() + ".pdf";

		// connect Parameters to a generic method that parses them into
		// read line parameters
		String paramString = PdfAPilotParameters.createParameterString(fileIdent, convertFromUrl);
		System.out.println(paramString);
		log.info(paramString);
		
		// copy remote Object to temporary Directory
		String fileName = FileUtil.saveUrlToFile(fileIdent, convertFromUrl.getConvertFrom());
		
		//executeString = "cp " + Configuration.getTempfiledir() + fileName + " " + Configuration.getTempfiledir() + "result_" + fileName;
		
		PilotRunner pRunner = new PilotRunner();
		pRunner.executePdfATool(paramString, fileName);

		URI documentUri = null;
		try {
			documentUri = new URI(Configuration.getTempDirUrl() + "result/" + fileName);
		} catch (MalformedURIException e) {
			e.printStackTrace();
		}
		URI reportUri = null;
		try {
			reportUri = new URI(Configuration.getTempDirUrl() + "result/" + fileName.replace(".pdf", "." + convertFromUrl.getReportType().toLowerCase()));
		} catch (MalformedURIException e) {
			e.printStackTrace();
		}
		response.setResponseDocumentUrl(documentUri);
		response.setReportUrl(reportUri);
		if(pRunner.getExitStateStr() != null && pRunner.getExitStateStr().equals("0")){
			response.setResult("success");
		}else if(pRunner.getExitStateStr() != null && !pRunner.getExitStateStr().equals("0")){
			response.setResult("Conversion to PDFA failed. System returns code: " + pRunner.getExitStateStr());			
		}else{
			response.setResult("System returns unknown state, please contact staff");			
		}
		return response;
	}
	
}
