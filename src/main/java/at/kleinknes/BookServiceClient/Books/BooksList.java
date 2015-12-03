package at.kleinknes.BookServiceClient.Books;

import at.kleinknes.BookServiceClient.BookServiceClient;
import at.kleinknes.BookServiceClient.CliCommand;
import io.airlift.airline.Command;

/**
 * Created by fekle on 03/12/15.
 */
@Command(name = "list", description = "list all books")
public class BooksList extends CliCommand {
	@Override
	public void run() {
		BookServiceClient bs = new BookServiceClient();
		bs.printAll();
	}
}
