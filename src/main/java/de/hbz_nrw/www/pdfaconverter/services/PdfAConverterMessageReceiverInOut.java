
/**
 * PdfAConverterMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */
        package de.hbz_nrw.www.pdfaconverter.services;

        /**
        *  PdfAConverterMessageReceiverInOut message receiver
        */

        public class PdfAConverterMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        PdfAConverterSkeletonInterface skel = (PdfAConverterSkeletonInterface)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJava(op.getName().getLocalPart())) != null)){

        

            if("convertFromUrl".equals(methodName)){
                
                de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrlResponse convertFromUrlResponse1 = null;
	                        de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl wrappedParam =
                                                             (de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               convertFromUrlResponse1 =
                                                   
                                                   
                                                         skel.convertFromUrl(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), convertFromUrlResponse1, false);
                                    } else 

            if("convertFromAttachment".equals(methodName)){
                
                de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachmentResponse convertFromAttachmentResponse3 = null;
	                        de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment wrappedParam =
                                                             (de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               convertFromAttachmentResponse3 =
                                                   
                                                   
                                                         skel.convertFromAttachment(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), convertFromAttachmentResponse3, false);
                                    } else 

            if("convertFromStream".equals(methodName)){
                
                de.hbz_nrw.www.pdfaconverter.types.ConvertFromStreamResponse convertFromStreamResponse5 = null;
	                        de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream wrappedParam =
                                                             (de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               convertFromStreamResponse5 =
                                                   
                                                   
                                                         skel.convertFromStream(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), convertFromStreamResponse5, false);
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        } catch (ConvertFromUrl_faultMsg e) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME,"convertFromUrl_fault");
            org.apache.axis2.AxisFault f = createAxisFault(e);
            if (e.getFaultMessage() != null){
                f.setDetail(toOM(e.getFaultMessage(),false));
            }
            throw f;
            }
         catch (ConvertFromStream_faultMsg e) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME,"convertFromStream_fault");
            org.apache.axis2.AxisFault f = createAxisFault(e);
            if (e.getFaultMessage() != null){
                f.setDetail(toOM(e.getFaultMessage(),false));
            }
            throw f;
            }
         catch (ConvertFromAttachment_faultMsg e) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME,"convertFromAttachment_fault");
            org.apache.axis2.AxisFault f = createAxisFault(e);
            if (e.getFaultMessage() != null){
                f.setDetail(toOM(e.getFaultMessage(),false));
            }
            throw f;
            }
        
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
            private  org.apache.axiom.om.OMElement  toOM(de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrlResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrlResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl_fault param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl_fault.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachmentResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachmentResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment_fault param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment_fault.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(de.hbz_nrw.www.pdfaconverter.types.ConvertFromStreamResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(de.hbz_nrw.www.pdfaconverter.types.ConvertFromStreamResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream_fault param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream_fault.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrlResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrlResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrlResponse wrapconvertFromUrl(){
                                de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrlResponse wrappedElement = new de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrlResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachmentResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachmentResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachmentResponse wrapconvertFromAttachment(){
                                de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachmentResponse wrappedElement = new de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachmentResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, de.hbz_nrw.www.pdfaconverter.types.ConvertFromStreamResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(de.hbz_nrw.www.pdfaconverter.types.ConvertFromStreamResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private de.hbz_nrw.www.pdfaconverter.types.ConvertFromStreamResponse wrapconvertFromStream(){
                                de.hbz_nrw.www.pdfaconverter.types.ConvertFromStreamResponse wrappedElement = new de.hbz_nrw.www.pdfaconverter.types.ConvertFromStreamResponse();
                                return wrappedElement;
                         }
                    


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl.class.equals(type)){
                
                           return de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrlResponse.class.equals(type)){
                
                           return de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrlResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl_fault.class.equals(type)){
                
                           return de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl_fault.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment.class.equals(type)){
                
                           return de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachmentResponse.class.equals(type)){
                
                           return de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachmentResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment_fault.class.equals(type)){
                
                           return de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment_fault.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream.class.equals(type)){
                
                           return de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (de.hbz_nrw.www.pdfaconverter.types.ConvertFromStreamResponse.class.equals(type)){
                
                           return de.hbz_nrw.www.pdfaconverter.types.ConvertFromStreamResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream_fault.class.equals(type)){
                
                           return de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream_fault.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    

        /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
        private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    