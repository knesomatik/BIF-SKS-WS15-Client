package at.kleinknes.BookServiceClient.Books;


		import at.kleinknes.BookServiceClient.BookClient;
		import at.kleinknes.BookServiceClient.CliCommand;
		import io.airlift.airline.Arguments;
		import io.airlift.airline.Command;

@Command(name = "import", description = "import books from XML file")
public class BooksImport extends CliCommand {
	@Arguments(description = "file authorName")
	public String file;

	@Override
	public void run() {
		if (file == null) {
			return;
		}

		BookClient bs = new BookClient();
		bs.importBooks(file);
	}
}
