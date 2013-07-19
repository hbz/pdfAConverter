/**
 * 
 */
package de.hbz_nrw.www.pdfaconverter.ServerImpl;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



/**
 * @author aquast
 *
 */
public class Configuration {

	// Initialize logger object 
	private static Logger log = null;

	private static final String host = "nyx.hbz-nrw.de";
	private static final String tempDirUrl = "http://" + host + ":8080/temp/";
	
	// Directory for Configuration files
	private static final String configFileDir(){
		String confDir = null;

		if(System.getProperty("os.name").equals("SunOS")){
			System.setProperty("user.dir", "/var/tomcat6/webapps");
		}

		System.out.println("active Dir: " + System.getProperty("user.dir"));
		System.out.println("OS: " + System.getProperty("os.name"));

		confDir = System.getProperty("user.dir") + "/conf/";
		return confDir;
	}
	
	// Directory for temporary stored PDF Files
	private static final String tempFileDir(){
		String tempDir = null;

		if(System.getProperty("os.name").equals("SunOS")){
			System.setProperty("user.dir", "/var/tomcat6/webapps");
		}
		else{
			System.setProperty("user.dir", "/srv/tomcat6/webapps/axis2");
		}
		
		tempDir = System.getProperty("user.dir") + "/temp/";
		return tempDir;
	}

	
	/**
	 *  Method for initiate Logging System which include Logger 
	 *  Configuration from log4j.properties 
	 *  @author Andres Quast 
	 */
	public static void initLog() {
		
		
		File logConfiguration = new File(configFileDir() + "log4j.properties");		
		logConfiguration = new File("log4j.properties");		
		
		if (logConfiguration.isFile()) {
			try {
				PropertyConfigurator.configure(logConfiguration.getAbsolutePath());
				System.out.println("read log4j-configuration file at: " + logConfiguration.getAbsolutePath());
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
		else{
			System.out.println("cannot read log4j-configuration file at: " + configFileDir() + "log4j.properties");
		}
		log = Logger.getLogger(Configuration.class);
		log.info("Logging System activated,");
	}

	public static String getConfigfiledir() {
		return configFileDir();
	}

	public static String getTempfiledir() {
		return tempFileDir();
	}

	public static String getTempdirurl() {
		return tempDirUrl;
	}

}
