/*
package at.kleinknes.BookServiceClient;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Date;

public class BookToXML {
	public static void main(String[] args) throws Exception {

		Book buch = new Book("NeuesTollesBuch", new Date());

		Marshaller marshaller = JAXBContext.newInstance(Book.class).createMarshaller();

		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		marshaller.marshal(buch, System.out);
		marshaller.marshal(buch, new File("test.xml"));
	}
}
*/
