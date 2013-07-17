
/**
 * ParameterType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:41 LKT)
 */
            
                package de.hbz_nrw.www.pdfaconverter.types;
            

            /**
            *  ParameterType bean class
            */
        
        public  class ParameterType
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = parameterType
                Namespace URI = http://www.hbz-nrw.de/PdfAConverter/types/
                Namespace Prefix = ns1
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://www.hbz-nrw.de/PdfAConverter/types/")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for QuickProcessing
                        */

                        
                                    protected boolean localQuickProcessing ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localQuickProcessingTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getQuickProcessing(){
                               return localQuickProcessing;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param QuickProcessing
                               */
                               public void setQuickProcessing(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (false) {
                                           localQuickProcessingTracker = false;
                                              
                                       } else {
                                          localQuickProcessingTracker = true;
                                       }
                                   
                                            this.localQuickProcessing=param;
                                    

                               }
                            

                        /**
                        * field for AnalyseOnly
                        */

                        
                                    protected boolean localAnalyseOnly ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAnalyseOnlyTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getAnalyseOnly(){
                               return localAnalyseOnly;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AnalyseOnly
                               */
                               public void setAnalyseOnly(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (false) {
                                           localAnalyseOnlyTracker = false;
                                              
                                       } else {
                                          localAnalyseOnlyTracker = true;
                                       }
                                   
                                            this.localAnalyseOnly=param;
                                    

                               }
                            

                        /**
                        * field for ReturnOnlyValidPDFA
                        */

                        
                                    protected boolean localReturnOnlyValidPDFA ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localReturnOnlyValidPDFATracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getReturnOnlyValidPDFA(){
                               return localReturnOnlyValidPDFA;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ReturnOnlyValidPDFA
                               */
                               public void setReturnOnlyValidPDFA(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (false) {
                                           localReturnOnlyValidPDFATracker = false;
                                              
                                       } else {
                                          localReturnOnlyValidPDFATracker = true;
                                       }
                                   
                                            this.localReturnOnlyValidPDFA=param;
                                    

                               }
                            

                        /**
                        * field for CompliancyLevel
                        */

                        
                                    protected de.hbz_nrw.www.pdfaconverter.types.CompliancyLevelType localCompliancyLevel ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCompliancyLevelTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return de.hbz_nrw.www.pdfaconverter.types.CompliancyLevelType
                           */
                           public  de.hbz_nrw.www.pdfaconverter.types.CompliancyLevelType getCompliancyLevel(){
                               return localCompliancyLevel;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CompliancyLevel
                               */
                               public void setCompliancyLevel(de.hbz_nrw.www.pdfaconverter.types.CompliancyLevelType param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localCompliancyLevelTracker = true;
                                       } else {
                                          localCompliancyLevelTracker = false;
                                              
                                       }
                                   
                                            this.localCompliancyLevel=param;
                                    

                               }
                            

                        /**
                        * field for ReportFormat
                        * This was an Array!
                        */

                        
                                    protected de.hbz_nrw.www.pdfaconverter.types.ReportFormatType[] localReportFormat ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localReportFormatTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return de.hbz_nrw.www.pdfaconverter.types.ReportFormatType[]
                           */
                           public  de.hbz_nrw.www.pdfaconverter.types.ReportFormatType[] getReportFormat(){
                               return localReportFormat;
                           }

                           
                        


                               
                              /**
                               * validate the array for ReportFormat
                               */
                              protected void validateReportFormat(de.hbz_nrw.www.pdfaconverter.types.ReportFormatType[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param ReportFormat
                              */
                              public void setReportFormat(de.hbz_nrw.www.pdfaconverter.types.ReportFormatType[] param){
                              
                                   validateReportFormat(param);

                               
                                          if (param != null){
                                             //update the setting tracker
                                             localReportFormatTracker = true;
                                          } else {
                                             localReportFormatTracker = false;
                                                 
                                          }
                                      
                                      this.localReportFormat=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param de.hbz_nrw.www.pdfaconverter.types.ReportFormatType
                             */
                             public void addReportFormat(de.hbz_nrw.www.pdfaconverter.types.ReportFormatType param){
                                   if (localReportFormat == null){
                                   localReportFormat = new de.hbz_nrw.www.pdfaconverter.types.ReportFormatType[]{};
                                   }

                            
                                 //update the setting tracker
                                localReportFormatTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localReportFormat);
                               list.add(param);
                               this.localReportFormat =
                             (de.hbz_nrw.www.pdfaconverter.types.ReportFormatType[])list.toArray(
                            new de.hbz_nrw.www.pdfaconverter.types.ReportFormatType[list.size()]);

                             }
                             

                        /**
                        * field for ReportLang
                        */

                        
                                    protected de.hbz_nrw.www.pdfaconverter.types.ReportLangType localReportLang ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localReportLangTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return de.hbz_nrw.www.pdfaconverter.types.ReportLangType
                           */
                           public  de.hbz_nrw.www.pdfaconverter.types.ReportLangType getReportLang(){
                               return localReportLang;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ReportLang
                               */
                               public void setReportLang(de.hbz_nrw.www.pdfaconverter.types.ReportLangType param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localReportLangTracker = true;
                                       } else {
                                          localReportLangTracker = false;
                                              
                                       }
                                   
                                            this.localReportLang=param;
                                    

                               }
                            

                        /**
                        * field for ReportTrigger
                        */

                        
                                    protected de.hbz_nrw.www.pdfaconverter.types.ReportTriggerType localReportTrigger ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localReportTriggerTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return de.hbz_nrw.www.pdfaconverter.types.ReportTriggerType
                           */
                           public  de.hbz_nrw.www.pdfaconverter.types.ReportTriggerType getReportTrigger(){
                               return localReportTrigger;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ReportTrigger
                               */
                               public void setReportTrigger(de.hbz_nrw.www.pdfaconverter.types.ReportTriggerType param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localReportTriggerTracker = true;
                                       } else {
                                          localReportTriggerTracker = false;
                                              
                                       }
                                   
                                            this.localReportTrigger=param;
                                    

                               }
                            

                        /**
                        * field for HtmlReportOptions
                        * This was an Array!
                        */

                        
                                    protected de.hbz_nrw.www.pdfaconverter.types.HtmlOptionType[] localHtmlReportOptions ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localHtmlReportOptionsTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return de.hbz_nrw.www.pdfaconverter.types.HtmlOptionType[]
                           */
                           public  de.hbz_nrw.www.pdfaconverter.types.HtmlOptionType[] getHtmlReportOptions(){
                               return localHtmlReportOptions;
                           }

                           
                        


                               
                              /**
                               * validate the array for HtmlReportOptions
                               */
                              protected void validateHtmlReportOptions(de.hbz_nrw.www.pdfaconverter.types.HtmlOptionType[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param HtmlReportOptions
                              */
                              public void setHtmlReportOptions(de.hbz_nrw.www.pdfaconverter.types.HtmlOptionType[] param){
                              
                                   validateHtmlReportOptions(param);

                               
                                          if (param != null){
                                             //update the setting tracker
                                             localHtmlReportOptionsTracker = true;
                                          } else {
                                             localHtmlReportOptionsTracker = false;
                                                 
                                          }
                                      
                                      this.localHtmlReportOptions=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param de.hbz_nrw.www.pdfaconverter.types.HtmlOptionType
                             */
                             public void addHtmlReportOptions(de.hbz_nrw.www.pdfaconverter.types.HtmlOptionType param){
                                   if (localHtmlReportOptions == null){
                                   localHtmlReportOptions = new de.hbz_nrw.www.pdfaconverter.types.HtmlOptionType[]{};
                                   }

                            
                                 //update the setting tracker
                                localHtmlReportOptionsTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localHtmlReportOptions);
                               list.add(param);
                               this.localHtmlReportOptions =
                             (de.hbz_nrw.www.pdfaconverter.types.HtmlOptionType[])list.toArray(
                            new de.hbz_nrw.www.pdfaconverter.types.HtmlOptionType[list.size()]);

                             }
                             

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       ParameterType.this.serialize(parentQName,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               parentQName,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://www.hbz-nrw.de/PdfAConverter/types/");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":parameterType",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "parameterType",
                           xmlWriter);
                   }

               
                   }
                if (localQuickProcessingTracker){
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"quickProcessing", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"quickProcessing");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("quickProcessing");
                                    }
                                
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("quickProcessing cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQuickProcessing));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localAnalyseOnlyTracker){
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"analyseOnly", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"analyseOnly");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("analyseOnly");
                                    }
                                
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("analyseOnly cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAnalyseOnly));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localReturnOnlyValidPDFATracker){
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"returnOnlyValidPDFA", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"returnOnlyValidPDFA");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("returnOnlyValidPDFA");
                                    }
                                
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("returnOnlyValidPDFA cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localReturnOnlyValidPDFA));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCompliancyLevelTracker){
                                            if (localCompliancyLevel==null){
                                                 throw new org.apache.axis2.databinding.ADBException("compliancyLevel cannot be null!!");
                                            }
                                           localCompliancyLevel.serialize(new javax.xml.namespace.QName("","compliancyLevel"),
                                               factory,xmlWriter);
                                        } if (localReportFormatTracker){
                                       if (localReportFormat!=null){
                                            for (int i = 0;i < localReportFormat.length;i++){
                                                if (localReportFormat[i] != null){
                                                 localReportFormat[i].serialize(new javax.xml.namespace.QName("","reportFormat"),
                                                           factory,xmlWriter);
                                                } else {
                                                   
                                                        // we don't have to do any thing since minOccures is zero
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("reportFormat cannot be null!!");
                                        
                                    }
                                 } if (localReportLangTracker){
                                            if (localReportLang==null){
                                                 throw new org.apache.axis2.databinding.ADBException("reportLang cannot be null!!");
                                            }
                                           localReportLang.serialize(new javax.xml.namespace.QName("","reportLang"),
                                               factory,xmlWriter);
                                        } if (localReportTriggerTracker){
                                            if (localReportTrigger==null){
                                                 throw new org.apache.axis2.databinding.ADBException("reportTrigger cannot be null!!");
                                            }
                                           localReportTrigger.serialize(new javax.xml.namespace.QName("","reportTrigger"),
                                               factory,xmlWriter);
                                        } if (localHtmlReportOptionsTracker){
                                       if (localHtmlReportOptions!=null){
                                            for (int i = 0;i < localHtmlReportOptions.length;i++){
                                                if (localHtmlReportOptions[i] != null){
                                                 localHtmlReportOptions[i].serialize(new javax.xml.namespace.QName("","htmlReportOptions"),
                                                           factory,xmlWriter);
                                                } else {
                                                   
                                                        // we don't have to do any thing since minOccures is zero
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("htmlReportOptions cannot be null!!");
                                        
                                    }
                                 }
                    xmlWriter.writeEndElement();
               

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localQuickProcessingTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "quickProcessing"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQuickProcessing));
                            } if (localAnalyseOnlyTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "analyseOnly"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAnalyseOnly));
                            } if (localReturnOnlyValidPDFATracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "returnOnlyValidPDFA"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localReturnOnlyValidPDFA));
                            } if (localCompliancyLevelTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "compliancyLevel"));
                            
                            
                                    if (localCompliancyLevel==null){
                                         throw new org.apache.axis2.databinding.ADBException("compliancyLevel cannot be null!!");
                                    }
                                    elementList.add(localCompliancyLevel);
                                } if (localReportFormatTracker){
                             if (localReportFormat!=null) {
                                 for (int i = 0;i < localReportFormat.length;i++){

                                    if (localReportFormat[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("",
                                                                          "reportFormat"));
                                         elementList.add(localReportFormat[i]);
                                    } else {
                                        
                                                // nothing to do
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("reportFormat cannot be null!!");
                                    
                             }

                        } if (localReportLangTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "reportLang"));
                            
                            
                                    if (localReportLang==null){
                                         throw new org.apache.axis2.databinding.ADBException("reportLang cannot be null!!");
                                    }
                                    elementList.add(localReportLang);
                                } if (localReportTriggerTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "reportTrigger"));
                            
                            
                                    if (localReportTrigger==null){
                                         throw new org.apache.axis2.databinding.ADBException("reportTrigger cannot be null!!");
                                    }
                                    elementList.add(localReportTrigger);
                                } if (localHtmlReportOptionsTracker){
                             if (localHtmlReportOptions!=null) {
                                 for (int i = 0;i < localHtmlReportOptions.length;i++){

                                    if (localHtmlReportOptions[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("",
                                                                          "htmlReportOptions"));
                                         elementList.add(localHtmlReportOptions[i]);
                                    } else {
                                        
                                                // nothing to do
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("htmlReportOptions cannot be null!!");
                                    
                             }

                        }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static ParameterType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            ParameterType object =
                new ParameterType();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"parameterType".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ParameterType)de.hbz_nrw.www.pdfaconverter.types.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                        java.util.ArrayList list5 = new java.util.ArrayList();
                    
                        java.util.ArrayList list8 = new java.util.ArrayList();
                    
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","quickProcessing").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setQuickProcessing(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","analyseOnly").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAnalyseOnly(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","returnOnlyValidPDFA").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setReturnOnlyValidPDFA(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","compliancyLevel").equals(reader.getName())){
                                
                                                object.setCompliancyLevel(de.hbz_nrw.www.pdfaconverter.types.CompliancyLevelType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","reportFormat").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list5.add(de.hbz_nrw.www.pdfaconverter.types.ReportFormatType.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone5 = false;
                                                        while(!loopDone5){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone5 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("","reportFormat").equals(reader.getName())){
                                                                    list5.add(de.hbz_nrw.www.pdfaconverter.types.ReportFormatType.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone5 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setReportFormat((de.hbz_nrw.www.pdfaconverter.types.ReportFormatType[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                de.hbz_nrw.www.pdfaconverter.types.ReportFormatType.class,
                                                                list5));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","reportLang").equals(reader.getName())){
                                
                                                object.setReportLang(de.hbz_nrw.www.pdfaconverter.types.ReportLangType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","reportTrigger").equals(reader.getName())){
                                
                                                object.setReportTrigger(de.hbz_nrw.www.pdfaconverter.types.ReportTriggerType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","htmlReportOptions").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list8.add(de.hbz_nrw.www.pdfaconverter.types.HtmlOptionType.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone8 = false;
                                                        while(!loopDone8){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone8 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("","htmlReportOptions").equals(reader.getName())){
                                                                    list8.add(de.hbz_nrw.www.pdfaconverter.types.HtmlOptionType.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone8 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setHtmlReportOptions((de.hbz_nrw.www.pdfaconverter.types.HtmlOptionType[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                de.hbz_nrw.www.pdfaconverter.types.HtmlOptionType.class,
                                                                list8));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                  
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          