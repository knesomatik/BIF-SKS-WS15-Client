package at.kleinknes.BookServiceClient.Books;

import at.kleinknes.BookServiceClient.CliCommand;
import io.airlift.airline.Arguments;
import io.airlift.airline.Command;

/**
 * Created by fekle on 03/12/15.
 */
@Command(name = "delete", description = "delete books")
public class BooksDelete extends CliCommand {
	@Arguments(description = "book to delete")
	public String query;

	@Override
	public void run() {
		if (query == null) {
			return;
		}

		//BookServiceClient bs = new BookServiceClient();
		//bs.
	}

}
