package at.kleinknes.BookServiceClient;

import at.kleinknes.BookServiceClient.wrappers.Books;
import at.kleinknes.bookservicewebapp.*;
import dnl.utils.text.table.TextTable;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.util.List;
import java.util.Objects;

public class BookClient {

	private BookWebService bs = new BookWebService();
	private BookWS port = bs.getBookWebServicePort();

	public BookClient() {
	}

	public List<Book> listAll() {
		return port.getAllBooks();
	}

	public void printAll() {
		System.out.println("listing all books...");
		printBookList(listAll());
	}

	private void printBookList(List<Book> list) {

		list.forEach(System.out::println);

		System.out.println();
		System.out.println("results:");

		if (list.size() <= 0) {
			System.out.println("no data found.");
			return;
		}

		String[] columnNames = {"Isbn", "Title", "Subtitle", "Description", "Pages", "Language", "Authors"};
		String[][] printBooks = new String[list.size()][7];

		int i = 0;

		for (Book b : list) {
			printBooks[i][0] = b.getIsbn();
			printBooks[i][1] = b.getTitle();
			printBooks[i][2] = b.getSubtitle();
			printBooks[i][3] = b.getDescription();
			Long c = (long) b.getPages();
			printBooks[i][4] = c.toString();
			printBooks[i][5] = b.getLanguage();

			String authors = "";

			for (Author a : b.getAuthors().getAuthor()) {
				authors += a.getFirstname() + " " + a.getLastname() + " ";
			}

			printBooks[i][6] = authors;
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

	public void importBooks(String path) {

		List<Book> books;

		try {
			JAXBContext jax = JAXBContext.newInstance(Books.class);
			Unmarshaller unMarsh = jax.createUnmarshaller();
			Source newSource = new StreamSource(new File(path));
			JAXBElement<Books> jaxEl = unMarsh.unmarshal(newSource, Books.class);


			books = jaxEl.getValue().getBook();

		} catch (Exception e) {
			System.err.println("Error by parsing XML File: " + e.getMessage());
			return;
		}

		try {
			System.out.println(books.get(0).getAuthors().getAuthor().get(0).getFirstname());
			System.out.println(port.saveBooks(books));

		} catch (Exception e) {
			System.err.println("Error importing books: " + e.getMessage());
		}


	}

}
