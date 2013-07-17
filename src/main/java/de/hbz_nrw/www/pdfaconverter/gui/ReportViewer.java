package de.hbz_nrw.www.pdfaconverter.gui;

import java.util.*;
import java.io.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Window;
import java.io.File;

import javax.swing.*;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import de.hbz_nrw.www.pdfaconverter.fileUtils.FileUtil;

public class ReportViewer {

	public ReportViewer(){
		this.createFrame();
	}
	private static Window viewerWindow;
	private static JFrame guiFrame;
	private static JPanel mainPane;
	private static Box resultBox;

	private final static Color hbzBrightOrange = new Color(255, 189, 127);
	private final static Color hbzBrightBlue = new Color(107, 134, 153);
	private final static Color hbzOrange = new Color(107, 134, 153);
	private final static Color hbzBlue = new Color(0, 70, 120);

	private static void createFrame() {
		guiFrame = new JFrame("PDFA-Tool Report Window");
		guiFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		//MenuItem mLoad = new MenuItem("Datei laden");
		//MenuItem mSave = new MenuItem("Datei speichern");
		//MenuItem mCancel = new MenuItem("PDF A Report Window schließen");
		//mLoad.addActionListener(getLoadListener());
		//mSave.addActionListener(new SaveListener());
		//mCancel.addActionListener(new ExitListener());

		//Menu menuField1 = new Menu("Datei");
		//MenuBar mBar = new MenuBar();
		//guiFrame.setMenuBar(mBar);

		//menuField1.add(mLoad);
		//menuField1.add(mSave);
		//menuField1.add(mCancel);
		//mBar.add(menuField1);

		BorderLayout layout = new BorderLayout();
		mainPane = new JPanel(layout);
		mainPane.setBackground(hbzBrightBlue);
		mainPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		guiFrame.setBounds(200, 50, 1200, 700);
		guiFrame.setVisible(true);
		viewerWindow = new Window(guiFrame);
		viewerWindow.setVisible(true);

	}

	/**
	 * <p><em>Title: Create Report View based on HTML report</em></p>
	 * <p>Description: Method uses the Swing HTMLEditorKit to generate a TextPane that displays the 
	 * PDFA-Tool-Report</p>
	 * 
	 * @param reportStream 
	 */
	public void createHtmlView(byte[] reportStream) {
		resultBox = new Box(BoxLayout.Y_AXIS);
		Box innerResultBox = new Box(BoxLayout.Y_AXIS);

		// first implementation:
		JTextPane reportTextPane = new JTextPane();

		javax.swing.text.html.HTMLEditorKit eKit = new javax.swing.text.html.HTMLEditorKit();

		reportTextPane.setEditorKit(eKit);
		reportTextPane.setEditable(false);
		reportTextPane.setText(new String(Base64.decodeBase64(reportStream)));
		//System.out.println(reportTextPane.getText());

		JScrollPane repScroller = new JScrollPane(reportTextPane,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		repScroller.getViewport().add(reportTextPane);
		repScroller.getViewport().setAutoscrolls(true);
		innerResultBox.add(repScroller);

		//second implementation
		/*JEditorPane reportEditorPane = new JEditorPane();
		reportEditorPane.setContentType("text/html");
		reportEditorPane.setEditable(false);
		reportEditorPane.setText(new String(Base64.decodeBase64(reportStream)));

		JScrollPane repScroller = new JScrollPane(reportEditorPane,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		repScroller.getViewport().add(reportEditorPane);
		repScroller.getViewport().setAutoscrolls(true);
		innerResultBox.add(repScroller);*/

		resultBox.add(innerResultBox);
		guiFrame.add(innerResultBox);
		guiFrame.validate();
	}
	
	public void createXMLView(byte[] reportStream){
		resultBox = new Box(BoxLayout.Y_AXIS);
		Box innerResultBox = new Box(BoxLayout.Y_AXIS);

		// first implementation:
		JTextPane reportTextPane = new JTextPane();

		//javax.swing.text.html.HTMLEditorKit eKit = new javax.swing.text..html.HTMLEditorKit();

		//reportTextPane.setEditorKit(eKit);
		reportTextPane.setEditable(false);
		reportTextPane.setText(new String(Base64.decodeBase64(reportStream)));
		//System.out.println(reportTextPane.getText());

		JScrollPane repScroller = new JScrollPane(reportTextPane,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		repScroller.getViewport().add(reportTextPane);
		repScroller.getViewport().setAutoscrolls(true);
		innerResultBox.add(repScroller);

		resultBox.add(innerResultBox);
		guiFrame.add(innerResultBox);
		guiFrame.validate();
	}
			
	private LoadListener getLoadListener(){
		return new LoadListener();
	}

	class LoadListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// iStream = null;
			JFileChooser chooser = new JFileChooser();
			// chooser.setFileFilter(new PdfFilter());
			int returnVal = chooser.showOpenDialog(guiFrame);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File origPdfFile = chooser.getSelectedFile();
				// iStream = FileUtil.loadFileIntoStream(origPdfFile);
				// fileName = origPdfFile.getName();
			}
		}
	}

	class SaveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser();
			// chooser.setSelectedFile(new File(fileName + ".PDFA"));
			int returnVal = chooser.showSaveDialog(guiFrame);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File saveFile = chooser.getSelectedFile();
				// FileUtil.saveStreamToFile(saveFile, oString);
			}

		}
	}

	class ExitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(1);
		}
	}
}
