

/**
 * PdfAConverter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

    package de.hbz_nrw.www.pdfaconverter.services;

    /*
     *  PdfAConverter java interface
     */

    public interface PdfAConverter {
          

        /**
          * Auto generated method signature
          * Operation converts a PDF supplied by an URL to PDF/A. Operation returns 2 URLs: one for the PDF/A and one for the Report.
                    * @param convertFromUrl42
                
             * @throws de.hbz_nrw.www.pdfaconverter.services.ConvertFromUrl_faultMsg : 
         */

         
                     public de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrlResponse convertFromUrl(

                        de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl convertFromUrl42)
                        throws java.rmi.RemoteException
             
          ,de.hbz_nrw.www.pdfaconverter.services.ConvertFromUrl_faultMsg;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * Operation converts a PDF supplied by an URL to PDF/A. Operation returns 2 URLs: one for the PDF/A and one for the Report.
                * @param convertFromUrl42
            
          */
        public void startconvertFromUrl(

            de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl convertFromUrl42,

            final de.hbz_nrw.www.pdfaconverter.services.PdfAConverterCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * Operation uses SwA (Soap with Attachment) for supplying the PDF to the PDF/A Converter. Operation returns an Attachment with the PDF/A and an Attachment with the Record inside
                    * @param convertFromAttachment44
                
             * @throws de.hbz_nrw.www.pdfaconverter.services.ConvertFromAttachment_faultMsg : 
         */

         
                     public de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachmentResponse convertFromAttachment(

                        de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment convertFromAttachment44)
                        throws java.rmi.RemoteException
             
          ,de.hbz_nrw.www.pdfaconverter.services.ConvertFromAttachment_faultMsg;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * Operation uses SwA (Soap with Attachment) for supplying the PDF to the PDF/A Converter. Operation returns an Attachment with the PDF/A and an Attachment with the Record inside
                * @param convertFromAttachment44
            
          */
        public void startconvertFromAttachment(

            de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment convertFromAttachment44,

            final de.hbz_nrw.www.pdfaconverter.services.PdfAConverterCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * Operation converts a PDF supplied within the SOAP Message as Byte-Stream to PDF/A. Operation returns one Bytestream for the PDF/A and one for the Report associated.
                    * @param convertFromStream46
                
             * @throws de.hbz_nrw.www.pdfaconverter.services.ConvertFromStream_faultMsg : 
         */

         
                     public de.hbz_nrw.www.pdfaconverter.types.ConvertFromStreamResponse convertFromStream(

                        de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream convertFromStream46)
                        throws java.rmi.RemoteException
             
          ,de.hbz_nrw.www.pdfaconverter.services.ConvertFromStream_faultMsg;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * Operation converts a PDF supplied within the SOAP Message as Byte-Stream to PDF/A. Operation returns one Bytestream for the PDF/A and one for the Report associated.
                * @param convertFromStream46
            
          */
        public void startconvertFromStream(

            de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream convertFromStream46,

            final de.hbz_nrw.www.pdfaconverter.services.PdfAConverterCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    