
package de.hbz_nrw.www.pdfaconverter.gui;

import java.rmi.RemoteException;
import java.util.*;
import java.util.List;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

import javax.accessibility.Accessible;
import javax.accessibility.AccessibleContext;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import de.hbz_nrw.www.pdfaconverter.clientImpl.ClientImpl;
import de.hbz_nrw.www.pdfaconverter.fileUtil.FileUtil;
import de.hbz_nrw.www.pdfaconverter.services.ConvertFromStream_faultMsg;
import de.hbz_nrw.www.pdfaconverter.types.CompliancyLevelType;
import de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment;
import de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachmentResponse;
import de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream;
import de.hbz_nrw.www.pdfaconverter.types.ConvertFromStreamResponse;
import de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl;
import de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrlResponse;
import de.hbz_nrw.www.pdfaconverter.types.HtmlOptionType;
import de.hbz_nrw.www.pdfaconverter.types.ParameterType;
import de.hbz_nrw.www.pdfaconverter.types.ReportFormatType;
import de.hbz_nrw.www.pdfaconverter.types.ReportLangType;
import de.hbz_nrw.www.pdfaconverter.types.ReportTriggerType;
import de.hbz_nrw.www.pdfaconverter.util.PdfAPilotParameters;

/**
 * Class clientGui
 * 
 * <p><em>Title: </em></p>
 * <p>Description: </p>
 * 
 * @author Andres Quast, quast@hbz-nrw.de
 * creation date: 11.01.2010
 *
 */
public class clientGui{

	//get Logger Instance
	Logger log = Logger.getLogger(clientGui.class);
	
	private File dir = null;
	private File paramDir = null;

	JFrame alertFrame = null; 
	
	JFrame guiFrame;
	JPanel mainPane;
	Box paramBox = new Box(BoxLayout.Y_AXIS);
	Box defaultBox = new Box(BoxLayout.Y_AXIS);
	Box playerBox;
	private JPanel centerPane = new JPanel();
	private JPanel cardRealPane = new JPanel();
	
	JPanel reportTab = null;
	JPanel runTab = null;

	//ImageIcon loadPdf = createImageIcon("http://nyx.hbz-nrw.de:8080/resources/pdfa-client_button1.png");
	ImageIcon loadPdf = createImageIcon("/images/pdfa-client_button1.png");
	ImageIcon processPdf = createImageIcon("/images/pdfa-client_button2.png");
	ImageIcon savePdf =  createImageIcon("/images/pdfa-client_button3.png");

	JButton showLoadPdf = new JButton("Ein PDF zum Konvertieren laden", loadPdf);
	JButton showProcessPdf = new JButton("PDF A erstellen", processPdf);
	JButton showSavePdfA = new JButton("Erzeugtes PDF A speichern", savePdf);


	JCheckBox xmlReport = new JCheckBox("erzeuge XML-Report");
	JCheckBox htmlReport = new JCheckBox("erzeuge HTML-Report");
	JCheckBox mhtReport = new JCheckBox("erzeuge MHT-Report");

	JCheckBox htmlNoIcons = new JCheckBox("HTML Report ohne Icons");
	JCheckBox htmlNoDetails = new JCheckBox("HTML-Report ohne Details");
	JCheckBox htmlOpenResult = new JCheckBox("HTML-Report OpenResults");
	JCheckBox htmlNoCorrections = new JCheckBox("HTML-Report no Corrections");

	JCheckBox quickProcessing = new JCheckBox("schneller Durchlauf");
	JCheckBox onlyValidPDFA = new JCheckBox("nur valides PDF A zurückgeben");
	JCheckBox analyseOnly = new JCheckBox("nur Analysieren");
	JCheckBox createEpub = new JCheckBox("E-Pub erstellen");
	
	JCheckBox forceConversionReconvert = new JCheckBox("erzwinge Neukonvertierung per PS");
	JCheckBox forceConversionPagesToImages = new JCheckBox("wandle fehlerhafte Seiten in Bilder");
	JCheckBox forceConversionDocToImages = new JCheckBox("wandle gemsamtes PDF in Bilder");

	JRadioButton trigger[] = null;
	JRadioButton lang[] = null;
	JRadioButton compliancy[] = null;
	JComboBox triggerComboBox = null;
	
	private final static Color hbzBrightOrange = new Color(255,189,127);
	private final static Color hbzBrightBlue = new Color(107, 134,153);
	private final static Color hbzOrange = new Color(250, 130, 10);
	private final static Color hbzBlue = new Color(0,70,120);
	private final static Color white = new Color(255,255,255);

