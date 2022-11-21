/**
 * 
 */
package de.hbz_nrw.www.pdfaconverter.util;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PilotResultList {
	//public default constructor
	public PilotResultList(){
		  
	}
	private ArrayList<PilotResult> pilotResultList = new ArrayList<PilotResult>();
	private String totalNumberOfJobs = null;
	private String countSuccess = null;
	private String percentSuccess = null;
	private String resultLogFileUrl = null;
	/**
	 * @return the pilotResultList
	 */
	public ArrayList<PilotResult> getPilotResultList() {
		return pilotResultList;
	}
	/**
	 * @param pilotResultList the pilotResultList to set
	 */
	public void setPilotResultList(ArrayList<PilotResult> pilotResultList) {
		this.pilotResultList = pilotResultList;
	}
	/**
	 * @param pilotResultList the pilotResultList to set
	 */
	public void addPilotResultList(ArrayList<PilotResult> pilotResultList) {
		this.pilotResultList.addAll(pilotResultList);
	}

	/**
	 * @return the totalNumberOfJobs
	 */
	public String getTotalNumberOfJobs() {
		return totalNumberOfJobs;
	}
	/**
	 * @param totalNumberOfJobs the totalNumberOfJobs to set
	 */
	public void setTotalNumberOfJobs(String totalNumberOfJobs) {
		this.totalNumberOfJobs = totalNumberOfJobs;
	}
	/**
	 * @return the countSuccess
	 */
	public String getCountSuccess() {
		return countSuccess;
	}
	/**
	 * @param countSuccess the countSuccess to set
	 */
	public void setCountSuccess(String countSuccess) {
		this.countSuccess = countSuccess;
	}
	/**
	 * @return the percentSuccess
	 */
	public String getPercentSuccess() {
		return percentSuccess;
	}
	/**
	 * @param percentSuccess the percentSuccess to set
	 */
	public void setPercentSuccess(String percentSuccess) {
		this.percentSuccess = percentSuccess;
	}
	/**
	 * @return the resultLogFileUrl
	 */
	public String getResultLogFileUrl() {
		return resultLogFileUrl;
	}
	/**
	 * @param resultLogFileUrl the resultLogFileUrl to set
	 */
	public void setResultLogFileUrl(String resultLogFileUrl) {
		this.resultLogFileUrl = resultLogFileUrl;
	}
	


}
