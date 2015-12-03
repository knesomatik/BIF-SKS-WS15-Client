package BookServiceClient;

import newBookClient.generated.*;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class TestClient1 {
	public static void main(String[] args) throws Exception {

		URL wsdl = new URL("http://localhost:8080/BookWS?wsdl");
		QName serviceName = new QName("http://BookServiceWebApp.kleinknes.at/", "BookWebService");

		Service service = Service.create(wsdl, serviceName);
		BookWS port = service.getPort(BookWS.class);

		port.getAllBooks().forEach(System.out::println);
	}
}
