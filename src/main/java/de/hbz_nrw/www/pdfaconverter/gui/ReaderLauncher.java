/**
 * BrowserLauncher.java - This file is part of the DiPP Project by hbz
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
package de.hbz_nrw.www.pdfaconverter.gui;

import org.apache.log4j.Logger;
import java.io.IOException;

/**
 * Class BrowserLauncher
 * 
 * <p><em>Title: Launch a Browser from system to display Reports </em></p>
 * <p>Description: </p>
 * 
 * @author aquast, email
 * creation date: 11.01.2010
 *
 */
public class ReaderLauncher {

	// Initiate Logger for ReaderLauncher
	private static Logger log = Logger.getLogger(ReaderLauncher.class);

	private static String url;
	
	public static void launch() {
	    try {
	        if (isWindows()) {
	            Runtime.getRuntime().exec( "rundll32 url.dll,FileProtocolHandler "
	            + url );
	        } else {
	            Runtime.getRuntime().exec("firefox " + url);
	        }
	    } catch (IOException ioe) {
	        ioe.printStackTrace();
	    }
	}


	public static boolean isWindows() {
	    String os = System.getProperty("os.name");
	        if ( os != null && os.startsWith("Windows")) {
	        return true;
	    } else {
	        return false;
	    }
	}
	
	public static String setUrl(String Url){
		url = Url;
		return url;
	}
}
