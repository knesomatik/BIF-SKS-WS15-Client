package at.kleinknes.BookServiceClient;

import at.kleinknes.bookservicewebapp.*;

import java.util.List;

public class BookServiceClient {

	private BookWebService bs = new BookWebService();
	private BookWS port = bs.getBookWSPort();

	public BookServiceClient(){

	}

	public List<Book> listAll(){
		return port.getAllBooks();
	}

	public void printAll(){
		List<Book> list = listAll();
		System.out.format("%8s%32s%32s\r\n\r\n", "ID", "Title", "Date");

		for (Book b : list){
			if(b.getDate() != null) {
				System.out.format("%8d%32s%32s\r\n", b.getID(), b.getTitle(), b.getDate().toString());
			}else{
				System.out.format("%8d%32s%32s\r\n", b.getID(), b.getTitle(), "no date specified");
			}
		}
	}
}
