/**
 * 
 */
package de.hbz_nrw.www.pdfaconverter.gui;

import org.apache.log4j.Logger;

import de.hbz_nrw.www.pdfaconverter.ServerImpl.Configuration;

/**
 * @author aquast
 *
 */
public class guiStart {

	//get Logger Instance
	Logger log = Logger.getLogger(guiStart.class);

	
	public guiStart(){
		Configuration.initLog();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		guiStart gStart = new guiStart();
		clientGui gui = new clientGui();
		gui.guiCreator();
	}

}
