package at.kleinknes.BookServiceClient;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class BookToXML {
  public static void main(String[] args) throws Exception {

    Book person = new Book("Bla", new Date());

    JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
    Marshaller marshaller = jaxbContext.createMarshaller();

    marshaller.setProperty(Marshaller.JAXB_ENCODING, "ISO-8859-1");
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    marshaller.marshal(person, System.out);
    marshaller.marshal(person, new File("xml/person.xml"));
  }
}
