/**
 * 
 */
package de.hbz_nrw.www.pdfaconverter.util;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author aquast
 *
 */
@XmlRootElement
public class PilotResult {

	//public default constructor required?
	public PilotResult(){
		  
	}
		  
	private String inputFileUrl = null;
	private String resultFileUrl = null;
	private String exitState = null;
	private String reportFileUrl = null;
	
	/**
	 * @return the recordFileUrl
	 */
	public String getReportFileUrl() {
		return reportFileUrl;
	}
	/**
	 * @param recordFileUrl the recordFileUrl to set
	 */
	public void setReportFileUrl(String reportFileUrl) {
		this.reportFileUrl = reportFileUrl;
	}
	public String getInputFileUrl() {
		return inputFileUrl;
	}
	public void setInputFileUrl(String inputFileUrl) {
		this.inputFileUrl = inputFileUrl;
	}
	public String getResultFileUrl() {
		return resultFileUrl;
	}
	public void setResultFileUrl(String resultFileUrl) {
		this.resultFileUrl = resultFileUrl;
	}
	public String getExitState() {
		return exitState;
	}
	public void setExitState(String exitState) {
		this.exitState = exitState;
	}
		  
		  
}

