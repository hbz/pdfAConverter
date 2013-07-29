/**
 * TestStartRestServer.java - This file is part of the DiPP Project by hbz
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
import com.sun.net.httpserver.*;

import de.hbz_nrw.www.pdfaconverter.ServerImpl.JerseyServiceImpl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;;


/**
 * Class TestStartRestServer
 * 
 * <p><em>Title: </em></p>
 * <p>Description: </p>
 * 
 * @author aquast, email
 * creation date: 29.07.2013
 *
 */
public class TestStartRestServer {

	// Initiate Logger for TestStartRestServer
	private static Logger log = Logger.getLogger(TestStartRestServer.class);

	//TODO: make it run as expected :-(
	//@Test
	public void serverStart(){
		try {
			
			HttpServer server = HttpServer.create(new InetSocketAddress(InetAddress.getLocalHost(), 8081), 3);
			server.start();
		
			JerseyServiceImpl sImpl = new JerseyServiceImpl();
			log.info(server.getAddress());

			
			server.stop(100);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}	
	
	
	public static void main(String[] args){
		TestStartRestServer testServer = new TestStartRestServer();
		testServer.serverStart();
		
	}

}
