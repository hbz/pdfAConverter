/**
 * BatchFileUtil.java - This file is part of the DiPP Project by hbz
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Class BatchFileUtil
 * 
 * <p><em>Title: </em></p>
 * <p>Description: </p>
 * 
 * @author aquast, email
 * creation date: 24.07.2013
 *
 */
public class BatchFileUtil {

	// Initiate Logger for BatchFileUtil
	private static Logger log = Logger.getLogger(BatchFileUtil.class);


	public static List<String> readBatchFile(File batchFile) throws IOException{
		List<String> documentFile = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(batchFile);
		BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			String documentUrl = "";
			String line = null;
			int i = 0;
			while ( (line = reader.readLine()) != null){
				i++;
				// ignore comment lines
				if(!line.startsWith("#")){	//is needed due to implementation of Datestamps
					String[] item = line.split("\\s");  // array of pid and label
					if (item[0].startsWith("http://")){
						documentUrl = item[0];
						documentFile.add(documentUrl);
					}else{
						log.error("Line " + i + " does not provide a correct Document Url!");
					}
				}
			}
			reader.close();
			return documentFile;
	}
}
