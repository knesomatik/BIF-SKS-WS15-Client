 package at.kleinknes.BookServiceClient;

import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;

import knesklein.newBookClient.generated.Book;

import java.io.File;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "books")
public class Books{
	private List<Book> book;
	
	public List<Book> getBooks(){
		return book;
	}
	
	public void setBook(List<Book> books){
		book = books;
	}
}
/*
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
