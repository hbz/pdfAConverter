
/**
 * PdfAConverterCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

    package de.hbz_nrw.www.pdfaconverter.services;

    /**
     *  PdfAConverterCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class PdfAConverterCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public PdfAConverterCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public PdfAConverterCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for convertFromUrl method
            * override this method for handling normal response from convertFromUrl operation
            */
           public void receiveResultconvertFromUrl(
                    de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrlResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from convertFromUrl operation
           */
            public void receiveErrorconvertFromUrl(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for convertFromAttachment method
            * override this method for handling normal response from convertFromAttachment operation
            */
           public void receiveResultconvertFromAttachment(
                    de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachmentResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from convertFromAttachment operation
           */
            public void receiveErrorconvertFromAttachment(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for convertFromStream method
            * override this method for handling normal response from convertFromStream operation
            */
           public void receiveResultconvertFromStream(
                    de.hbz_nrw.www.pdfaconverter.types.ConvertFromStreamResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from convertFromStream operation
           */
            public void receiveErrorconvertFromStream(java.lang.Exception e) {
            }
                


    }
    