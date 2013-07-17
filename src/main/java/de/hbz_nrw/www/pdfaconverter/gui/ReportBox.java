/**
 * 
 */
package de.hbz_nrw.www.pdfaconverter.gui;

/**
 * @author aquast
 *
 */

import java.io.*;
import javax.swing.*;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import java.awt.*;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import de.hbz_nrw.www.pdfaconverter.ServerImpl.Configuration;
import de.hbz_nrw.www.pdfaconverter.fileUtils.*;


/**
 * Class ReportBox
 * 
 * <p><em>Title: </em></p>
 * <p>Description: </p>
 * 
 * @author Andres Quast, quast@hbz-nrw.de
 * creation date: 26.01.2010
 *
 */
public class ReportBox {

	// Initiate Logger for PdfAPilotParameters
	private static Logger log = Logger.getLogger(PdfAPilotParameters.class);

	private byte[] stream = null;
	String reportString;
	JButton viewReport = new JButton("Report im Textmodus ansehen");
	JButton viewReportViaBrowser = new JButton("Report im Browser ansehen");
	JButton viewHtmlReport = new JButton("HTML-Report im Textmodus ansehen");
	JButton viewHtmlReportViaBrowser = new JButton("HTML-Report im Browser ansehen");
	JButton saveHtmlReport = new JButton("HTML-Report speichern");
	JButton viewXmlReport = new JButton("XML-Report im Textmodus ansehen");
	JButton viewXmlReportViaBrowser = new JButton("XML-Report im Browser ansehen");
	JButton saveXmlReport = new JButton("XML-Report speichern");

	Box resultBox = new Box(BoxLayout.Y_AXIS);
	JPanel resultPanel = new JPanel();

	
	File fileName;
	String saveString = null;

	public ReportBox(String report){
		resultPanel.setLayout(new GridLayout(5, 1, 2, 2));
		resultPanel.setBackground(new Color(255,255,255));
		reportString = report;
		this.addButtons();
		this.addStream();
	}
	
	/**
	 * <p><em>Title: Add Buttons to the ReportBox Object</em></p>
	 * <p>Description: Method defines the appropriate buttons according the 
	 * file types returned within the data stream and adds them to the ReportBox</p>
	 *  
	 */
	private void addButtons(){
		try {
			stream = reportString.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.error(e);
		}
		
    	if(new String (Base64.decodeBase64(stream)).startsWith("<!DOCTYPE HTML PUBLIC")){

    		resultBox.add(resultPanel);
    		JTextPane reportTextPane = new JTextPane();
    		String report = new String("<h3><font face=\"sans, Arial\">HTML-Report erstellt</font></h3>");
    		
    		reportTextPane.setEditable(false);
    		reportTextPane.setEditorKit(new javax.swing.text.html.HTMLEditorKit());
    		reportTextPane.setText(report);
    		resultPanel.add(reportTextPane);
    		resultPanel.add(viewHtmlReport);
    		resultPanel.add(viewHtmlReportViaBrowser);
    		resultPanel.add(saveHtmlReport);
    		viewHtmlReport.addActionListener(new viewListener());
    		viewHtmlReport.setHorizontalAlignment(AbstractButton.LEFT);
    		viewHtmlReportViaBrowser.addActionListener(new launchBrowserListener());
    		viewHtmlReportViaBrowser.setHorizontalAlignment(AbstractButton.LEFT);
    		viewHtmlReportViaBrowser.createToolTip();
    		viewHtmlReportViaBrowser.setToolTipText("Internet Explorer oder Firefox notwendig, um diesen Button nutzen zu können");
    		saveHtmlReport.addActionListener(new SaveHtmlListener());
    		saveHtmlReport.setHorizontalAlignment(AbstractButton.LEFT);
    	}
    	else if(new String (Base64.decodeBase64(stream)).startsWith("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>")){

    		resultBox.add(resultPanel);
    		JTextPane reportTextPane = new JTextPane();
    		String report = new String("<h3><font face=\"sans, Arial\">XML-Report erstellt</font></h3>");
    		
    		reportTextPane.setEditable(false);
    		reportTextPane.setEditorKit(new javax.swing.text.html.HTMLEditorKit());
    		reportTextPane.setText(report);
    		resultPanel.add(reportTextPane);
    		resultPanel.add(viewXmlReport);
    		resultPanel.add(viewXmlReportViaBrowser);
    		viewXmlReport.addActionListener(new viewListener());
    		viewXmlReport.setHorizontalAlignment(AbstractButton.LEFT);
    		viewXmlReportViaBrowser.addActionListener(new launchBrowserListener());
    		viewXmlReportViaBrowser.setHorizontalAlignment(AbstractButton.LEFT);
    		resultPanel.add(saveXmlReport);
    		saveXmlReport.addActionListener(new SaveXmlListener());
    		saveXmlReport.setHorizontalAlignment(AbstractButton.LEFT);
    	}
    	else{
    		Label label = new Label("Report");
    		resultBox.add(label);
    		resultBox.add(viewReport);
    		resultBox.add(viewReportViaBrowser);
    		viewReport.addActionListener(new viewListener());
    		viewReportViaBrowser.addActionListener(new launchBrowserListener());
    		viewReportViaBrowser.createToolTip();
    		viewReportViaBrowser.setToolTipText("Internet Explorer oder Firefox notwendig, um diesen Button nutzen zu können");
    	}
	}
	
