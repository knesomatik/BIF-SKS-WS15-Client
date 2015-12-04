package at.kleinknes.BookServiceClient.Books;

import at.kleinknes.BookServiceClient.BookClient;
import at.kleinknes.BookServiceClient.CliCommand;
import io.airlift.airline.Arguments;
import io.airlift.airline.Command;

/**
 * Created by fekle on 03/12/15.
 */
@Command(name = "search", description = "search all books")
public class BooksSearch extends CliCommand {
	@Arguments(description = "search query")
	public String query;

	@Override
	public void run() {
		if (query == null) {
			return;
		}

		BookClient bs = new BookClient();
		bs.printSearch(query);
	}
}
