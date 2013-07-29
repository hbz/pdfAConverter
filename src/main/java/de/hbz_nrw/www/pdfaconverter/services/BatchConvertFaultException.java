
/**
 * BatchConvertFaultException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package de.hbz_nrw.www.pdfaconverter.services;

public class BatchConvertFaultException extends java.lang.Exception{

    private static final long serialVersionUID = 1374654308035L;
    
    private de.hbz_nrw.www.pdfaconverter.services.BatchConvertFault faultMessage;

    
        public BatchConvertFaultException() {
            super("BatchConvertFaultException");
        }

        public BatchConvertFaultException(java.lang.String s) {
           super(s);
        }

        public BatchConvertFaultException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public BatchConvertFaultException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(de.hbz_nrw.www.pdfaconverter.services.BatchConvertFault msg){
       faultMessage = msg;
    }
    
    public de.hbz_nrw.www.pdfaconverter.services.BatchConvertFault getFaultMessage(){
       return faultMessage;
    }
}
    