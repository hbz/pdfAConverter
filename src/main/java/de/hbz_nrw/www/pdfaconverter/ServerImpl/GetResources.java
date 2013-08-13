/**
 * GetResources.java - This file is part of the DiPP Project by hbz
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

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.apache.log4j.Logger;

import de.hbz_nrw.www.pdfaconverter.util.PilotResult;
import de.hbz_nrw.www.pdfaconverter.util.PilotResultList;

/**
 * Class GetResources
 * 
 * <p><em>Title: </em></p>
 * <p>Description: </p>
 * 
 * @author aquast, email
 * creation date: 08.08.2013
 *
 */
@Path("/api/getResource")
public class GetResources {

	// Initiate Logger for GetResources
	private static Logger log = Logger.getLogger(GetResources.class);
	private ArrayList<PilotResult> rList = new ArrayList<PilotResult>();;
	
	@GET
	public ArrayList<PilotResult> getResourceList(){
		File dir = new File(Configuration.getResultDirPath() + "/" + Configuration.getUserDir() + "/");
		String[] resultList = dir.list(new FileFilter(".pdf"));
		for(int i = 0; i < resultList.length; i++){
			log.info(resultList[i]);
			PilotResult pRes = new PilotResult();
			pRes.setResultFileUrl(Configuration.getResultDirUrl() + "/" + resultList[i]);
			rList.add(pRes);
		}
		
		PilotResultList result = new PilotResultList();
		result.setPilotResultList(rList);
		return rList;
	}
	
	class FileFilter implements FilenameFilter{

		public FileFilter(String filter){
		 fFilter = filter;	
		}
		
		private String fFilter = null;
		
		@Override
		public boolean accept(File dir, String name) {
			return name.endsWith(fFilter);
		}
		
		
	}

}