	JLabel testCenter;
	
	byte[] iStream = null;
	byte[] oStream = null;
	String oString = null;
	String remoteFileName = null;
	
	private int countReport = 0;
	String[] reportString = null;
	private static String fileName = null;
	private boolean visitedParamBox = false;
	
	private ArrayList<String[]> fNames = new ArrayList<String[]>();
    	
	ConvertFromStreamResponse response = null;
	
	// load default parameters for pdfaPilot 
	Properties paramProp = PdfAPilotParameters.getDefaultProperties();
	// create ParameterType with default Parameters 
	ParameterType param = PdfAPilotParameters.createParamType(paramProp);

    //make Parameter Boxes global
	ButtonGroup bGroup1 = null;

	/**
	 * <p><em>Title: Processes the PDF-Converter GUI</em></p>
	 * <p>Description: Method creates the Main Window of the GUI 
	 * for PdfConverterClient</p>
	 *  
	 */
	public void guiCreator()
	{

		log.info(System.getProperty("user.dir"));

		try {
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		    //UIManager.setLookAndFeel( "javax.swing.plaf.metal.MetalLookAndFeel" );
		    //UIManager.setLookAndFeel( "com.l2fprod.gui.plaf.skin.SkinLookAndFeel" );
		    //UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
			System.out.println(UIManager.getLookAndFeel());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e);
			e.printStackTrace();
		}

			
		guiFrame = new JFrame("PDF A Tool Client");
	    guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		showLoadPdf.setHorizontalAlignment(AbstractButton.LEFT);
		showSavePdfA.setHorizontalAlignment(AbstractButton.LEFT);
		showProcessPdf.setHorizontalAlignment(AbstractButton.LEFT);

		MenuItem mLoad = new MenuItem("Datei laden");
	    MenuItem mSave = new MenuItem("Datei speichern");
	    MenuItem mLoadParam = new MenuItem("Konfiguration laden");
	    MenuItem mSaveParam = new MenuItem("Konfiguration speichern");
	    MenuItem mCancel = new MenuItem("PDF A Tool Client beenden");
	    MenuItem mProperties = new MenuItem("PDF A Processing einstellen");
	    MenuItem mLookFeelC = new MenuItem ("Cross Plattform Look & Feel");
	    MenuItem mLookFeelM = new MenuItem ("Metal Look & Feel");
	    MenuItem mLookFeelS = new MenuItem ("Systemeigenes Look & Feel");
	    MenuItem mLookFeelW = new MenuItem ("Windows Look & Feel");
	    mLoad.addActionListener(new LoadListener());
	    mSave.addActionListener(new SaveListener());
	    mLoadParam.addActionListener(new LoadParamListener());
	    mSaveParam.addActionListener(new SaveParamListener());
	    mCancel.addActionListener(new ExitListener());
	    mProperties.addActionListener(new CreateParamsListener());
	    mLookFeelC.setActionCommand(UIManager.getCrossPlatformLookAndFeelClassName());
	    mLookFeelC.addActionListener(new UIManagerListener());
	    mLookFeelM.setActionCommand("javax.swing.plaf.metal.MetalLookAndFeel");
	    mLookFeelM.addActionListener(new UIManagerListener());
	    mLookFeelS.setActionCommand(UIManager.getSystemLookAndFeelClassName());
	    mLookFeelS.addActionListener(new UIManagerListener());
	    mLookFeelW.setActionCommand("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
	    mLookFeelW.addActionListener(new UIManagerListener());

	    Menu menuField1 = new Menu("Datei");
	    Menu menuField2 = new Menu("Einstellungen");
	    Menu menuField3 = new Menu("Extras");
	    MenuBar mBar = new MenuBar();
	    guiFrame.setMenuBar(mBar);

	    menuField1.add(mLoad);
	    menuField1.add(mSave);
	    menuField1.add(mLoadParam);
	    menuField1.add(mSaveParam);
	    menuField1.add(mCancel);
	    menuField2.add(mProperties);
	    menuField3.add(mLookFeelS);
	    menuField3.add(mLookFeelM);
	    menuField3.add(mLookFeelC);
	    menuField3.add(mLookFeelW);
	    mBar.add(menuField1);
	    mBar.add(menuField2);
	    mBar.add(menuField3);

	    BorderLayout layout = new BorderLayout();
	    mainPane = new JPanel(layout);			
	    mainPane.setBackground(white);
	    mainPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	    
		// Add welcome and default box
	    cardRealPane.add(createDefaultBox());
		cardRealPane.setBackground(white);
	    mainPane.add(BorderLayout.WEST, cardRealPane);
	    
		JPanel playerPane = new JPanel(new BorderLayout());
		playerPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		playerPane.setBackground(white);
		//Box playerBox = new Box(BoxLayout.Y_AXIS);
		JPanel playerBox = new JPanel();
		playerBox.setLayout(new GridLayout(6 ,1,10,10));
		playerBox.setBackground(white);
		showLoadPdf.addActionListener(new LoadListener());
		showSavePdfA.addActionListener(new SaveListener());
		showProcessPdf.addActionListener(new ParamListener());
		

		//showLoadPdf.setContentAreaFilled(true);
		showSavePdfA.setEnabled(false);
		showProcessPdf.setEnabled(false);
		playerBox.add(showLoadPdf);
		playerBox.add(showProcessPdf);
		playerBox.add(showSavePdfA);

		playerPane.add(playerBox);
	    mainPane.add(BorderLayout.EAST, playerPane);

	    testCenter = new JLabel("hbz NRW, Cologne, 2013 - Callas pdfaPilot CLI Version 4 integrated");
	    FlowLayout layoutFlow = new FlowLayout(FlowLayout.LEFT);
	    centerPane = new JPanel(layoutFlow);
	    centerPane.add(testCenter);
	    centerPane.setBackground(hbzOrange);
	    mainPane.add(BorderLayout.SOUTH, centerPane);
	    guiFrame.getContentPane().add(mainPane);
	    
	    guiFrame.setBounds(50, 50, 800, 700);
	    guiFrame.setVisible(true);


	
	
	}
	
