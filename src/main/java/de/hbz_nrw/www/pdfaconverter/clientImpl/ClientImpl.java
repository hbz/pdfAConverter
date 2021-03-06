/**
 * ClientImpl.java - This file is part of the DiPP Project by hbz
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
package de.hbz_nrw.www.pdfaconverter.clientImpl;

import java.rmi.RemoteException;

import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.log4j.Logger;

import de.hbz_nrw.www.pdfaconverter.services.BatchConvert;
import de.hbz_nrw.www.pdfaconverter.services.BatchConvertFaultException0;
import de.hbz_nrw.www.pdfaconverter.services.BatchConvertResponse;
import de.hbz_nrw.www.pdfaconverter.services.ConvertFromAttachment_faultMsg;
import de.hbz_nrw.www.pdfaconverter.services.ConvertFromStream_faultMsg;
import de.hbz_nrw.www.pdfaconverter.services.ConvertFromUrl_faultMsg;
import de.hbz_nrw.www.pdfaconverter.services.PdfAConverter;
import de.hbz_nrw.www.pdfaconverter.services.PdfAConverterCallbackHandler;
import de.hbz_nrw.www.pdfaconverter.services.PdfAConverterStub;
import de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment;
import de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachmentResponse;
import de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream;
import de.hbz_nrw.www.pdfaconverter.types.ConvertFromStreamResponse;
import de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl;
import de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrlResponse;

/**
 * Class ClientImpl
 * 
 * <p><em>Title: </em></p>
 * <p>Description: </p>
 * 
 * @author Andres Quast, quast@hbz-nrw.de
 * creation date: 30.09.2009
 *
 */
public class ClientImpl implements PdfAConverter {

	// Initiate Logger for ClientImpl
	private static Logger log = Logger.getLogger(ClientImpl.class);

	// get the WS Stub for connecting with the WebServices 
	private PdfAConverterStub getStub(){
				PdfAConverterStub stub = null;
		try{
			//stub = new PdfAConverterStub("http://nyx.hbz-nrw.de/pfda");
			stub = new PdfAConverterStub("http://nyx.hbz-nrw.de:8080/axis2/services/PdfAConverter");
			//stub = new PdfAConverterStub("http://melpomene.hbz-nrw.de:8081/axis2/services/PdfAConverter");
			
			// batchConverter needs a lot of time...
			// TODO: make batchConverter asynchronous
			long timeout = 900000;
			stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(timeout);
		}catch(Exception e){
			log.error(e);
		}
		return stub;
	}
	/* (non-Javadoc)
	 * @see de.hbz_nrw.www.pdfaconverter.services.PdfAConverter#convertFromAttachment(de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment)
	 */
	@Override
	public ConvertFromAttachmentResponse convertFromAttachment(
			ConvertFromAttachment convertFromAttachment44)
			throws RemoteException, ConvertFromAttachment_faultMsg {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see de.hbz_nrw.www.pdfaconverter.services.PdfAConverter#convertFromStream(de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream)
	 */
	@Override
	public ConvertFromStreamResponse convertFromStream(
			ConvertFromStream convertFromStream46) throws RemoteException,
			ConvertFromStream_faultMsg {
		ConvertFromStreamResponse response = null;
		// Call stub method
		// Delegate Exceptions from method to calling method
		response = getStub().convertFromStream(convertFromStream46);
		return response;
	}

	/* (non-Javadoc)
	 * @see de.hbz_nrw.www.pdfaconverter.services.PdfAConverter#convertFromUrl(de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl)
	 */
	@Override
	public ConvertFromUrlResponse convertFromUrl(ConvertFromUrl convertFromUrl42)
			throws RemoteException, ConvertFromUrl_faultMsg {
		ConvertFromUrlResponse response = null;
		
		// Call stub method
		// Delegate Exceptions from method to calling method
		response = getStub().convertFromUrl(convertFromUrl42);
		log.info(response);
		return response;
	}

	@Override
	public BatchConvertResponse batchConvert(BatchConvert batchConvert4)
			throws RemoteException, BatchConvertFaultException0 {
		BatchConvertResponse response = null;

		// Call stub method
		// Delegate Exceptions from method to calling method
		response = getStub().batchConvert(batchConvert4);
		log.info(response);
		return response;
	}

	/* (non-Javadoc)
	 * @see de.hbz_nrw.www.pdfaconverter.services.PdfAConverter#startconvertFromAttachment(de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment, de.hbz_nrw.www.pdfaconverter.services.PdfAConverterCallbackHandler)
	 */
	@Override
	public void startconvertFromAttachment(
			ConvertFromAttachment convertFromAttachment44,
			PdfAConverterCallbackHandler callback) throws RemoteException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see de.hbz_nrw.www.pdfaconverter.services.PdfAConverter#startconvertFromStream(de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream, de.hbz_nrw.www.pdfaconverter.services.PdfAConverterCallbackHandler)
	 */
	@Override
	public void startconvertFromStream(ConvertFromStream convertFromStream46,
			PdfAConverterCallbackHandler callback) throws RemoteException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see de.hbz_nrw.www.pdfaconverter.services.PdfAConverter#startconvertFromUrl(de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl, de.hbz_nrw.www.pdfaconverter.services.PdfAConverterCallbackHandler)
	 */
	@Override
	public void startconvertFromUrl(ConvertFromUrl convertFromUrl42,
			PdfAConverterCallbackHandler callback) throws RemoteException {
		// TODO Auto-generated method stub

	}
	@Override
	public void startbatchConvert(BatchConvert batchConvert4,
			PdfAConverterCallbackHandler callback) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