	/**
	 * <p><em>Title: Add report stream to the ReportBox Object</em></p>
	 * <p>Description: Method converts reportString (As Base64 Sequence) to Array of Byte and add Array to the ReportBox. 
	 * Array of Byte is required for decoding of Base64 Sequence</p>
	 *  
	 */
	private void addStream(){
		try {
			stream = reportString.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		saveString = reportString;
	}
	

	/**
	 * <p><em>Title: </em></p>
	 * <p>Description: parses the report stream for getting the filename used on nyx for conversion</p>
	 * 
	 * @return 
	 */
	private String getFileName(){
		//find filename in String to create an URL for displaying the Reportfile from nyx 
		Pattern p = Pattern.compile("\\d{8}T\\d{9}Z\\.pdf");
		Matcher m = p.matcher(new String(Base64.decodeBase64(stream)));
		m.find();
		String filename = new String(Base64.decodeBase64(stream)).substring(m.start(), m.end());
		return filename;
		
	}

	public Box getResultBox(){
		return resultBox;
	}
	
	/**
	 * Class SaveHTMLListener
	 * 
	 * <p><em>Title: </em></p>
	 * <p>Description: </p>
	 * 
	 * @author Andres Quast, quast@hbz-nrw.de
	 * creation date: 26.01.2010
	 *
	 */
	class SaveHtmlListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	JFileChooser chooser = new JFileChooser();
	        chooser.setSelectedFile(new File(clientGui.getFileName() + ".html"));
	        int returnVal = chooser.showSaveDialog(resultBox);
	        if(returnVal == JFileChooser.APPROVE_OPTION) {
	            File saveFile = chooser.getSelectedFile();
				FileUtil.saveStreamToFile(saveFile, saveString);
	        }
	    }
	}
	
	/**
	 * Class SaveXmlListener
	 * 
	 * <p><em>Title: </em></p>
	 * <p>Description: </p>
	 * 
	 * @author Andres Quast, quast@hbz-nrw.de
	 * creation date: 26.01.2010
	 *
	 */
	class SaveXmlListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        JFileChooser chooser = new JFileChooser();
	        chooser.setSelectedFile(new File(clientGui.getFileName() + ".xml"));
	        int returnVal = chooser.showSaveDialog(resultBox);
	        if(returnVal == JFileChooser.APPROVE_OPTION) {
	            File saveFile = chooser.getSelectedFile();
				FileUtil.saveStreamToFile(saveFile, saveString);
	        }
	    }
	}
	/**
	 * Class viewListener
	 * 
	 * <p><em>Title: </em></p>
	 * <p>Description: </p>
	 * 
	 * @author Andres Quast, quast@hbz-nrw.de
	 * creation date: 26.01.2010
	 *
	 */
	class viewListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	
	    	//find out which report format was created
	    	if(new String(Base64.decodeBase64(stream)).startsWith("<!DOCTYPE HTML PUBLIC")){
		    	new ReportViewer().createHtmlView(stream);
	    	}
	    	if(new String(Base64.decodeBase64(stream)).startsWith("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>")){
		    	new ReportViewer().createXMLView(stream);
	    	}
	    }
	}

	/**
	 * Class launchBrowserListener
	 * 
	 * <p><em>Title: </em></p>
	 * <p>Description: </p>
	 * 
	 * @author Andres Quast, quast@hbz-nrw.de
	 * creation date: 26.01.2010
	 *
	 */
	class launchBrowserListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	
	    	String filename = getFileName();
	    	//find out which report format was created
	    	if(new String(Base64.decodeBase64(stream)).startsWith("<!DOCTYPE HTML PUBLIC")){
	    		BrowserLauncher.setUrl(Configuration.getTempdirurl() + "result/" + filename + ".html");
	    	}
	    	if(new String(Base64.decodeBase64(stream)).startsWith("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>")){
	    		BrowserLauncher.setUrl(Configuration.getTempdirurl() + "result/"+ filename + ".xml");
	    	}
	    	
	    	BrowserLauncher.launch();
	    }
	}

}
