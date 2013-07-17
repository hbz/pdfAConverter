/**
 * ParamBox.java - This file is part of the DiPP Project by hbz
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

import java.awt.Dimension;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;

import org.apache.log4j.Logger;

/**
 * Class ParamBox
 * 
 * <p><em>Title: </em></p>
 * <p>Description: </p>
 * 
 * @author Andres Quast, quast@hbz-nrw.de
 * creation date: 25.01.2010
 *
 */
public class ParamBox {

	// Initiate Logger for ParamBox
	private static Logger log = Logger.getLogger(ParamBox.class);

	public Box paramBox = new Box(BoxLayout.Y_AXIS);

	JPanel reportTab = null;
	JPanel runTab = null;

	JCheckBox xmlReport = new JCheckBox("erzeuge XML-Report");
	JCheckBox htmlReport = new JCheckBox("erzeuge HTML-Report");
	JCheckBox mhtReport = new JCheckBox("erzeuge MHT-Report");

	JCheckBox htmlNoIcons = new JCheckBox("HTML Report ohne Icons");
	JCheckBox htmlNoDetails = new JCheckBox("HTML-Report ohne Details");
	JCheckBox htmlOpenResult = new JCheckBox("HTML-Report OpenResults");
	JCheckBox htmlNoCorrection = new JCheckBox("HTML-Report no Corrections");

	JCheckBox quickProcessing = new JCheckBox("schneller Durchlauf");
	JCheckBox onlyValidPDFA = new JCheckBox("nur valides PDF A zurückgeben");
	JCheckBox analyseOnly = new JCheckBox("nur Analysieren");

	JRadioButton trigger[] = null;
	JRadioButton lang[] = null;
	JRadioButton compliancy[] = null;
	JComboBox triggerComboBox = null;

	
	/**
	 * <p><em>Title: Generate ParameterBox</em></p>
	 * <p>Description: Method generates the Parameter Box
	 * that allows the user to select the values for the PDFA-Tool WS </p>
	 * 
	 * @return 
	 */
	public Box createParamBox(){
		paramBox = new Box(BoxLayout.Y_AXIS);
		JTabbedPane tab = new JTabbedPane();
		reportTab = new JPanel();
		runTab = new JPanel();
		tab.add("Report Einstellungen", reportTab);
		tab.add("Laufzeit Einstellungen", runTab);
		//JCheckBox cReport = new JCheckBox("erzeuge Report-Datei(en)");
		
		// Create Box for Report Parameters
		Box reportTabBox = new Box(BoxLayout.Y_AXIS);

		// Create Trigger Box
		Box report1 = new Box(BoxLayout.Y_AXIS);
		report1.add(new JLabel("Wann sollen ein oder mehrere Reporte erstellt werden?"));
		report1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		Vector<String> triggerList = new Vector<String>();
		triggerList.add("ALWAYS");
		triggerList.add("IFPDFA");
		triggerList.add("IFNOPDFA");
		//triggerList.add("NEVER");
		
		triggerComboBox = new JComboBox(triggerList);
		triggerComboBox.setMaximumSize(new Dimension(100, 30));
		triggerComboBox.setAlignmentX(0);
		report1.add(triggerComboBox);
		reportTabBox.add(report1);
		reportTabBox.add(new JSeparator());
		

		//Create FormatBox
		Box report2 = new Box(BoxLayout.Y_AXIS);
		report2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		report2.add(new JLabel("Ausgabeformat(e) für Report(e)"));
		
		xmlReport.setSelected(false);
		htmlReport.setSelected(true);
		//mhtReport.setSelected(false);
		report2.add(xmlReport);
		report2.add(htmlReport);
		//report2.add(mhtReport);
		reportTabBox.add(report2);
		reportTabBox.add(new JSeparator());
		
		
		//Create LangBox
		Box report3 = new Box(BoxLayout.Y_AXIS);
		report3.add(new JLabel("Sprache der Reporte"));
		report3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		Vector<String> langList = new Vector<String>();
		langList.add("DE");
		langList.add("EN");
		langList.add("FR");
		langList.add("IT");
		langList.add("ES");
		langList.add("JA");
		
		ButtonGroup bGroup1 = new ButtonGroup();
		Iterator<String> lit = langList.iterator();
		lang = new JRadioButton[langList.size()];  
		int i = 0;
		while (lit.hasNext()){
			lang[i] = new JRadioButton(lit.next());
			report3.add(lang[i]);
			bGroup1.add(lang[i]);
			if(lang[i].getText().equals("DE")){
				lang[i].setSelected(true);
			}
			i++;
		}
		reportTabBox.add(report3);
		reportTabBox.add(new JSeparator());

		//Create htmlSpecBox
		Box report5 = new Box(BoxLayout.Y_AXIS);
		report5.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		report5.add(new JLabel("Ausgabedetails für HTML"));
		
		report5.add(htmlNoDetails);
		report5.add(htmlNoIcons);
		report5.add(htmlNoCorrection);
		report5.add(htmlOpenResult);
		reportTabBox.add(report5);
		

		reportTab.add(reportTabBox);

		// Create Box for Runtime Parameters
		Box runTabBox = new Box(BoxLayout.Y_AXIS);

		// Create Trigger Box
		Box run1 = new Box(BoxLayout.Y_AXIS);
		run1.add(new JLabel("Optionen"));
		//run1.setBackground(hbzBrightBlue);
		run1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		quickProcessing.setSelected(true);
		onlyValidPDFA.setSelected(true);
		analyseOnly.setSelected(false);
		//mhtReport.setSelected(false);
		run1.add(quickProcessing);
		run1.add(onlyValidPDFA);
		run1.add(analyseOnly);
		runTabBox.add(run1);
		runTabBox.add(new JSeparator());
		
		Box run2 = new Box(BoxLayout.Y_AXIS);
		run2.add(new JLabel("PDF A compliancy Level"));
		ButtonGroup bGroup2 = new ButtonGroup();
		Vector<String> compliancyLevel = new Vector<String>();
		compliancyLevel.add("1a");
		compliancyLevel.add("1b");
		Iterator<String> cit = compliancyLevel.iterator();
		compliancy = new JRadioButton[compliancyLevel.size()];  
		i = 0;
		while (cit.hasNext()){
			compliancy[i] = new JRadioButton(cit.next());
			run2.add(compliancy[i]);
			bGroup2.add(compliancy[i]);
			if(compliancy[i].getText().equals("1b")){
				compliancy[i].setSelected(true);
			}
			i++;
		}
		runTabBox.add(run2);
		
		reportTab.add(reportTabBox);
		runTab.add(runTabBox);
		
		paramBox.add(tab);
		return paramBox;
	}

}
