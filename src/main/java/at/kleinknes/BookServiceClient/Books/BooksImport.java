package at.kleinknes.BookServiceClient.Books;


import at.kleinknes.BookServiceClient.BookServiceClient;
import at.kleinknes.BookServiceClient.CliCommand;
import io.airlift.airline.Arguments;
import io.airlift.airline.Command;

@Command(name = "import", description = "import books from XML file")
public class BooksImport extends CliCommand {
	@Arguments(description = "file name")
	public String file;

	@Override
	public void run() {
		if (file == null) {
			return;
		}

		BookServiceClient bs = new BookServiceClient();
		bs.importBooks(file);
	}
}
