package at.kleinknes.BookServiceClient.Books;

import at.kleinknes.BookServiceClient.CliCommand;
import io.airlift.airline.Arguments;
import io.airlift.airline.Command;
import io.airlift.airline.Option;

import java.util.List;

/**
 * Created by fekle on 03/12/15.
 */
@Command(name = "delete", description = "Add file contents to the index")
public class BooksDelete extends CliCommand {
	@Arguments(description = "Patterns of files to be added")
	public List<String> patterns;

	@Option(name = "-i", description = "Add modified contents interactively.")
	public boolean interactive;
}
