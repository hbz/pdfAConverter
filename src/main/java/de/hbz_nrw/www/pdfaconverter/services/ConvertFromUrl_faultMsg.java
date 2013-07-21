
/**
 * ConvertFromUrl_faultMsg.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

package de.hbz_nrw.www.pdfaconverter.services;

public class ConvertFromUrl_faultMsg extends java.lang.Exception{
    
    private de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl_fault faultMessage;
    
    public ConvertFromUrl_faultMsg() {
        super("ConvertFromUrl_faultMsg");
    }
           
    public ConvertFromUrl_faultMsg(java.lang.String s) {
       super(s);
    }
    
    public ConvertFromUrl_faultMsg(java.lang.String s, java.lang.Throwable ex) {
      super(s, ex);
    }
    
    public void setFaultMessage(de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl_fault msg){
       faultMessage = msg;
    }
    
    public de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl_fault getFaultMessage(){
       return faultMessage;
    }
}
    