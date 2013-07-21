
/**
 * ConvertFromAttachment_faultMsg.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

package de.hbz_nrw.www.pdfaconverter.services;

public class ConvertFromAttachment_faultMsg extends java.lang.Exception{
    
    private de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment_fault faultMessage;
    
    public ConvertFromAttachment_faultMsg() {
        super("ConvertFromAttachment_faultMsg");
    }
           
    public ConvertFromAttachment_faultMsg(java.lang.String s) {
       super(s);
    }
    
    public ConvertFromAttachment_faultMsg(java.lang.String s, java.lang.Throwable ex) {
      super(s, ex);
    }
    
    public void setFaultMessage(de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment_fault msg){
       faultMessage = msg;
    }
    
    public de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment_fault getFaultMessage(){
       return faultMessage;
    }
}
    