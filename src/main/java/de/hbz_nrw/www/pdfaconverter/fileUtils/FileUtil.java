/**
 * FileUtil.java - This file is part of the DiPP Project by hbz
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
package de.hbz_nrw.www.pdfaconverter.fileUtils;

import org.apache.log4j.Logger;
import org.apache.commons.codec.binary.Base64;

import de.hbz_nrw.www.pdfaconverter.ServerImpl.Configuration;


import java.util.List;
import java.util.Vector;
import java.io.*;
import java.net.URL;
import java.net.MalformedURLException;


/**
 * Class filteUtil
 * 
 * <p><em>Title: </em></p>
 * <p>Description: </p>
 * 
 * @author aquast, email
 * creation date: 24.09.2009
 *
 */
public class FileUtil {

	// Initiate Logger for filteUtil
	private static Logger log = Logger.getLogger(FileUtil.class);
	
	private static File inputFile = null;

	/**
	 * <p><em>Title: Create a temporary File from byteStream</em></p>
	 * <p>Description: Method creates a temporary file from the bytestream 
	 * representing the orginal PDF, that should be converted</p>
	 * 
	 * @param stream <code>String</code> 
	 * @return <code>String</code> Filename of newly created temporary File
	 */
	public static String saveStreamToTempFile(String fileName, String stream){
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try{
			//System.out.println("Base64 kodierter Stream: " + stream.length());
			inputFile = new File(Configuration.getTempfiledir() + fileName);
			log.info(Configuration.getTempfiledir());
			fos = new FileOutputStream(inputFile);
			bos = new BufferedOutputStream(fos);			
			bos.write(Base64.decodeBase64(stream.getBytes("UTF-8")));
			
		}catch(IOException ioExc){
			log.error(ioExc);
		}finally{
			if(bos != null){
				try{
					bos.close();
				}catch(IOException ioExc){
					log.error(ioExc);
				}
			}
			if(fos != null){
				try{
					fos.close();
				}catch(IOException ioExc){
					log.error(ioExc);
				}
			}
		}
		log.info("File-Size, Ergebnis: " + inputFile.length());
		return inputFile.getName();
	}


	public static String saveStringToTempFile(String fileName, String contentString){
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try{
			//System.out.println("Base64 kodierter Stream: " + stream.length());
			inputFile = new File(Configuration.getTempfiledir() + fileName);
			log.info(Configuration.getTempfiledir());
			fos = new FileOutputStream(inputFile);
			bos = new BufferedOutputStream(fos);			
			bos.write(contentString.getBytes("UTF-8"));
			
		}catch(IOException ioExc){
			log.error(ioExc);
		}finally{
			if(bos != null){
				try{
					bos.close();
				}catch(IOException ioExc){
					log.error(ioExc);
				}
			}
			if(fos != null){
				try{
					fos.close();
				}catch(IOException ioExc){
					log.error(ioExc);
				}
			}
		}
		log.info("File-Size, Ergebnis: " + inputFile.length());
		return inputFile.getName();
	}

	
	/**
	 * <p><em>Title: Create a File from byteStream</em></p>
	 * <p>Description: Method creates a file from the bytestream 
	 * representing the original PDF, that should be converted</p>
	 * 
	 * @param stream <code>String</code> 
	 * @return <code>String</code> Filename of newly created temporary File
	 */
	public static String saveStreamToFile(File outputFile, String stream){
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try{
			fos = new FileOutputStream(outputFile);
			bos = new BufferedOutputStream(fos);			
			bos.write(Base64.decodeBase64(stream.getBytes("UTF-8")));
			bos.flush();
			bos.close();
			
		}catch(IOException ioExc){
			log.error(ioExc);
		}finally{
			if(bos != null){
				try{
					bos.close();
				}catch(IOException ioExc){
					log.error(ioExc);
				}
			}
			if(fos != null){
				try{
					fos.close();
				}catch(IOException ioExc){
					log.error(ioExc);
				}
			}
		}
		return outputFile.getName();
	}

	public static byte[] loadFileIntoStream(File origPidfFile){
		FileInputStream fis = null;
		byte[] pdfStream = null;
		byte[] pdfRawStream = null;
		try{
			fis = new FileInputStream(origPidfFile);
			int i = (int) origPidfFile.length();			
			byte[] b = new byte[i];
		   	fis.read(b);
			pdfRawStream = b; 
			pdfStream = Base64.encodeBase64(pdfRawStream);			
		}catch(IOException ioExc){
			System.out.println(ioExc);
			log.error(ioExc);
		}finally{
			if(fis != null){
				try{
					fis.close();
				}catch(IOException ioExc){
					log.error(ioExc);
				}
			}
		}
		return pdfStream;
	}

	/**
	 * <p><em>Title: Create a temporary File from a file identified by URL</em></p>
	 * <p>Description: Method creates a temporary file from a remote file addressed 
	 * an by URL representing the orginal PDF, that should be converted</p>
	 * 
	 * @param fileName
	 * @param url
	 * @return 
	 */
	public static String saveUrlToFile(String fileName, String url){
		File inputFile = new File(Configuration.getTempfiledir() + fileName);
		InputStream is = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		FileOutputStream fos = null;
		
		log.info(url);
		try{
			URL inputDocument = new URL(url);
			is = inputDocument.openStream();
			bis = new BufferedInputStream(is);

			fos = new FileOutputStream(inputFile);
			bos = new BufferedOutputStream(fos);
			int i = -1;
			while((i = bis.read()) != -1){
				bos.write(i);
			}
		}catch(Exception e){
			log.error(e);
		}finally{
			if(bos != null){
				try{
					bos.close();
				}catch(IOException ioExc){
					log.error(ioExc);
				}
			}
			if(fos != null){
				try{
					fos.close();
				}catch(IOException ioExc){
					log.error(ioExc);
				}
			}
			if(bis != null){
				try{
					bis.close();
				}catch(IOException ioExc){
					log.error(ioExc);
				}
			}
			if(is != null){
				try{
					is.close();
				}catch(IOException ioExc){
					log.error(ioExc);
				}
			}
		}
		return inputFile.getName();
	}

}
