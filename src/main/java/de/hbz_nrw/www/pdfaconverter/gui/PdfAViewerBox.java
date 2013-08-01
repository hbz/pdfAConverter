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
import de.hbz_nrw.www.pdfaconverter.fileUtil.*;


/**
 * Class PdfAViewerBox
 * 
 * <p><em>Title: </em></p>
 * <p>Description: </p>
 * 
 * @author Andres Quast, quast@hbz-nrw.de
 * creation date: 26.01.2010
 *
 */
public class PdfAViewerBox {

	// Initiate Logger for PdfAPilotParameters
	private static Logger log = Logger.getLogger(PdfAViewerBox.class);

	private byte[] stream = null;
	JButton viewPdfAResult = new JButton("PDF A im Browser ansehen");

	Box resultBox = new Box(BoxLayout.Y_AXIS);
	JPanel resultPanel = new JPanel();
	String remoteFileName;
	
	File fileName;
	String saveString = null;

	public PdfAViewerBox(String RemoteFileName){
		resultPanel.setLayout(new GridLayout(5, 1, 2, 2));
		resultPanel.setBackground(new Color(255,255,255));
		remoteFileName = RemoteFileName;
		this.addButtons();
	}
	
	/**
	 * <p><em>Title: Add Buttons to the ReportBox Object</em></p>
	 * <p>Description: Method finds the appropriate buttons and adds them to the ReportBox</p>
	 *  
	 */
	private void addButtons(){
		resultBox.add(resultPanel);
   		JTextPane reportTextPane = new JTextPane();
   		String view = new String("<h3><font face=\"sans, Arial\">PDF/A erstellt</font></h3>");
   		reportTextPane.setEditable(false);
   		reportTextPane.setEditorKit(new javax.swing.text.html.HTMLEditorKit());
   		reportTextPane.setText(view);
   		resultPanel.add(reportTextPane);
   		resultPanel.add(viewPdfAResult);
   		viewPdfAResult.addActionListener(new launchReaderListener());
   		viewPdfAResult.setHorizontalAlignment(AbstractButton.LEFT);
	}
	
	
	/**
	 * Class launchReaderListener
	 * 
	 * <p><em>Title: </em></p>
	 * <p>Description: </p>
	 * 
	 * @author Andres Quast, quast@hbz-nrw.de
	 * creation date: 26.01.2010
	 *
	 */
	class launchReaderListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	
	    	String filename = remoteFileName;
	    	ReaderLauncher.setUrl(Configuration.getTempDirUrl() + "result/" + filename);
	    	ReaderLauncher.launch();
	    }
	}
	/**
	 * <p><em>Title: </em></p>
	 * <p>Description: parses the report stream for getting the filename used on nyx for conversion</p>
	 * @deprecated
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



}
