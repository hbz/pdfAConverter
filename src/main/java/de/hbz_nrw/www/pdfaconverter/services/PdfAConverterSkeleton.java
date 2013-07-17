
/**
 * PdfAConverterSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */
    package de.hbz_nrw.www.pdfaconverter.services;
    /**
     *  PdfAConverterSkeleton java skeleton for the axisService
     */
    public class PdfAConverterSkeleton implements PdfAConverterSkeletonInterface{
        
         
        /**
         * Auto generated method signature
         * Operation converts a PDF supplied by an URL to PDF/A. Operation returns 2 URLs: one for the PDF/A and one for the Report.
                                     * @param convertFromUrl0
             * @throws ConvertFromUrl_faultMsg : 
         */
        
                 public de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrlResponse convertFromUrl
                  (
                  de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl convertFromUrl0
                  )
            throws ConvertFromUrl_faultMsg{
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#convertFromUrl");
        }
     
         
        /**
         * Auto generated method signature
         * Operation uses SwA (Soap with Attachment) for supplying the PDF to the PDF/A Converter. Operation returns an Attachment with the PDF/A and an Attachment with the Record inside
                                     * @param convertFromAttachment2
             * @throws ConvertFromAttachment_faultMsg : 
         */
        
                 public de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachmentResponse convertFromAttachment
                  (
                  de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment convertFromAttachment2
                  )
            throws ConvertFromAttachment_faultMsg{
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#convertFromAttachment");
        }
     
         
        /**
         * Auto generated method signature
         * Operation converts a PDF supplied within the SOAP Message as Byte-Stream to PDF/A. Operation returns one Bytestream for the PDF/A and one for the Report associated.
                                     * @param convertFromStream4
             * @throws ConvertFromStream_faultMsg : 
         */
        
                 public de.hbz_nrw.www.pdfaconverter.types.ConvertFromStreamResponse convertFromStream
                  (
                  de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream convertFromStream4
                  )
            throws ConvertFromStream_faultMsg{
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#convertFromStream");
        }
     
    }
    