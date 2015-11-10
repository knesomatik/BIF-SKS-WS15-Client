package at.kleinknes.BookServiceClient;

import knesklein.newBookClient.generated.*;
import dnl.utils.text.table.TextTable;

import java.io.File;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

public class BookServiceClient {

	private BookWebService bs = new BookWebService();
	private BookWS port = bs.getBookWebServicePort();
	
	public BookServiceClient() {
	}

	public List<Book> listAll() {
		return port.getAllBooks();
	}

	public void printAll() {
		System.out.println("listing all books...");
		printBookList(listAll());
	}

	private void printBookList(List<Book> list) {

		System.out.println();
		System.out.println("results:");

		if (list.size() <= 0) {
			System.out.println("no data found.");
			return;
		}

		String[] columnNames = {"Isbn", "Title", "Pages"};
		String[][] printBooks = new String[list.size()][3];

		int i = 0;

		for (Book b : list) {
			printBooks[i][0] = b.getIsbn();
			printBooks[i][1] = b.getTitle();
			++i;
		}

		TextTable tt = new TextTable(columnNames, printBooks);
		tt.printTable(System.out, 0);
	}

	public void printSearch(String arg) {
		System.out.println("searching for \"" + arg + "\"…");
		if (arg == null || Objects.equals(arg, "")) {
			System.err.println("invalid search term");
			return;
		}
		printBookList(search(arg));
	}

	public List<Book> search(String arg) {
		return port.searchBooks(arg);
	}
	
	public void importBooks(String path){
		JAXBContext jax = null;
		Unmarshaller unMarsh = null;
		try{
			jax = JAXBContext.newInstance(Books.class);
			unMarsh = jax.createUnmarshaller();
		}catch(JAXBException e){
			
		}
		
		Source newSource = new StreamSource(new File(path));
		JAXBElement<Books> jaxEl = null;
		try{
			jaxEl = unMarsh.unmarshal(newSource, Books.class);
		}catch(JAXBException e){
			System.err.println("Error by parsing XML File: "+e.getMessage());
		}
		
		Books book = jaxEl.getValue();
		
		List<Book> bookList = book.getBooks();
		
		System.out.println(book);
		
		for(Book b : bookList){
			System.out.println(b.getTitle());
		}
		
		System.out.print(port.saveBooks(bookList));
		
	}
}