	public Box createDefaultBox(){
		defaultBox = new Box(BoxLayout.Y_AXIS);
		JTextPane defaultTextPane = new JTextPane();
		
		String welcome = new String("<h3><font face=\"sans, Arial\">Willkommen beim PDF A Tool Client</font></h3>"
				+ "<p><font face=\"sans, Arial\" size=-1>Dies ist ein Demonstrator für das PDFA Tool des hbz NRW<br/>" +
						"Hiermit konvertieren Sie bestehende PDF-Dateien<br/> " +
						"in das PDF A-Format</font></p>" +
						"<p>&nbsp;</p>" +
						"<p>&nbsp;</p>" +
						"<p>&nbsp;</p>" +
						"<img src=\"http://www.hbz-nrw.de/index_html/logo\">");
		
		defaultTextPane.setEditable(false);
		defaultTextPane.setEditorKit(new javax.swing.text.html.HTMLEditorKit());
		defaultTextPane.setText(welcome);
		defaultBox.add(defaultTextPane);
		return defaultBox;
	}
	
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
		triggerComboBox.setEnabled(false);
		report1.add(triggerComboBox);
		reportTabBox.add(report1);
		reportTabBox.add(new JSeparator());
		

		//Create FormatBox
		Box report2 = new Box(BoxLayout.Y_AXIS);
		report2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		report2.add(new JLabel("Ausgabeformat(e) für Report(e)"));
		
		if(paramProp.containsKey("xmlReport") && paramProp.getProperty("xmlReport").equalsIgnoreCase("true")){
			xmlReport.setSelected(true);
		}
		if(paramProp.containsKey("htmlReport") && paramProp.getProperty("htmlReport").equalsIgnoreCase("true")){
			htmlReport.setSelected(true);
		}
		if(paramProp.containsKey("mhtReport") && paramProp.getProperty("mhtReport").equalsIgnoreCase("true")){
			mhtReport.setSelected(true);
		}
		report2.add(xmlReport);
		report2.add(htmlReport);
		report2.add(mhtReport);
		mhtReport.setEnabled(false);
		reportTabBox.add(report2);
		reportTabBox.add(new JSeparator());
		
		
		//Create LangBox
		Box report3 = new Box(BoxLayout.Y_AXIS);
		report3.add(new JLabel("Sprache der Reporte"));
		report3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		if(bGroup1 == null){
			bGroup1 = new ButtonGroup();
			Vector<String> langList = new Vector<String>();
			langList.add("DE");
			langList.add("EN");
			langList.add("FR");
			langList.add("IT");
			langList.add("ES");
			langList.add("JA");

			Iterator<String> lit = langList.iterator();
			lang = new JRadioButton[langList.size()];  
			int i = 0;
			while (lit.hasNext()){
				lang[i] = new JRadioButton(lit.next());
				report3.add(lang[i]);
				bGroup1.add(lang[i]);
				if(paramProp.containsKey("reportLang") && lang[i].getText().equals(paramProp.getProperty("reportLang"))){
					lang[i].setSelected(true);
				}
				i++;
			}
		}else{
			Enumeration<AbstractButton> lenum = bGroup1.getElements();
			while(lenum.hasMoreElements()){
				report3.add(lenum.nextElement());
			}
		}
		reportTabBox.add(report3);
		reportTabBox.add(new JSeparator());

