package at.kleinknes.BookServiceClient;

import at.kleinknes.BookServiceClient.Books.BooksDelete;
import at.kleinknes.BookServiceClient.Books.BooksImport;
import at.kleinknes.BookServiceClient.Books.BooksList;
import at.kleinknes.BookServiceClient.Books.BooksSearch;
import io.airlift.airline.Cli;
import io.airlift.airline.Help;

/**
 * Created by fekle on 05/11/15.
 */
public class App {

	// self-explanatory
	private static void printUsageAndQuit() {
		System.out.println("usage: bookserviceclient [import|listAll|search] {args}");
		System.exit(1);
	}

	public static void main(String[] args) {
		Cli.CliBuilder<Runnable> builder = Cli.<Runnable>builder("bif-sks-ws15-client")
				.withDescription("bif")
				.withDefaultCommand(Help.class)
				.withCommands(Help.class);

	/*	builder.withGroup("authors")
				.withDescription("manage authors")
				.withDefaultCommand(Help.class)
				.withCommands(Help.class, AuthorsAdd.class);

		builder.withGroup("publishers")
				.withDescription("manage publishers")
				.withDefaultCommand(Help.class)
				.withCommands(Help.class, PublisherAdd.class);*/

		builder.withGroup("books")
				.withDescription("manage books")
				.withDefaultCommand(BooksList.class)
				.withCommands(BooksList.class, BooksSearch.class, BooksImport.class, BooksDelete.class);

		Cli<Runnable> gitParser = builder.build();

		gitParser.parse(args).run();

	}
}
