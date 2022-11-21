/**
 * PilotRunner.java - This file is part of the DiPP Project by hbz
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

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

/**
 * Class PilotRunner
 * 
 * <p><em>Title: </em></p>
 * <p>Description: </p>
 * 
 * @author aquast, email
 * creation date: 29.07.2013
 *
 */
public class PilotRunner {

	// Initiate Logger for PilotRunner
	private static Logger log = Logger.getLogger(PilotRunner.class);
	
	private String exitStateStr= null; 	
	private String stoutStr = null;
	
	/**
	 * <p><em>Title: </em></p>
	 * <p>Description: Method creates the command line string with all parameters given. 
	 * Then executes the shell command </p>
	 * 
	 * @param paramString
	 * @param fileName 
	 */
	public void executePdfATool(String paramString, String fileName){
		// call to execute PDFA-Tool
		
		// Complete execute String 
		String programPath = new String("/opt/pdfapilot/callas_pdfaPilot_CLI_4_x64/pdfaPilot"); 
		String defaultParams = new String("--noprogress --nohits --substitute  " 
				 + "--linkpath=http://pdfa.hbz-nrw.de/pdfa/reporttemplate "
				 + "--fontfolder=/opt/pdfapilot/fontfolder --cachefolder=temp"
				);
		String executeString = new String(programPath + " " 
				+ defaultParams 
				+ paramString 
				+ " --outputfile=" + Configuration.getResultDirPath() + fileName 
				+ " " + Configuration.getTempDirPath() + fileName); 

		log.debug("The execute String: " + executeString);
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
            log.debug("STOUT: " + lineBuffer.toString());
            log.info("Exit State: " + exitState);
            stoutStr = lineBuffer.toString();
            exitStateStr = Integer.toString(exitState);
		}catch(Exception Exc){
			log.error(Exc);
		}
		
		//unlink temp file
		if(new File(Configuration.getTempDirPath() + fileName).isFile()){
			new File(Configuration.getTempDirPath() + fileName).delete();
		}
		// TODO: das Ausführen des PDFA Tools kann etwas dauern... was mache
		// ich um festzustellen, dass Tool seine Arbeit beendet hat? 		
	}

	public String getStoutStr(){
		return stoutStr;
	}

	public String getExitStateStr(){
		return exitStateStr;
	}
}
