package at.kleinknes.BookServiceClient.Books;

import at.kleinknes.BookServiceClient.BookServiceClient;
import at.kleinknes.BookServiceClient.CliCommand;
import io.airlift.airline.Arguments;
import io.airlift.airline.Command;
import io.airlift.airline.Option;

import java.util.List;

/**
 * Created by fekle on 03/12/15.
 */
@Command(name = "search", description = "search all books")
public class BooksSearch extends CliCommand
{
	@Arguments(description = "search query")
	public String query;

	@Override
	public void run(){
		if(query == null){
			return;
		}

		BookServiceClient bs = new BookServiceClient();
		bs.printSearch(query);
	}
}
