/**
 * 
 */
package de.hbz_nrw.www.pdfaconverter.util;

import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * @author aquast
 *
 */
@XmlRootElement
public class PilotParameter {

	public PilotParameter() {

	}
	// set Processing Params
	private String returnOnlyValidPdfA = null;
	private boolean quickProcessing = true;
	private boolean analyseOnly = false;
	private boolean createEpub = false;
	private String 	compliancyLevel = "1b";
	
	private boolean forceConversionReconvert = false;
	private boolean forceConversionPagesToImages = false;
	private boolean forceConversionDocToImages = false;
	
	
	//set Reporting Params
	private String 	reportTrigger = "ALWAYS";
	private String 	reportLang = "DE";
	private boolean htmlReport = true;
	private boolean htmlOpenResult = true;
	private boolean htmlNoIcons = false;
	private boolean xmlReport = false;
	/**
	 * @return the returnOnlyValidPdfA
	 */
	public String getReturnOnlyValidPdfA() {
		return returnOnlyValidPdfA;
	}
	/**
	 * @param returnOnlyValidPdfA the returnOnlyValidPdfA to set
	 */
	public void setReturnOnlyValidPdfA(String returnOnlyValidPdfA) {
		this.returnOnlyValidPdfA = returnOnlyValidPdfA;
	}
	/**
	 * @return the quickProcessing
	 */
	public boolean isQuickProcessing() {
		return quickProcessing;
	}
	/**
	 * @param quickProcessing the quickProcessing to set
	 */
	public void setQuickProcessing(boolean quickProcessing) {
		this.quickProcessing = quickProcessing;
	}
	/**
	 * @return the analyseOnly
	 */
	public boolean isAnalyseOnly() {
		return analyseOnly;
	}
	/**
	 * @param analyseOnly the analyseOnly to set
	 */
	public void setAnalyseOnly(boolean analyseOnly) {
		this.analyseOnly = analyseOnly;
	}
	/**
	 * @return the createEpub
	 */
	public boolean isCreateEpub() {
		return createEpub;
	}
	/**
	 * @param createEpub the createEpub to set
	 */
	public void setCreateEpub(boolean createEpub) {
		this.createEpub = createEpub;
	}
	/**
	 * @return the compliancyLevel
	 */
	public String getCompliancyLevel() {
		return compliancyLevel;
	}
	/**
	 * @param compliancyLevel the compliancyLevel to set
	 */
	public void setCompliancyLevel(String compliancyLevel) {
		this.compliancyLevel = compliancyLevel;
	}
	/**
	 * @return the forceConversionReconvert
	 */
	public boolean isForceConversionReconvert() {
		return forceConversionReconvert;
	}
	/**
	 * @param forceConversionReconvert the forceConversionReconvert to set
	 */
	public void setForceConversionReconvert(boolean forceConversionReconvert) {
		this.forceConversionReconvert = forceConversionReconvert;
	}
	/**
	 * @return the forceConversionPagesToImages
	 */
	public boolean isForceConversionPagesToImages() {
		return forceConversionPagesToImages;
	}
	/**
	 * @param forceConversionPagesToImages the forceConversionPagesToImages to set
	 */
	public void setForceConversionPagesToImages(boolean forceConversionPagesToImages) {
		this.forceConversionPagesToImages = forceConversionPagesToImages;
	}
	/**
	 * @return the forceConversionDocToImages
	 */
	public boolean isForceConversionDocToImages() {
		return forceConversionDocToImages;
	}
	/**
	 * @param forceConversionDocToImages the forceConversionDocToImages to set
	 */
	public void setForceConversionDocToImages(boolean forceConversionDocToImages) {
		this.forceConversionDocToImages = forceConversionDocToImages;
	}
	/**
	 * @return the reportTrigger
	 */
	public String getReportTrigger() {
		return reportTrigger;
	}
	/**
	 * @param reportTrigger the reportTrigger to set
	 */
	public void setReportTrigger(String reportTrigger) {
		this.reportTrigger = reportTrigger;
	}
	/**
	 * @return the reportLang
	 */
	public String getReportLang() {
		return reportLang;
	}
	/**
	 * @param reportLang the reportLang to set
	 */
	public void setReportLang(String reportLang) {
		this.reportLang = reportLang;
	}
	/**
	 * @return the htmlReport
	 */
	public boolean isHtmlReport() {
		return htmlReport;
	}
	/**
	 * @param htmlReport the htmlReport to set
	 */
	public void setHtmlReport(boolean htmlReport) {
		this.htmlReport = htmlReport;
	}
	/**
	 * @return the htmlOpenResult
	 */
	public boolean isHtmlOpenResult() {
		return htmlOpenResult;
	}
	/**
	 * @param htmlOpenResult the htmlOpenResult to set
	 */
	public void setHtmlOpenResult(boolean htmlOpenResult) {
		this.htmlOpenResult = htmlOpenResult;
	}
	/**
	 * @return the htmlNoIcons
	 */
	public boolean isHtmlNoIcons() {
		return htmlNoIcons;
	}
	/**
	 * @param htmlNoIcons the htmlNoIcons to set
	 */
	public void setHtmlNoIcons(boolean htmlNoIcons) {
		this.htmlNoIcons = htmlNoIcons;
	}
	/**
	 * @return the xmlReport
	 */
	public boolean isXmlReport() {
		return xmlReport;
	}
	/**
	 * @param xmlReport the xmlReport to set
	 */
	public void setXmlReport(boolean xmlReport) {
		this.xmlReport = xmlReport;
	}
	/**
	 * @return the mhtReport
	 */
	public boolean isMhtReport() {
		return mhtReport;
	}
	/**
	 * @param mhtReport the mhtReport to set
	 */
	public void setMhtReport(boolean mhtReport) {
		this.mhtReport = mhtReport;
	}
	private boolean mhtReport = false;
		
	

}
