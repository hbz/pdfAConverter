
/**
 * PdfAConverterSkeletonInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */
    package de.hbz_nrw.www.pdfaconverter.services;
    /**
     *  PdfAConverterSkeletonInterface java skeleton interface for the axisService
     */
    public interface PdfAConverterSkeletonInterface {
     
         
        /**
         * Auto generated method signature
         * Operation converts a PDF supplied by an URL to PDF/A. Operation returns 2 URLs: one for the PDF/A and one for the Report.
                                    * @param convertFromUrl
             * @throws ConvertFromUrl_faultMsg : 
         */

        
                public de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrlResponse convertFromUrl
                (
                  de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl convertFromUrl
                 )
            throws ConvertFromUrl_faultMsg;
        
         
        /**
         * Auto generated method signature
         * Operation uses SwA (Soap with Attachment) for supplying the PDF to the PDF/A Converter. Operation returns an Attachment with the PDF/A and an Attachment with the Record inside
                                    * @param convertFromAttachment
             * @throws ConvertFromAttachment_faultMsg : 
         */

        
                public de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachmentResponse convertFromAttachment
                (
                  de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment convertFromAttachment
                 )
            throws ConvertFromAttachment_faultMsg;
        
         
        /**
         * Auto generated method signature
         * Operation converts a PDF supplied within the SOAP Message as Byte-Stream to PDF/A. Operation returns one Bytestream for the PDF/A and one for the Report associated.
                                    * @param convertFromStream
             * @throws ConvertFromStream_faultMsg : 
         */

        
                public de.hbz_nrw.www.pdfaconverter.types.ConvertFromStreamResponse convertFromStream
                (
                  de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream convertFromStream
                 )
            throws ConvertFromStream_faultMsg;
        
         }
    