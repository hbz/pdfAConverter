/**
 * TestWSServerImpl.java - This file is part of the DiPP Project by hbz
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
package de.hbz_nrw.pdfaconverter;

import org.apache.axis2.builder.DiskFileDataSource;
import org.apache.log4j.Logger;

import de.hbz_nrw.www.pdfaconverter.ServerImpl.*;
import de.hbz_nrw.www.pdfaconverter.fileUtil.FileUtil;
import de.hbz_nrw.www.pdfaconverter.services.ConvertFromStream_faultMsg;
import de.hbz_nrw.www.pdfaconverter.types.*;

import org.apache.commons.codec.binary.Base64;

import java.io.*;

import javax.activation.DataHandler;

/**
 * Class TestWSServerImpl
 * 
 * <p><em>Title: A class for testing the PdfAConverter WebService Server Implementation</em></p>
 * <p>Description: </p>
 * 
 * @author aquast, email
 * creation date: 24.09.2009
 *
 */
public class TestWSServerImpl {

	// Initiate Logger for TestWSServerImpl
	private static Logger log = Logger.getLogger(TestWSServerImpl.class);

	/**
	 * <p><em>Title: </em></p>
	 * <p>Description: </p>
	 * 
	 * @param args 
	 */
	public static void main(String[] args) {
		ServicesImpl sImpl = new ServicesImpl();
		
		
		ConvertFromAttachmentResponse response = null; 
		
		// create ParameterType
		ParameterType param = new ParameterType();
		param.setReturnOnlyValidPDFA(true);
		param.setAnalyseOnly(true);
		param.setCompliancyLevel(CompliancyLevelType.value2);
		param.setQuickProcessing(true);
		param.setReportLang(ReportLangType.DE);
		param.setReportTrigger(ReportTriggerType.ALWAYS);
		param.addReportFormat(ReportFormatType.XML);
		param.addReportFormat(ReportFormatType.MHT);
		param.addReportFormat(ReportFormatType.HTML);
		param.addHtmlReportOptions(HtmlOptionType.NODETAILS);
		param.addHtmlReportOptions(HtmlOptionType.NOICONS);
		param.addHtmlReportOptions(HtmlOptionType.OPENRESULT);

		
		// create ConvertFromAttachment Request 
		ConvertFromAttachment convAttach = new ConvertFromAttachment();
		convAttach.setConverterParameters(param);
		
		// create ConvertFromUrl Request 
		ConvertFromUrl convUrl = new ConvertFromUrl();
		convUrl.setCompliancyLevel("1a");
		//convUrl.setConverterParameters(param);
		//convUrl.setUrl("http://www.zeitenblicke.de/2009/2/wunder/dippArticle.pdf");
		//convUrl.setCompliancyLevel("1b");
		//convUrl.setReportType("html");
		//convUrl.setForceConvLevel("3");

		// create ConvertFromUrl Request 
		ConvertFromStream convStream = new ConvertFromStream();
		convStream.setConverterParameters(param);
	
		// create a Teststream for convertFromStream Operation
		//File origPdfFile = new File("simple_test.pdf");
		//System.out.println("File-Size 1: " + origPdfFile.length());
		
		// load a test file and create a bytestream of this
		// stream is encoded to Base64
		//byte[] stream = FileUtil.loadFileIntoStream(origPdfFile);
		//System.out.println("Stream-Size 1 unkodiert: " + stream.length);
		
		// parse stream into String 
		/*String test = null;
		boolean is64 = false;
		try {
			is64= Base64.isArrayByteBase64(stream);
			test = new String(stream, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			log.error(e1);
		}
		log.debug("InputStream = " + is64);
		convStream.setByteStream(test);
		
		// das nächste ist nicht richtig!!! die Objecttypen stimmen nicht
		// DataHandler documentHandler = convAttach.getDocument().getData();
		// String fileName = convAttach.getDocument().getName();

		*/
		try{
			sImpl.convertFromUrl(convUrl);
			//sImpl.convertFromStream(convStream);
			//response = sImpl.convertFromAttachment(convAttach);
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
		
	}
}
