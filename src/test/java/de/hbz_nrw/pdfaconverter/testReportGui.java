/**
 * 
 */
package de.hbz_nrw.pdfaconverter;

import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.swing.JTextPane;

import org.apache.commons.codec.binary.Base64;


import de.hbz_nrw.www.pdfaconverter.fileUtil.FileUtil;
import de.hbz_nrw.www.pdfaconverter.gui.ReportViewer;

/**
 * @author aquast
 * This Test renders a html view of  given html-test file
 */
public class testReportGui {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ReportRenderer rRend = new ReportRenderer();
		//rRend.createFrame();

		File testFile = new File("test_report.html");
		byte[] iStream = FileUtil.loadFileIntoStream(testFile);
		new ReportViewer().createHtmlView(iStream);

	}

}
