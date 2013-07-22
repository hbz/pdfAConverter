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

import java.util.Properties;

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
	private static Properties paramProp = new Properties();

	
	/**
	 * @deprecated
	 */
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
	
	public static ParameterType createParamType(Properties prop){
		
		paramProp = prop;
		ParameterType param = new ParameterType();
		// define Processing Params
		if(paramProp.containsKey("returnOnlyValidPdfA")){
			param.setReturnOnlyValidPDFA(paramProp.getProperty("returnOnlyValidPdfA").matches("true"));
		
		}
		
		if(paramProp.containsKey("quickProcessing")){
			param.setQuickProcessing(paramProp.getProperty("quickProcessing").matches("true"));
		}
		
		if(paramProp.containsKey("compliancyLevel")){
			if(paramProp.getProperty("compliancyLevel").equals(CompliancyLevelType.value1.getValue())){
				param.setCompliancyLevel(CompliancyLevelType.value1);
			}
			else if(paramProp.getProperty("compliancyLevel").equals(CompliancyLevelType.value2.getValue())){
				param.setCompliancyLevel(CompliancyLevelType.value2);
			}
			else if(paramProp.getProperty("compliancyLevel").equals(CompliancyLevelType.value3.getValue())){
				param.setCompliancyLevel(CompliancyLevelType.value3);
			}
			else if(paramProp.getProperty("compliancyLevel").equals(CompliancyLevelType.value4.getValue())){
				param.setCompliancyLevel(CompliancyLevelType.value4);
			}
			else if(paramProp.getProperty("compliancyLevel").equals(CompliancyLevelType.value5.getValue())){
				param.setCompliancyLevel(CompliancyLevelType.value5);
			}
			else if(paramProp.getProperty("compliancyLevel").equals(CompliancyLevelType.value6.getValue())){
				param.setCompliancyLevel(CompliancyLevelType.value6);
			}
			else if(paramProp.getProperty("compliancyLevel").equals(CompliancyLevelType.value7.getValue())){
				param.setCompliancyLevel(CompliancyLevelType.value7);
			}
			else if(paramProp.getProperty("compliancyLevel").equals(CompliancyLevelType.value8.getValue())){
				param.setCompliancyLevel(CompliancyLevelType.value8);
			}
		}

		// define Report Params
		if(paramProp.containsKey("htmlReport")){
			if(paramProp.getProperty("htmlReport").matches("true")){
				param.setReportFormat(new ReportFormatType[]{ReportFormatType.HTML});
			}
		}
		if(paramProp.containsKey("xmlReport")){
			if(paramProp.getProperty("xmlReport").matches("true")){
				param.setReportFormat(new ReportFormatType[]{ReportFormatType.XML});
			}
		}
		if(paramProp.containsKey("mhtReport")){
			if(paramProp.getProperty("mhtReport").matches("true")){
				param.setReportFormat(new ReportFormatType[]{ReportFormatType.MHT});
			}
		}
		
		if(paramProp.containsKey("reportLang")){
			if(paramProp.getProperty("reportLang").equals(ReportLangType.DE.getValue())){
				param.setReportLang(ReportLangType.DE);
			}
			else if(paramProp.getProperty("reportLang").equals(ReportLangType.EN.getValue())){
				param.setReportLang(ReportLangType.EN);
			}
			else if(paramProp.getProperty("reportLang").equals(ReportLangType.FR.getValue())){
				param.setReportLang(ReportLangType.FR);
			}
			else if(paramProp.getProperty("reportLang").equals(ReportLangType.ES.getValue())){
				param.setReportLang(ReportLangType.ES);
			}
			else if(paramProp.getProperty("reportLang").equals(ReportLangType.IT.getValue())){
				param.setReportLang(ReportLangType.IT);
			}
			else if(paramProp.getProperty("reportLang").equals(ReportLangType.JA.getValue())){
				param.setReportLang(ReportLangType.JA);
			}			
		}
		
		if(paramProp.containsKey("reportTrigger")){

			if(paramProp.getProperty("reportTrigger").equals(ReportTriggerType.ALWAYS.getValue())){
				param.setReportTrigger(ReportTriggerType.ALWAYS);
			}
			else if(paramProp.getProperty("reportTrigger").equals(ReportTriggerType.NEVER.getValue())){
				param.setReportTrigger(ReportTriggerType.NEVER);
			}
			else if(paramProp.getProperty("reportTrigger").equals(ReportTriggerType.IFPDFA.getValue())){
				param.setReportTrigger(ReportTriggerType.IFPDFA);
			}
			else if(paramProp.getProperty("reportTrigger").equals(ReportTriggerType.IFNOPDFA.getValue())){
				param.setReportTrigger(ReportTriggerType.IFNOPDFA);
			}
			
		}

		if(paramProp.containsKey("htmlOpenResult")){
			if(paramProp.getProperty("htmlOpenResult").matches("true")){
				param.setHtmlReportOptions(new HtmlOptionType[]{HtmlOptionType.OPENRESULT});
			}
		}

		if(paramProp.containsKey("htmlNoIcons")){
			if(paramProp.getProperty("htmlNoIcons").matches("true")){
				param.setHtmlReportOptions(new HtmlOptionType[]{HtmlOptionType.NOICONS});
			}
		}
		
		if(paramProp.containsKey("htmlNoDetails")){
			if(paramProp.getProperty("htmlNoDetails").matches("true")){
				param.setHtmlReportOptions(new HtmlOptionType[]{HtmlOptionType.NODETAILS});
			}
		}

		if(paramProp.containsKey("htmlNoCorrection")){
			if(paramProp.getProperty("htmlNoCorrestion").matches("true")){
				param.setHtmlReportOptions(new HtmlOptionType[]{HtmlOptionType.NOCORRECTION});
			}
		}
		

		return param;

	}

	
	private static void createDefaultProperties(){
		
		// set Processing Params
		paramProp.setProperty("returnOnlyValidPdfA", "true");
		paramProp.setProperty("quickProcessing", "true");
		paramProp.setProperty("analyseOnly", "false");
		paramProp.setProperty("createEpub", "false");
		
		paramProp.setProperty("compliancyLevel", "1b");
		
		
		//set Reporting Params
		paramProp.setProperty("reportTrigger", "ALWAYS");
		paramProp.setProperty("reportLang", "IT");
		paramProp.setProperty("htmlReport", "true");
		paramProp.setProperty("htmlOpenResult", "true");
		paramProp.setProperty("htmlNoIcons", "false");
		paramProp.setProperty("xmlReport", "false");
		paramProp.setProperty("mhtReport", "false");
		
		
		
	}
	
	/**
	 * @param defaultParam the defaultParam to set
	 */
	public static void setDefaultParam(ParameterType defaultParam) {
		PdfAPilotParameters.defaultParam = defaultParam;
	}

	/**
	 * @return the defaultParam
	 * @deprecated
	 */
	public static ParameterType getDefaultParam() {
		createDefaultParam();
		return defaultParam;
	}

	/**
	 * @param defaultParam the defaultParam to set
	 */
	public static void setDefaultProperties(Properties ParamProp) {
		paramProp = ParamProp;
	}

	/**
	 * @return the defaultParam
	 */
	public static Properties getDefaultProperties() {
		createDefaultProperties();
		return paramProp;
	}

}
