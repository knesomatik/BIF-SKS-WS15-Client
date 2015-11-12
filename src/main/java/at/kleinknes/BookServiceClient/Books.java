package at.kleinknes.BookServiceClient;

import javax.xml.bind.annotation.*;

import at.kleinknes.newBookClient.generated.*;

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