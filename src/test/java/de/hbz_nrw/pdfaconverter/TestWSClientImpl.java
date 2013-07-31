/**
 * TestWSClientImpl.java - This file is part of the DiPP Project by hbz
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

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.junit.Test;

import de.hbz_nrw.www.pdfaconverter.clientImpl.ClientImpl;
import de.hbz_nrw.www.pdfaconverter.fileUtils.FileUtil;
import de.hbz_nrw.www.pdfaconverter.services.BatchConvert;
import de.hbz_nrw.www.pdfaconverter.services.BatchConvertResponse;
import de.hbz_nrw.www.pdfaconverter.types.CompliancyLevelType;
import de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment;
import de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachmentResponse;
import de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream;
import de.hbz_nrw.www.pdfaconverter.types.ConvertFromStreamResponse;
import de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl;
import de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrlResponse;
import de.hbz_nrw.www.pdfaconverter.types.HtmlOptionType;
import de.hbz_nrw.www.pdfaconverter.types.ParameterType;
import de.hbz_nrw.www.pdfaconverter.types.ReportFormatType;
import de.hbz_nrw.www.pdfaconverter.types.ReportLangType;
import de.hbz_nrw.www.pdfaconverter.types.ReportTriggerType;

/**
 * Class TestWSClientImpl
 * 
 * <p><em>Title: </em></p>
 * <p>Description: </p>
 * 
 * @author Andres Quast, quast@hbz-nrw.de
 * creation date: 30.09.2009
 *
 */
public class TestWSClientImpl {

	// Initiate Logger for TestWSClientImpl
	private static Logger log = Logger.getLogger(TestWSClientImpl.class);
	private ClientImpl cImpl = new ClientImpl();

	@Test public void convertFromUrl(){
		ConvertFromUrlResponse response = null; 

		/** Prepare a Url Request **/
		// create ConvertFromUrl Request 
		ConvertFromUrl convUrl = new ConvertFromUrl();
		convUrl.setCompliancyLevel("1a");
		convUrl.setReportType("HTML");
		convUrl.setConvertFrom("http://www.zeitenblicke.de/2009/2/wunder/dippArticle.pdf");
		//convUrl.setUrl("http://www.zeitenblicke.de/2009/2/wunder/dippArticle.pdf");
		
		/** Call the client with the previously generated request **/
		try{
			response = cImpl.convertFromUrl(convUrl);
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
		
		System.out.println("Ergebnis Url: " + response.getResponseDocumentUrl());
		System.out.println("Ergebnis Report: " + response.getReportUrl());
		System.out.println("Ergebnis Wert: " + response.getResult());
		
	}
	
	@Test public void batchConvert(){
		BatchConvertResponse response = null; 

		/** Prepare a batch Request **/

		BatchConvert bConv = new BatchConvert();
		bConv.setDocumentsFile("http://131.220.138.195/pdfATests/batch.txt");
		bConv.setParameterFile("http://131.220.138.195/pdfATests/param.txt");
		bConv.setUser("bla");
		bConv.setPassword("bla");
		/** Call the client with the previously generated request **/
		log.info("starting BatchRequest");
		try{
			response = cImpl.batchConvert(bConv);
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
		
		/*
		float test = 0;
		float anteil = 12;
		float gesamt = 81;
		
		test = anteil/gesamt;
		NumberFormat.getPercentInstance().format(test);

		log.info(NumberFormat.getPercentInstance().format(test));
		*/
		
		log.info("Batch-Ergebnis Datei: " + response.getResultsFile());
		
		
	}

	@Test public void convertFromStream(){
		
		ConvertFromStreamResponse response = null; 

		/** Prepare a Url Request **/
		ConvertFromStream convStream = new ConvertFromStream();
		convStream.setConverterParameters(getParams());
		
		InputStream is = getClass().getResourceAsStream("/simple_test.pdf") ;
		BufferedInputStream bis = new BufferedInputStream(is);
		ByteArrayOutputStream bat = new ByteArrayOutputStream();
		
		int i = 0;
		try {
			while((i = bis.read()) != -1){
				bat.write(i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		byte[] bStream = bat.toByteArray();
		// parse stream into Base64 String 
		String stream64 = null;
		try {
			byte[] bStream64 = Base64.encodeBase64(bStream);
			stream64 = new String(bStream64, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			log.error(e1);
		}
		convStream.setByteStream(stream64);

		/** Call the client with the previously generated request **/
		try{
			response = cImpl.convertFromStream(convStream);
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
		
		System.out.println("Ergebnis Stream: " + response.getResponseDocumentStream());
		
	}
	
	/**
	 * <p><em>Title: </em></p>
	 * <p>Description: </p>
	 * 
	 * @param args 
	 */
	public static void main(String[] args) {
		TestWSClientImpl test = new TestWSClientImpl();
		//test.convertFromUrl();
		test.batchConvert();
		//test.convertFromStream();
				
		
	}

	public ParameterType getParams(){
		// create ParameterType
		ParameterType param = new ParameterType();
		param.setReturnOnlyValidPDFA(true);
		//param.setAnalyseOnly(true);
		param.setCompliancyLevel(CompliancyLevelType.value1);
		param.setQuickProcessing(true);
		param.setReportLang(ReportLangType.DE);
		param.setReportTrigger(ReportTriggerType.ALWAYS);
		param.addReportFormat(ReportFormatType.XML);
		//param.addReportFormat(ReportFormatType.MHT);
		param.addReportFormat(ReportFormatType.HTML);
		param.addHtmlReportOptions(HtmlOptionType.NODETAILS);
		//param.addHtmlReportOptions(HtmlOptionType.NOICONS);
		//param.addHtmlReportOptions(HtmlOptionType.OPENRESULT);

		return param;
	}
}
