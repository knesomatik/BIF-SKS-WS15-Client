package at.kleinknes.BookServiceClient;

import at.kleinknes.bookservicewebapp.GetAllBooks;

/**
 * Created by fekle on 05/11/15.
 */
public class App {
	public static void main(String[] args) {
		System.out.println("hello world");
		try {
			BookToXML.main(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
