package at.kleinknes.BookServiceClient.Authors;

import at.kleinknes.BookServiceClient.CliCommand;
import dnl.utils.text.table.TextTable;
import io.airlift.airline.Command;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by fekle on 03/12/15.
 */
@Command(name = "list", description = "list all authors")
public class AuthorsList extends CliCommand {

	@Override
	public void run() {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:9991").path("rest/author");

		ArrayList<LinkedHashMap> resp =
				target.request(MediaType.APPLICATION_JSON_TYPE).get(ArrayList.class);

		printAuthor(resp);

	}


	private void printAuthor(List<LinkedHashMap> list) {

		System.out.println();
		System.out.println("results:");

		if (list.size() <= 0) {
			System.out.println("no data found.");
			return;
		}

		String[] columnNames = {"ID", "First Name", "Last Name"};
		String[][] printBooks = new String[list.size()][3];

		int i = 0;

		for (LinkedHashMap b : list) {

			Object _authID = b.get("authID");
			Object _firstname = b.get("firstname");
			Object _lastname = b.get("lastname");

			String authID = "";
			String firstname = "";
			String lastname = "";

			if (_authID != null) {
				authID = _authID.toString();
			}

			if (_firstname != null) {
				firstname = _firstname.toString();
			}

			if (_lastname != null) {
				lastname = _lastname.toString();
			}


			printBooks[i][0] = authID;
			printBooks[i][1] = firstname;
			printBooks[i][2] = lastname;
			++i;
		}

		TextTable tt = new TextTable(columnNames, printBooks);
		tt.printTable(System.out, 0);
	}
}
