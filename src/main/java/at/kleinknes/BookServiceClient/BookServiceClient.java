package at.kleinknes.BookServiceClient;

import at.kleinknes.bookservicewebapp.*;
import dnl.utils.text.table.TextTable;

import java.util.List;
import java.util.Objects;

public class BookServiceClient {

	private final BookWebService bs = new BookWebService();
	private final BookWS port = bs.getBookWSPort();

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

		if(list.size() <= 0){
			System.out.println("no data found.");
			return;
		}

		String[] columnNames = {"ID", "Title", "Date"};
		String[][] printBooks = new String[list.size()][3];

		int i = 0;

		for (Book b : list) {
			printBooks[i][0] = b.getID().toString();
			printBooks[i][1] = b.getTitle();
			printBooks[i][2] = b.getDate() != null ? b.getDate().toString() : "no date specified";
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
}