		//Create htmlSpecBox
		Box report5 = new Box(BoxLayout.Y_AXIS);
		report5.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		report5.add(new JLabel("Ausgabedetails für HTML"));
		
		if(paramProp.containsKey("htmlNoDetails") && paramProp.getProperty("htmlNoDetails").equalsIgnoreCase("true")){
			htmlNoDetails.setSelected(true);
		}
		if(paramProp.containsKey("htmlNoIcons") && paramProp.getProperty("htmlNoIcons").equalsIgnoreCase("true")){
			htmlNoIcons.setSelected(true);
		}
		if(paramProp.containsKey("htmlNoCorrections") && paramProp.getProperty("htmlNoCorrections").equalsIgnoreCase("true")){
			htmlNoCorrections.setSelected(true);
		}
		if(paramProp.containsKey("htmlOpenResult") && paramProp.getProperty("htmlOpenResult").equalsIgnoreCase("true")){
			htmlOpenResult.setSelected(true);
		}

		htmlNoCorrections.setEnabled(false);
		htmlOpenResult.setEnabled(false);
		report5.add(htmlNoDetails);
		report5.add(htmlNoIcons);
		report5.add(htmlNoCorrections);
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
		
		if(paramProp.containsKey("quickProcessing") && paramProp.getProperty("quickProcessing").equalsIgnoreCase("true")){
			quickProcessing.setSelected(true);
		}
		if(paramProp.containsKey("returnOnlyValidPdfA") && paramProp.getProperty("returnOnlyValidPdfA").equalsIgnoreCase("true")){
			onlyValidPDFA.setSelected(true);
		}
		if(paramProp.containsKey("analyseOnly") && paramProp.getProperty("analyseOnly").equalsIgnoreCase("true")){
			analyseOnly.setSelected(true);
		}
		if(paramProp.containsKey("createEpub") && paramProp.getProperty("createEpub").equalsIgnoreCase("true")){
			createEpub.setSelected(true);
		}

		run1.add(quickProcessing);
		run1.add(onlyValidPDFA);
		run1.add(analyseOnly);
		run1.add(createEpub);
		runTabBox.add(run1);
		runTabBox.add(new JSeparator());
		
		Box run2 = new Box(BoxLayout.Y_AXIS);
		run2.add(new JLabel("PDF A compliancy Level"));
		ButtonGroup bGroup2 = new ButtonGroup();
		Vector<String> compliancyLevel = new Vector<String>();
		compliancyLevel.add("1a");
		compliancyLevel.add("1b");
		compliancyLevel.add("2a");
		compliancyLevel.add("2u");
		compliancyLevel.add("2b");
		compliancyLevel.add("3a");
		compliancyLevel.add("3u");
		compliancyLevel.add("3b");
		Iterator<String> cit = compliancyLevel.iterator();
		compliancy = new JRadioButton[compliancyLevel.size()];  
		int i = 0;
		while (cit.hasNext()){
			compliancy[i] = new JRadioButton(cit.next());
			run2.add(compliancy[i]);
			bGroup2.add(compliancy[i]);
			if(compliancy[i].getText().equals(paramProp.getProperty("compliancyLevel"))){
				compliancy[i].setSelected(true);
			}
			/*
			if(compliancy[i].getText().equals("1a")){
				compliancy[i].setEnabled(false);
			}
			*/
			i++;
		}
		runTabBox.add(run2);
		runTabBox.add(new JSeparator());
		
		// Create Trigger Box
		Box run3 = new Box(BoxLayout.Y_AXIS);
		run3.add(new JLabel("Erweitert"));
		//run1.setBackground(hbzBrightBlue);
		run3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		if(paramProp.containsKey("forceConversionReconvert") && paramProp.getProperty("forceConversionReconvert").equalsIgnoreCase("true")){
			forceConversionReconvert.setSelected(true);
		}
		if(paramProp.containsKey("returnOnlyValidPdfA") && paramProp.getProperty("returnOnlyValidPdfA").equalsIgnoreCase("true")){
			onlyValidPDFA.setSelected(true);
		}
		if(paramProp.containsKey("analyseOnly") && paramProp.getProperty("analyseOnly").equalsIgnoreCase("true")){
			analyseOnly.setSelected(true);
		}
		if(paramProp.containsKey("createEpub") && paramProp.getProperty("createEpub").equalsIgnoreCase("true")){
			createEpub.setSelected(true);
		}

