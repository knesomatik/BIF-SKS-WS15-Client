package at.kleinknes.BookServiceClient;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XMLtoBook {
	public static void main(String[] args) throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		// the simple way
		// Person person = (Person) unmarshaller.unmarshal(new File("person.xml"));

		// the elegant way
		Source source = new StreamSource(new File("books.xml"));
		JAXBElement<Book> jaxbElement = unmarshaller.unmarshal(source, Book.class);
		Book book = jaxbElement.getValue();

		System.out.println(book);
	}
}
