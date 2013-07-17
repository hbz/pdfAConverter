
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:41 LKT)
 */

            package de.hbz_nrw.www.pdfaconverter.types;
            /**
            *  ExtensionMapper class
            */
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://www.hbz-nrw.de/PdfAConverter/types/".equals(namespaceURI) &&
                  "htmlOptionType".equals(typeName)){
                   
                            return  de.hbz_nrw.www.pdfaconverter.types.HtmlOptionType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://www.hbz-nrw.de/PdfAConverter/types/".equals(namespaceURI) &&
                  "reportLangType".equals(typeName)){
                   
                            return  de.hbz_nrw.www.pdfaconverter.types.ReportLangType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://www.hbz-nrw.de/PdfAConverter/types/".equals(namespaceURI) &&
                  "documentType".equals(typeName)){
                   
                            return  de.hbz_nrw.www.pdfaconverter.types.DocumentType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://www.hbz-nrw.de/PdfAConverter/types/".equals(namespaceURI) &&
                  "reportFormatType".equals(typeName)){
                   
                            return  de.hbz_nrw.www.pdfaconverter.types.ReportFormatType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://www.hbz-nrw.de/PdfAConverter/types/".equals(namespaceURI) &&
                  "compliancyLevelType".equals(typeName)){
                   
                            return  de.hbz_nrw.www.pdfaconverter.types.CompliancyLevelType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://www.hbz-nrw.de/PdfAConverter/types/".equals(namespaceURI) &&
                  "reportTriggerType".equals(typeName)){
                   
                            return  de.hbz_nrw.www.pdfaconverter.types.ReportTriggerType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://www.hbz-nrw.de/PdfAConverter/types/".equals(namespaceURI) &&
                  "authorizationType".equals(typeName)){
                   
                            return  de.hbz_nrw.www.pdfaconverter.types.AuthorizationType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://www.hbz-nrw.de/PdfAConverter/types/".equals(namespaceURI) &&
                  "parameterType".equals(typeName)){
                   
                            return  de.hbz_nrw.www.pdfaconverter.types.ParameterType.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    