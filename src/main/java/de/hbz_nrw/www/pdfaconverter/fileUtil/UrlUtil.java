/**
 * UrlUtil.java - This file is part of the DiPP Project by hbz
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
package de.hbz_nrw.www.pdfaconverter.fileUtil;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import de.hbz_nrw.www.pdfaconverter.ServerImpl.Configuration;

/**
 * Class UrlUtil
 * 
 * <p><em>Title: </em></p>
 * <p>Description: </p>
 * 
 * @author aquast, email
 * creation date: 11.01.2012
 *
 */
public class UrlUtil {

	// Initiate Logger for UrlUtil
	private static Logger log = Logger.getLogger(UrlUtil.class);
	private byte[] stream = null;
	//String reportString;
	private String fileName;

	/**
	 * <p><em>Title: </em></p>
	 * <p>Description: </p>
	 *  
	 */
	private void setStream(String reportString){
		try {
			stream = reportString.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.error(e);
		}
		
	}
	
	/**
	 * <p><em>Title: </em></p>
	 * <p>Description: parses the report stream for getting the filename used on nyx for conversion</p>
	 * 
	 * @return 
	 */
	private String getFileName(){
		//find filename in String to create an URL for displaying the Reportfile from nyx 
		Pattern p = Pattern.compile("\\d{8}T\\d{9}Z\\.pdf");
		Matcher m = p.matcher(new String(Base64.decodeBase64(stream)));
		m.find();
		fileName = new String(Base64.decodeBase64(stream)).substring(m.start(), m.end());
		return fileName;		
	}

	public String getTempDirUrl(){
		return Configuration.getTempDirUrl() + "result/" + fileName;
	}

}
