package at.kleinknes.BookServiceClient.Authors;

import at.kleinknes.BookServiceClient.CliCommand;
import io.airlift.airline.Arguments;
import io.airlift.airline.Command;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by fekle on 03/12/15.
 */
@Command(name = "add", description = "add author")
public class AuthorsAdd extends CliCommand {
	@Arguments(description = "name")
	public List<String> authorName;

	@Override
	public void run() {

		if (authorName.size() != 2) {
			System.err.println("invalid name format. <firstname> <lastname>");
			return;
		}

		String firstName = authorName.get(0);
		String lastName = authorName.get(1);

		if (firstName == null || lastName == null) {
			System.err.println("invalid name");
			return;
		}

		Form form = new Form();
		form.param("firstname", firstName);
		form.param("lastname", lastName);

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:9991").path("rest/author");


		Object resp =
				target.request(MediaType.APPLICATION_JSON_TYPE)
						.put(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE),
								Object.class);


		System.err.println(resp);
	}
}
