
/**
 * ConvertFromStream_faultMsg.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

package de.hbz_nrw.www.pdfaconverter.services;

public class ConvertFromStream_faultMsg extends java.lang.Exception{
    
    private de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream_fault faultMessage;
    
    public ConvertFromStream_faultMsg() {
        super("ConvertFromStream_faultMsg");
    }
           
    public ConvertFromStream_faultMsg(java.lang.String s) {
       super(s);
    }
    
    public ConvertFromStream_faultMsg(java.lang.String s, java.lang.Throwable ex) {
      super(s, ex);
    }
    
    public void setFaultMessage(de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream_fault msg){
       faultMessage = msg;
    }
    
    public de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream_fault getFaultMessage(){
       return faultMessage;
    }
}
    