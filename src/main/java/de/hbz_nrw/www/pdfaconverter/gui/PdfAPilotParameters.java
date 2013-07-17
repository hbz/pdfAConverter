/**
 * PdfAPilotParameters.java - This file is part of the DiPP Project by hbz
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

import de.hbz_nrw.www.pdfaconverter.types.CompliancyLevelType;
import de.hbz_nrw.www.pdfaconverter.types.HtmlOptionType;
import de.hbz_nrw.www.pdfaconverter.types.ParameterType;
import de.hbz_nrw.www.pdfaconverter.types.ReportFormatType;
import de.hbz_nrw.www.pdfaconverter.types.ReportLangType;
import de.hbz_nrw.www.pdfaconverter.types.ReportTriggerType;

/**
 * Class PdfAPilotParameters
 * 
 * <p><em>Title: </em></p>
 * <p>Description: </p>
 * 
 * @author aquast, email
 * creation date: 22.01.2010
 *
 */
public class PdfAPilotParameters {

	// Initiate Logger for PdfAPilotParameters
	private static Logger log = Logger.getLogger(PdfAPilotParameters.class);
	private static ParameterType defaultParam = new ParameterType();

	
	public static void createDefaultParam(){
		
		// create ParameterType with default values
		defaultParam.setReturnOnlyValidPDFA(true);
		defaultParam.setQuickProcessing(true);

		defaultParam.setCompliancyLevel(CompliancyLevelType.value2);
		defaultParam.setReportTrigger(ReportTriggerType.ALWAYS);
		defaultParam.setReportLang(ReportLangType.DE);

		defaultParam.setReportFormat(new ReportFormatType[]{ReportFormatType.HTML});

		defaultParam.setHtmlReportOptions(new HtmlOptionType[]{HtmlOptionType.OPENRESULT});

	}
	
	/**
	 * @param defaultParam the defaultParam to set
	 */
	public static void setDefaultParam(ParameterType defaultParam) {
		PdfAPilotParameters.defaultParam = defaultParam;
	}

	/**
	 * @return the defaultParam
	 */
	public static ParameterType getDefaultParam() {
		createDefaultParam();
		return defaultParam;
	}
}
