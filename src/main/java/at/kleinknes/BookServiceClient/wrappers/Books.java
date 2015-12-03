package at.kleinknes.BookServiceClient.wrappers;

import at.kleinknes.bookservicewebapp.Book;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fekle on 03/12/15.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Books {
	List<Book> book = new ArrayList<Book>();

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}
}
