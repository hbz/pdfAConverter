
/**
 * PdfAConverterStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */
        package de.hbz_nrw.www.pdfaconverter.services;

        

        /*
        *  PdfAConverterStub java implementation
        */

        
        public class PdfAConverterStub extends org.apache.axis2.client.Stub
        implements PdfAConverter{
        protected org.apache.axis2.description.AxisOperation[] _operations;

        //hashmaps to keep the fault mapping
        private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
        private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
        private java.util.HashMap faultMessageMap = new java.util.HashMap();

        private static int counter = 0;

        private static synchronized String getUniqueSuffix(){
            // reset the counter if it is greater than 99999
            if (counter > 99999){
                counter = 0;
            }
            counter = counter + 1; 
            return Long.toString(System.currentTimeMillis()) + "_" + counter;
        }

    
    private void populateAxisService() throws org.apache.axis2.AxisFault {

     //creating the Service with a unique name
     _service = new org.apache.axis2.description.AxisService("PdfAConverter" + getUniqueSuffix());
     addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[3];
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://www.hbz-nrw.de/PdfAConverter/services/", "convertFromUrl"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[0]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://www.hbz-nrw.de/PdfAConverter/services/", "convertFromAttachment"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[1]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://www.hbz-nrw.de/PdfAConverter/services/", "convertFromStream"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[2]=__operation;
            
        
        }

    //populates the faults
    private void populateFaults(){
         
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://www.hbz-nrw.de/PdfAConverter/types/","convertFromUrl_fault"),"de.hbz_nrw.www.pdfaconverter.services.ConvertFromUrl_faultMsg");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://www.hbz-nrw.de/PdfAConverter/types/","convertFromUrl_fault"),"de.hbz_nrw.www.pdfaconverter.services.ConvertFromUrl_faultMsg");
              faultMessageMap.put( new javax.xml.namespace.QName("http://www.hbz-nrw.de/PdfAConverter/types/","convertFromUrl_fault"),"de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl_fault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://www.hbz-nrw.de/PdfAConverter/types/","convertFromAttachment_fault"),"de.hbz_nrw.www.pdfaconverter.services.ConvertFromAttachment_faultMsg");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://www.hbz-nrw.de/PdfAConverter/types/","convertFromAttachment_fault"),"de.hbz_nrw.www.pdfaconverter.services.ConvertFromAttachment_faultMsg");
              faultMessageMap.put( new javax.xml.namespace.QName("http://www.hbz-nrw.de/PdfAConverter/types/","convertFromAttachment_fault"),"de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment_fault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://www.hbz-nrw.de/PdfAConverter/types/","convertFromStream_fault"),"de.hbz_nrw.www.pdfaconverter.services.ConvertFromStream_faultMsg");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://www.hbz-nrw.de/PdfAConverter/types/","convertFromStream_fault"),"de.hbz_nrw.www.pdfaconverter.services.ConvertFromStream_faultMsg");
              faultMessageMap.put( new javax.xml.namespace.QName("http://www.hbz-nrw.de/PdfAConverter/types/","convertFromStream_fault"),"de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream_fault");
           


    }

    /**
      *Constructor that takes in a configContext
      */

    public PdfAConverterStub(org.apache.axis2.context.ConfigurationContext configurationContext,
       java.lang.String targetEndpoint)
       throws org.apache.axis2.AxisFault {
         this(configurationContext,targetEndpoint,false);
   }


   /**
     * Constructor that takes in a configContext  and useseperate listner
     */
   public PdfAConverterStub(org.apache.axis2.context.ConfigurationContext configurationContext,
        java.lang.String targetEndpoint, boolean useSeparateListener)
        throws org.apache.axis2.AxisFault {
         //To populate AxisService
         populateAxisService();
         populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext,_service);
        
	
        configurationContext = _serviceClient.getServiceContext().getConfigurationContext();

        _serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(
                targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
        
    
    }

    /**
     * Default Constructor
     */
    public PdfAConverterStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {
        
                    this(configurationContext,"http://www.hbz-nrw.de/" );
                
    }

    /**
     * Default Constructor
     */
    public PdfAConverterStub() throws org.apache.axis2.AxisFault {
        
                    this("http://www.hbz-nrw.de/" );
                
    }

    /**
     * Constructor taking the target endpoint
     */
    public PdfAConverterStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null,targetEndpoint);
    }



        
                    /**
                     * Auto generated method signature
                     * Operation converts a PDF supplied by an URL to PDF/A. Operation returns 2 URLs: one for the PDF/A and one for the Report.
                     * @see de.hbz_nrw.www.pdfaconverter.services.PdfAConverter#convertFromUrl
                     * @param convertFromUrl6
                    
                     * @throws de.hbz_nrw.www.pdfaconverter.services.ConvertFromUrl_faultMsg : 
                     */

                    

                            public  de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrlResponse convertFromUrl(

                            de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl convertFromUrl6)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,de.hbz_nrw.www.pdfaconverter.services.ConvertFromUrl_faultMsg{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
              _operationClient.getOptions().setAction("http://www.hbz-nrw.de/PdfAConverter/services/convertFromUrl");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    convertFromUrl6,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.hbz-nrw.de/PdfAConverter/services/",
                                                    "convertFromUrl")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrlResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrlResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof de.hbz_nrw.www.pdfaconverter.services.ConvertFromUrl_faultMsg){
                          throw (de.hbz_nrw.www.pdfaconverter.services.ConvertFromUrl_faultMsg)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * Operation converts a PDF supplied by an URL to PDF/A. Operation returns 2 URLs: one for the PDF/A and one for the Report.
                * @see de.hbz_nrw.www.pdfaconverter.services.PdfAConverter#startconvertFromUrl
                    * @param convertFromUrl6
                
                */
                public  void startconvertFromUrl(

                 de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl convertFromUrl6,

                  final de.hbz_nrw.www.pdfaconverter.services.PdfAConverterCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
             _operationClient.getOptions().setAction("http://www.hbz-nrw.de/PdfAConverter/services/convertFromUrl");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    convertFromUrl6,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.hbz-nrw.de/PdfAConverter/services/",
                                                    "convertFromUrl")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrlResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultconvertFromUrl(
                                        (de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrlResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorconvertFromUrl(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof de.hbz_nrw.www.pdfaconverter.services.ConvertFromUrl_faultMsg){
														callback.receiveErrorconvertFromUrl((de.hbz_nrw.www.pdfaconverter.services.ConvertFromUrl_faultMsg)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorconvertFromUrl(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorconvertFromUrl(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorconvertFromUrl(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorconvertFromUrl(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorconvertFromUrl(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorconvertFromUrl(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorconvertFromUrl(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorconvertFromUrl(f);
                                            }
									    } else {
										    callback.receiveErrorconvertFromUrl(f);
									    }
									} else {
									    callback.receiveErrorconvertFromUrl(f);
									}
								} else {
								    callback.receiveErrorconvertFromUrl(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorconvertFromUrl(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[0].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[0].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * Operation uses SwA (Soap with Attachment) for supplying the PDF to the PDF/A Converter. Operation returns an Attachment with the PDF/A and an Attachment with the Record inside
                     * @see de.hbz_nrw.www.pdfaconverter.services.PdfAConverter#convertFromAttachment
                     * @param convertFromAttachment8
                    
                     * @throws de.hbz_nrw.www.pdfaconverter.services.ConvertFromAttachment_faultMsg : 
                     */

                    

                            public  de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachmentResponse convertFromAttachment(

                            de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment convertFromAttachment8)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,de.hbz_nrw.www.pdfaconverter.services.ConvertFromAttachment_faultMsg{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
              _operationClient.getOptions().setAction("http://www.hbz-nrw.de/PdfAConverter/services/convertFromAttachment");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    convertFromAttachment8,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.hbz-nrw.de/PdfAConverter/services/",
                                                    "convertFromAttachment")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachmentResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachmentResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof de.hbz_nrw.www.pdfaconverter.services.ConvertFromAttachment_faultMsg){
                          throw (de.hbz_nrw.www.pdfaconverter.services.ConvertFromAttachment_faultMsg)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * Operation uses SwA (Soap with Attachment) for supplying the PDF to the PDF/A Converter. Operation returns an Attachment with the PDF/A and an Attachment with the Record inside
                * @see de.hbz_nrw.www.pdfaconverter.services.PdfAConverter#startconvertFromAttachment
                    * @param convertFromAttachment8
                
                */
                public  void startconvertFromAttachment(

                 de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment convertFromAttachment8,

                  final de.hbz_nrw.www.pdfaconverter.services.PdfAConverterCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
             _operationClient.getOptions().setAction("http://www.hbz-nrw.de/PdfAConverter/services/convertFromAttachment");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    convertFromAttachment8,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.hbz-nrw.de/PdfAConverter/services/",
                                                    "convertFromAttachment")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachmentResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultconvertFromAttachment(
                                        (de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachmentResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorconvertFromAttachment(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof de.hbz_nrw.www.pdfaconverter.services.ConvertFromAttachment_faultMsg){
														callback.receiveErrorconvertFromAttachment((de.hbz_nrw.www.pdfaconverter.services.ConvertFromAttachment_faultMsg)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorconvertFromAttachment(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorconvertFromAttachment(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorconvertFromAttachment(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorconvertFromAttachment(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorconvertFromAttachment(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorconvertFromAttachment(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorconvertFromAttachment(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorconvertFromAttachment(f);
                                            }
									    } else {
										    callback.receiveErrorconvertFromAttachment(f);
									    }
									} else {
									    callback.receiveErrorconvertFromAttachment(f);
									}
								} else {
								    callback.receiveErrorconvertFromAttachment(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorconvertFromAttachment(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[1].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[1].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * Operation converts a PDF supplied within the SOAP Message as Byte-Stream to PDF/A. Operation returns one Bytestream for the PDF/A and one for the Report associated.
                     * @see de.hbz_nrw.www.pdfaconverter.services.PdfAConverter#convertFromStream
                     * @param convertFromStream10
                    
                     * @throws de.hbz_nrw.www.pdfaconverter.services.ConvertFromStream_faultMsg : 
                     */

                    

                            public  de.hbz_nrw.www.pdfaconverter.types.ConvertFromStreamResponse convertFromStream(

                            de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream convertFromStream10)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,de.hbz_nrw.www.pdfaconverter.services.ConvertFromStream_faultMsg{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
              _operationClient.getOptions().setAction("http://www.hbz-nrw.de/PdfAConverter/services/convertFromStream");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    convertFromStream10,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.hbz-nrw.de/PdfAConverter/services/",
                                                    "convertFromStream")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             de.hbz_nrw.www.pdfaconverter.types.ConvertFromStreamResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (de.hbz_nrw.www.pdfaconverter.types.ConvertFromStreamResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof de.hbz_nrw.www.pdfaconverter.services.ConvertFromStream_faultMsg){
                          throw (de.hbz_nrw.www.pdfaconverter.services.ConvertFromStream_faultMsg)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * Operation converts a PDF supplied within the SOAP Message as Byte-Stream to PDF/A. Operation returns one Bytestream for the PDF/A and one for the Report associated.
                * @see de.hbz_nrw.www.pdfaconverter.services.PdfAConverter#startconvertFromStream
                    * @param convertFromStream10
                
                */
                public  void startconvertFromStream(

                 de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream convertFromStream10,

                  final de.hbz_nrw.www.pdfaconverter.services.PdfAConverterCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
             _operationClient.getOptions().setAction("http://www.hbz-nrw.de/PdfAConverter/services/convertFromStream");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    convertFromStream10,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.hbz-nrw.de/PdfAConverter/services/",
                                                    "convertFromStream")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         de.hbz_nrw.www.pdfaconverter.types.ConvertFromStreamResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultconvertFromStream(
                                        (de.hbz_nrw.www.pdfaconverter.types.ConvertFromStreamResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorconvertFromStream(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof de.hbz_nrw.www.pdfaconverter.services.ConvertFromStream_faultMsg){
														callback.receiveErrorconvertFromStream((de.hbz_nrw.www.pdfaconverter.services.ConvertFromStream_faultMsg)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorconvertFromStream(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorconvertFromStream(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorconvertFromStream(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorconvertFromStream(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorconvertFromStream(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorconvertFromStream(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorconvertFromStream(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorconvertFromStream(f);
                                            }
									    } else {
										    callback.receiveErrorconvertFromStream(f);
									    }
									} else {
									    callback.receiveErrorconvertFromStream(f);
									}
								} else {
								    callback.receiveErrorconvertFromStream(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorconvertFromStream(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[2].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[2].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

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

    
    
    private javax.xml.namespace.QName[] opNameArray = null;
    private boolean optimizeContent(javax.xml.namespace.QName opName) {
        

        if (opNameArray == null) {
            return false;
        }
        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;   
            }
        }
        return false;
    }
     //http://www.hbz-nrw.de/
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
        
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(de.hbz_nrw.www.pdfaconverter.types.ConvertFromUrl.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(de.hbz_nrw.www.pdfaconverter.types.ConvertFromAttachment.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(de.hbz_nrw.www.pdfaconverter.types.ConvertFromStream.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             


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



    
   }
   