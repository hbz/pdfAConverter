/**
 * JerseyServerImpl.java - This file is part of the DiPP Project by hbz
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
import java.util.Properties;

import org.apache.log4j.Logger;

import de.hbz_nrw.www.pdfaconverter.fileUtils.FileUtil;
import de.hbz_nrw.www.pdfaconverter.util.TimePrefix;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Class JerseyServerImpl
 * 
 * <p><em>Title: </em></p>
 * <p>Description: </p>
 * 
 * @author aquast, email
 * creation date: 26.07.2013
 *
 */
@Path("convertFromUrl")
public class JerseyServerImpl {

	// Initiate Logger for JerseyServerImpl
	private static Logger log = Logger.getLogger(JerseyServerImpl.class);

	@GET
	@Consumes
	@Produces({MediaType.TEXT_HTML})
	public String convertFromUrl(@QueryParam("fileUrl") String PdfFileUrl, 
			@QueryParam("ParamFileUrl") String ParamFileUrl){

		String pdfFileUrl = PdfFileUrl;
		//create a unique temporary file prefix
		String fileIdent = TimePrefix.getTimePrefix();
		String fileName = FileUtil.saveUrlToFile(fileIdent + ".pdf", pdfFileUrl);
		
		
		
		return "<html> " + "<title>" + "Access to converted file" + "</title>"
		        + "<body><h1>" + "Converted file:" + "</h1>" +
		        	"<ul>" +
		        	"<li>Result: " + fileName + "</li>" +
		        	"<li>From :" + pdfFileUrl + "</li>" +
		        	"</ul></body>" + "</html> ";

	}
	
	/*
	// This method is called if TEXT_PLAIN is request
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	  public String sayPlainTextHello() {
	    return "Hello Jersey";
	  }

	  // This method is called if XML is request
	  @GET
	  @Produces(MediaType.TEXT_XML)
	  public String sayXMLHello() {
	    return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
	  }

	  // This method is called if HTML is request
	  @GET
	  @Produces(MediaType.TEXT_HTML)
	  public String sayHtmlHello() {
	    return "<html> " + "<title>" + "Hello Jersey" + "</title>"
	        + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
	  }
	*/

}
