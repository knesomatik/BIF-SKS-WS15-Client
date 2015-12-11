package at.kleinknes.BookServiceClient;

import at.kleinknes.BookServiceClient.Authors.AuthorsAdd;
import at.kleinknes.BookServiceClient.Authors.AuthorsList;
import at.kleinknes.BookServiceClient.Books.BooksDelete;
import at.kleinknes.BookServiceClient.Books.BooksImport;
import at.kleinknes.BookServiceClient.Books.BooksList;
import at.kleinknes.BookServiceClient.Books.BooksSearch;
import at.kleinknes.BookServiceClient.Publishers.PublishersAdd;
import io.airlift.airline.Cli;
import io.airlift.airline.Help;

/**
 * Created by fekle on 05/11/15.
 */
public class App {


	public static void main(String[] args) {
		Cli.CliBuilder<Runnable> builder = Cli.<Runnable>builder("bif-sks-ws15-client")
				.withDescription("bif")
				.withDefaultCommand(Help.class)
				.withCommands(Help.class);

		builder.withGroup("authors")
				.withDescription("manage authors")
				.withDefaultCommand(AuthorsAdd.class)
				.withCommands(AuthorsAdd.class, AuthorsList.class);

		builder.withGroup("publishers")
				.withDescription("manage publishers")
				.withDefaultCommand(PublishersAdd.class)
				.withCommands(PublishersAdd.class);

		builder.withGroup("books")
				.withDescription("manage books")
				.withDefaultCommand(BooksList.class)
				.withCommands(BooksList.class, BooksSearch.class, BooksImport.class, BooksDelete.class);

		Cli<Runnable> gitParser = builder.build();

		gitParser.parse(args).run();

	}
}
