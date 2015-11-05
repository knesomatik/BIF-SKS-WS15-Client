package at.kleinknes.BookServiceClient;

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
		System.out.println();
		System.out.println("=== BookServiceClient ===");
		System.out.println();

		// check args
		if (args.length > 0) {
			BookServiceClient client = new BookServiceClient();

			switch (args[0]) {
				case "import":
					break;
				case "listall":
				case "listAll":
					client.printAll();
					break;
				case "search":
					if (args.length != 2) {
						printUsageAndQuit();
					}
					client.printSearch(args[1]);
					break;
				default:
					printUsageAndQuit();
			}
		} else {
			printUsageAndQuit();
		}

		System.out.println();
		System.out.println("…");
		System.out.println();
	}
}
