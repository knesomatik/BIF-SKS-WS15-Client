
package at.kleinknes.newBookClient.generated;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "BookWebService", targetNamespace = "http://BookServiceWebApp.kleinknes.at/", wsdlLocation = "http://localhost:8080/BookWS?wsdl")
public class BookWebService
    extends Service
{

    private final static URL BOOKWEBSERVICE_WSDL_LOCATION;
    private final static WebServiceException BOOKWEBSERVICE_EXCEPTION;
    private final static QName BOOKWEBSERVICE_QNAME = new QName("http://BookServiceWebApp.kleinknes.at/", "BookWebService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/BookWS?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BOOKWEBSERVICE_WSDL_LOCATION = url;
        BOOKWEBSERVICE_EXCEPTION = e;
    }

    public BookWebService() {
        super(__getWsdlLocation(), BOOKWEBSERVICE_QNAME);
    }

    public BookWebService(WebServiceFeature... features) {
        super(__getWsdlLocation(), BOOKWEBSERVICE_QNAME, features);
    }

    public BookWebService(URL wsdlLocation) {
        super(wsdlLocation, BOOKWEBSERVICE_QNAME);
    }

    public BookWebService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BOOKWEBSERVICE_QNAME, features);
    }

    public BookWebService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BookWebService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns BookWS
     */
    @WebEndpoint(name = "BookWebServicePort")
    public BookWS getBookWebServicePort() {
        return super.getPort(new QName("http://BookServiceWebApp.kleinknes.at/", "BookWebServicePort"), BookWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BookWS
     */
    @WebEndpoint(name = "BookWebServicePort")
    public BookWS getBookWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://BookServiceWebApp.kleinknes.at/", "BookWebServicePort"), BookWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BOOKWEBSERVICE_EXCEPTION!= null) {
            throw BOOKWEBSERVICE_EXCEPTION;
        }
        return BOOKWEBSERVICE_WSDL_LOCATION;
    }

}