		run3.add(forceConversionReconvert);
		run3.add(forceConversionPagesToImages);
		run3.add(forceConversionDocToImages);
		runTabBox.add(run3);

		reportTab.add(reportTabBox);
		runTab.add(runTabBox);
		
		paramBox.add(tab);
		// hack: if parambox was visited, use parameters from GUI alse use default params
		visitedParamBox = true;
		return paramBox;
	}
	
	/**
	 * <p><em>Title: Box with Buttons for the converter results</em></p>
	 * <p>Description:  Method generates a Box for displaying the buttons
	 * required to show the reports in a new window</p>
	 * 
	 * @return 
	 */
	public Box createResultBox(){
		Box resultBox = new Box(BoxLayout.Y_AXIS);
		String reportStream = null;
		log.info("Starting with resultBox");
		//reportString = new String[]{"Test this"};
		if(reportString != null){
			log.debug(reportString.length);
			List<String> reports = Arrays.asList(reportString);
			
			Iterator<String> rit = reports.iterator();

			while(rit.hasNext()){
				reportStream = rit.next();
				resultBox.add(new ReportBox(reportStream).getResultBox());
			}			
		}
		if(oString != null){
			resultBox.add(new PdfAViewerBox(remoteFileName).getResultBox());
		}
		return resultBox;
	}


	public static String getFileName(){
		return fileName;
	}
	
	/**
	 * <p><em>Title: </em></p>
	 * <p>Description: Method removes old ContentBox from and replaces it
	 * with a new ContentBox</p>
	 * 
	 * @param newContentBox 
	 */
	public void refreshFrame(Box newContentBox){
		cardRealPane.setVisible(false);
		mainPane.remove(cardRealPane);
		cardRealPane = new JPanel();
		cardRealPane.setBackground(white);
		cardRealPane.add(newContentBox);
		mainPane.add(BorderLayout.WEST, cardRealPane);
		mainPane.validate();
		//guiFrame.pack();
	}

	/**
	 * <p><em>Title: </em></p>
	 * <p>Description: </p>
	 *  
	 */
	private void writeGuiParamsToProp(){

		if(compliancy != null){
			for(int i=0; i< compliancy.length; i++){
				if(compliancy[i].isSelected()){
					paramProp.setProperty("compliancyLevel", compliancy[i].getText());
				}
			}
		}

		if(lang != null){
			for(int i=0; i< lang.length; i++){
				if(lang[i].isSelected()){
					paramProp.setProperty("reportLang", lang[i].getText());
				}
			}
		}

		if(xmlReport.isSelected()){
			paramProp.setProperty("xmlReport", "true");
		}else{
			paramProp.setProperty("xmlReport", "false");
		}
		if(htmlReport.isSelected()){
			paramProp.setProperty("htmlReport", "true");
		}else{
			paramProp.setProperty("htmlReport", "false");
		}
		if(mhtReport.isSelected()){
			paramProp.setProperty("mhtReport", "true");
		}else{
			paramProp.setProperty("mhtReport", "false");
		}

		if(htmlNoDetails.isSelected()){
			paramProp.setProperty("htmlNoDetails", "true");
		}else{
			paramProp.setProperty("htmlNoDetails", "false");
		}
		if(htmlNoIcons.isSelected()){
			paramProp.setProperty("htmlNoIcon", "true");
		}else{
			paramProp.setProperty("htmlNoIcons", "false");
		}
		
		if(quickProcessing.isSelected()){
			paramProp.setProperty("quickProcessing", "true");
		}else{
			paramProp.setProperty("quickProcessing", "false");
		}
		if(onlyValidPDFA.isSelected()){
			paramProp.setProperty("returnOnlyValidPdfA", "true");
		}else{
			paramProp.setProperty("returnOnlyValidPdfA", "false");
		}
		if(analyseOnly.isSelected()){
			paramProp.setProperty("analyseOnly", "true");
		}else{
			paramProp.setProperty("analyseOnly", "false");
		}
		if(createEpub.isSelected()){
			paramProp.setProperty("createEpub", "true");
		}else{
			paramProp.setProperty("createEpub", "false");
		}
		if(forceConversionReconvert.isSelected()){
			paramProp.setProperty("forceConversionReconvert", "true");
		}else{
			paramProp.setProperty("forceConversionReconvert", "false");
		}
		if(forceConversionPagesToImages.isSelected()){
			paramProp.setProperty("forceConversionPagesToImages", "true");
		}else{
			paramProp.setProperty("forceConversionPagesToImages", "false");
		}
		if(forceConversionDocToImages.isSelected()){
			paramProp.setProperty("forceConversionDocToImages", "true");
		}else{
			paramProp.setProperty("forceConversionDocToImages", "false");
		}
	}
	
	/**
	 * Class LoadListener
	 * 
	 * <p><em>Title: </em></p>
	 * <p>Description: </p>
	 * 
	 * @author Andres Quast, quast@hbz-nrw.de
	 * creation date: 26.01.2010
	 *
	 */
	class LoadListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        iStream = null;
	    	JFileChooser chooser = new JFileChooser();
	        chooser.setCurrentDirectory(dir);
	    	chooser.setFileFilter(new PdfFilter());
	        
	        int returnVal = chooser.showOpenDialog(guiFrame);
	        if(returnVal == JFileChooser.APPROVE_OPTION) {
	            File origPdfFile = chooser.getSelectedFile();
	            dir = chooser.getCurrentDirectory();
	            
	            iStream = FileUtil.loadFileIntoStream(origPdfFile);
	            fileName = origPdfFile.getName();
	        }
	        if (iStream != null){
	        	showProcessPdf.setEnabled(true);
	        	paramBox = createDefaultBox();
	        	refreshFrame(paramBox);
	        }
	    }
	}

	/**
	 * Class SaveListener
	 * 
	 * <p><em>Title: </em></p>
	 * <p>Description: </p>
	 * 
	 * @author Andres Quast, quast@hbz-nrw.de
	 * creation date: 26.01.2010
	 *
	 */
	class SaveListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
            log.info("Speichere PDF A" + oStream);
	        JFileChooser chooser = new JFileChooser();
	        chooser.setCurrentDirectory(dir);
	        chooser.setSelectedFile(new File( "PDFA." + fileName));
	        int returnVal = chooser.showSaveDialog(guiFrame);
	        if(returnVal == JFileChooser.APPROVE_OPTION) {
	            File saveFile = chooser.getSelectedFile();
				FileUtil.saveBase64ByteStringToFile(saveFile, oString);
	            dir = chooser.getCurrentDirectory();
	        }
	        showLoadPdf.setEnabled(true);
        	paramBox = createDefaultBox();
        	refreshFrame(paramBox);
	        
	    }
	}
	
	class LoadParamListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        iStream = null;
	    	JFileChooser chooser = new JFileChooser();
	        chooser.setCurrentDirectory(paramDir);
	        
	        int returnVal = chooser.showOpenDialog(guiFrame);
	        if(returnVal == JFileChooser.APPROVE_OPTION) {
	            File paramConfFile = chooser.getSelectedFile();
	            paramDir = chooser.getCurrentDirectory();
				try {
		            FileInputStream fis = new FileInputStream(paramConfFile);
		            BufferedInputStream bis = new BufferedInputStream(fis);
					paramProp.load(bis);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
	        }
	    }
	}
 
	/**
	 * Class SaveParamListener
	 * 
	 * <p><em>Title: </em></p>
	 * <p>Description: </p>
	 * 
	 * @author Andres Quast, quast@hbz-nrw.de
	 * creation date: 26.01.2010
	 *
	 */
	class SaveParamListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
			
	    	writeGuiParamsToProp();
	    	log.info("Speichere Parameter");
	        JFileChooser chooser = new JFileChooser();
	        chooser.setCurrentDirectory(paramDir);
	        chooser.setSelectedFile(new File( "param.cfg"));
	        int returnVal = chooser.showSaveDialog(guiFrame);
	        if(returnVal == JFileChooser.APPROVE_OPTION) {
	            File saveFile = chooser.getSelectedFile();
	            try {
					FileOutputStream fos = new FileOutputStream(saveFile);
					BufferedOutputStream bos = new BufferedOutputStream(fos);

					try {
						paramProp.store(bos, "Callas pdfaPilot Configuration File");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//bos.write(new String("Huhu").getBytes("UTF-8"));
					bos.flush();
					bos.close();

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            
	            paramDir = chooser.getCurrentDirectory();
	        }
	        showLoadPdf.setEnabled(true);
        	paramBox = createDefaultBox();
        	refreshFrame(paramBox);
	        
	    }
	}

	/**
	 * Class ExitListener
	 * 
	 * <p><em>Title: </em></p>
	 * <p>Description: </p>
	 * 
	 * @author Andres Quast, quast@hbz-nrw.de
	 * creation date: 26.01.2010
	 *
	 */
	class ExitListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        System.exit(1);
	    }
	}
	
	/**
	 * Class CreateParamsListener
	 * 
	 * <p><em>Title: </em></p>
	 * <p>Description: </p>
	 * 
	 * @author Andres Quast, quast@hbz-nrw.de
	 * creation date: 26.01.2010
	 *
	 */
	class CreateParamsListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
        	paramBox = createParamBox();
        	refreshFrame(paramBox);
	        
	    }
	}
	
	class UIManagerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println(arg0.getActionCommand());
			try {
				UIManager.setLookAndFeel(arg0.getActionCommand());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			log.info("UIManager = " + UIManager.getLookAndFeel());
			System.out.println("UIManager = " + UIManager.getLookAndFeel());
			for ( Frame f : Frame.getFrames() )
			{
			  SwingUtilities.updateComponentTreeUI( f );
			  for ( Window w : f.getOwnedWindows()  )
			    SwingUtilities.updateComponentTreeUI( w );
			}
		}
		
	}

	/**
	 * Class ParamListener
	 * 
	 * <p><em>Title: Process Parameters to Web Service Interface</em></p>
	 * <p>Description: Sub Class for listening to the Parameter 
	 * input button and processes the parameter input form. 
	 * The found parameter values from form will be submitted in 
	 * the ParameterType Objects from WebService</p>
	 * 
	 * @author aquast, email
	 * creation date: 11.01.2010
	 *
	 */
	class ParamListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			response = null;
			reportString = null;
	    	//load Gui setted Parameters into Properties if needed
			if(visitedParamBox){
				writeGuiParamsToProp();
			}else{
				// default Params should be already in Props?
				log.info("Use Default paramters");
			}
			

	    	//create ParameterType for Web Service Request
			param = PdfAPilotParameters.createParamType(paramProp);
			
			//prepare Request to Web Servvice
			showLoadPdf.setEnabled(false);
        	showProcessPdf.setEnabled(false);
			showSavePdfA.setEnabled(false);
			
			guiFrame.setCursor(Cursor.WAIT_CURSOR);
			
			alertFrame = new JFrame("Prozessor Fenster");
			JTextPane prozessTextPane = new JTextPane();
			String prozess = new String("<h3><font face=\"sans, Arial\">PDFA erstellen</font></h3>"
						+	"<p>Das Konvertieren kann je nach Dateigröße einige Zeit dauern</p>");
			
			prozessTextPane.setEditable(false);
			prozessTextPane.setEditorKit(new javax.swing.text.html.HTMLEditorKit());
			JPanel prozessPanel = new JPanel();
			// TODO: implement animated gif not via url
			Icon processIcon = createImageIconFromUrl("file:///home/aquast/git/pdfa/wsclient/src/main/resources/images/laufrad.gif");
			JLabel label = new JLabel("Bitte haben Sie etwas Geduld.", processIcon, JLabel.CENTER);
			Box prozessBox = new Box(BoxLayout.Y_AXIS);
			prozessTextPane.setText(prozess);
			prozessBox.add(prozessTextPane);
			prozessBox.add(label);
			prozessPanel.add(prozessBox);
			prozessPanel.setBackground(white);
		    alertFrame.getContentPane().add(prozessPanel);
			alertFrame.toFront();
			alertFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    alertFrame.setSize(600, 200);
		    alertFrame.setLocationRelativeTo(guiFrame);
		    alertFrame.setVisible(true);
		    new Worker().execute();

        	guiFrame.repaint();
		}

	}
	
	/**
	 * Class PdfFilter
	 * 
	 * <p><em>Title: Displays *.pdf at filechooser dialog</em></p>
	 * <p>Description: Sub Class for displaying only files with 
	 * pdf extension at the filechooser dialog</p>
	 * 
	 * @author aquast, email
	 * creation date: 11.01.2010
	 *
	 */
	class PdfFilter extends javax.swing.filechooser.FileFilter{
        public boolean accept(File f) {
            return f.getName().toLowerCase().endsWith(".pdf") || f.isDirectory();
        }
        public String getDescription() {
            return "PDF-Datei (*.pdf)";
        }
    }

	/**
	 * <p><em>Title: </em></p>
	 * <p>Description: Returns an ImageIcon, or null if the path is invalid</p>
	 * 
	 * @param path
	 * @return 
	 */
	protected ImageIcon createImageIconFromUrl(String path) {
	    
		URL imgURL = null;
		try {
			imgURL = new URL(path);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    if (imgURL != null) {
	        return new ImageIcon(imgURL);
	    } else {
	        log.error("Couldn't find file: " + path);
	        return null;
	    }
	}
	

	/**
	 * <p><em>Title: </em></p>
	 * <p>Description: Returns an ImageIcon, or null if the path is invalid</p>
	 * 
	 * @param path
	 * @return 
	 */
	protected ImageIcon createImageIcon(String path) {
	    
		ImageIcon imgIcon = null;
		Image image = null;
		try {
			image = ImageIO.read(getClass().getResource(path));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    if (image != null) {
	        return new ImageIcon(image);
	    } else {
	        log.error("Couldn't find file: " + path);
	        return null;
	    }
	}

	/**
	 * @param param
	 */
	private void processorCall(ParameterType param){
    	ClientImpl client = new ClientImpl();

    	/** Prepare a Stream Request **/
		// create ConvertFromStream Request 
		ConvertFromStream convStream = new ConvertFromStream();
		convStream.setConverterParameters(param);
		// parse stream into String 
		String iString = null;
		oString = new String();
			try {
			iString = new String(iStream, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			log.error(e1);
			e1.printStackTrace();
		}
		convStream.setByteStream(iString);
	
		try{
			log.info("sending Request");
			response = client.convertFromStream(convStream); 
			oString = response.getResponseDocumentStream();
			remoteFileName = response.getJobIdentifier() + ".pdf";
		}catch(RemoteException exc){
    		paramBox = createDefaultBox();
	        showLoadPdf.setEnabled(true);
    		showSavePdfA.setEnabled(false);
			JOptionPane.showMessageDialog(guiFrame, "Fehler bei Serverzugriff: \n" + exc.getMessage());
			log.error(exc);
			//exc.printStackTrace();
		}catch(ConvertFromStream_faultMsg cexc){
    		paramBox = createDefaultBox();
	        showLoadPdf.setEnabled(true);
    		showSavePdfA.setEnabled(false);
    		paramBox = createDefaultBox();
			JOptionPane.showMessageDialog(guiFrame, "Server antwortet mit: " + cexc);
			log.error(cexc);
			cexc.printStackTrace();
		}	
		//log.info("Stream in Response = " +  oString);
	}
	
	class Worker extends SwingWorker<Object, String>{

		@Override
		protected Object doInBackground() throws Exception {
			runProcessing();
			//Thread.sleep(3000);
			return null;
		}
		
		protected void done(){
			alertFrame.dispose();
			log.info("Alertframe dispose");
			if(oString == null && reportString != null){
				JOptionPane.showMessageDialog(guiFrame, "ACHTUNG! \nDie PDF-Datei konnte nicht konvertiert werden" 
						+ "\nBitte schauen Sie in den Report um die Ursache zu finden");
				showSavePdfA.setEnabled(false);
				fNames.add(new String[]{fileName});
			}else if(oString != null && reportString != null){
				showSavePdfA.setEnabled(true);
				fNames.add(new String[]{fileName});
			}else if(oString == null && reportString == null){
				JOptionPane.showMessageDialog(guiFrame, "ACHTUNG! \nDie PDF-Datei konnte nicht konvertiert werden" 
						+ "\nLeider konnte auch kein Report erstellt werden"
						+ "\nKontaktieren Sie bitte publikationssysteme@hbz-nrw.de \nunter Angabe der Job-ID: \n"
						+ response.getJobIdentifier());
				showSavePdfA.setEnabled(false);
				showLoadPdf.setEnabled(true);
			}
			for(int i= 0; i < fNames.size(); i++){
				for(int j=0; j < fNames.get(i).length; j++){
					System.out.println(fNames.get(i)[j].toString());
				}
			}

		}
		
	}

	
	
	
	

	/*public void processorThread(){
		Thread convert = new Thread(this);
		convert.start();
		
	}*/
	
	public void runProcessing() {

		processorCall(param);
		//get back the Reports
		if(response != null && response.getReportStream() != null){
    		reportString = response.getReportStream();
    		showLoadPdf.setEnabled(true);
    		log.info(response.getReportStream());
		}
		else{
			log.warn("Leerer ReportStream!");
			
		}
		
		paramBox = createResultBox();
		guiFrame.setCursor(Cursor.DEFAULT_CURSOR);
		guiFrame.repaint();
		refreshFrame(paramBox);
		
	}
	

}
