/**
 * TestConfiguration.java - This file is part of the DiPP Project by hbz
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

import org.apache.log4j.Logger;
import org.junit.Test;

import de.hbz_nrw.www.pdfaconverter.ServerImpl.Configuration;

/**
 * Class TestConfiguration
 * 
 * <p><em>Title: </em></p>
 * <p>Description: </p>
 * 
 * @author aquast, email
 * creation date: 05.08.2013
 *
 */
public class TestConfiguration {

	// Initiate Logger for TestConfiguration
	private static Logger log = Logger.getLogger(TestConfiguration.class);

	@Test
	public void testConfiguration(){

		//Configuration conf = new Configuration();
		//Configuration.initLog();
		log.info(Configuration.getTempDirUrl());
		log.info(Configuration.getResultDirUrl());
		log.info(Configuration.getTempDirPath());
		log.info(Configuration.getResultDirPath());
		log.info(Configuration.getWorkingDir());
		log.info(System.getProperty("user.dir"));
	}
	
	/**
	 * <p><em>Title: </em></p>
	 * <p>Description: </p>
	 * 
	 * @param args 
	 */
	public static void main(String[] args) {

		TestConfiguration testConf = new TestConfiguration();
		testConf.testConfiguration();
		
		
		
	}
}
