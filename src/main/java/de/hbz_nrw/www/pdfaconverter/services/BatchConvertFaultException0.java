
/**
 * BatchConvertFaultException0.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

package de.hbz_nrw.www.pdfaconverter.services;

public class BatchConvertFaultException0 extends java.lang.Exception{
    
    private de.hbz_nrw.www.pdfaconverter.services.BatchConvertFault faultMessage;
    
    public BatchConvertFaultException0() {
        super("BatchConvertFaultException0");
    }
           
    public BatchConvertFaultException0(java.lang.String s) {
       super(s);
    }
    
    public BatchConvertFaultException0(java.lang.String s, java.lang.Throwable ex) {
      super(s, ex);
    }
    
    public void setFaultMessage(de.hbz_nrw.www.pdfaconverter.services.BatchConvertFault msg){
       faultMessage = msg;
    }
    
    public de.hbz_nrw.www.pdfaconverter.services.BatchConvertFault getFaultMessage(){
       return faultMessage;
    }
}
    