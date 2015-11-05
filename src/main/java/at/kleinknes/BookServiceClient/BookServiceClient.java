package at.kleinknes.BookServiceClient;

import at.kleinknes.bookservicewebapp.*;
import dnl.utils.text.table.TextTable;

import java.util.List;
import java.util.Objects;

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
		printBookList(list);
	}

	private void printBookList(List<Book> list){

		String[] columnNames = new String[3];
		columnNames[0] = "     ID     ";
		columnNames[1] = "     Title     ";
		columnNames[2] = "     Date     ";

		String[][] test = new String[list.size()][3];

		int i = 0;

		for(Book b : list){
			test[i][0] = b.getID().toString();
			test[i][1] = b.getTitle();
			if(b.getDate() != null){
				test[i][2] = b.getDate().toString();
			}else{
				test[i][2] = "null";
			}
			i++;
		}

		TextTable tt = new TextTable(columnNames, test);
		tt.printTable(System.out, 2);

		System.out.println();
	}

	public void printSearch(String arg){
		if(arg == null || Objects.equals(arg, "")){
			System.err.println("invalid search term");
			return;
		}
		List<Book> list = search(arg);
		printBookList(list);
	}

	public List<Book> search(String arg){
		return port.searchBooks(arg);
	}
}
