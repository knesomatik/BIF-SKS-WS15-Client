package at.kleinknes.BookServiceClient.Authors;

import at.kleinknes.BookServiceClient.CliCommand;
import at.kleinknes.bookservicewebapp.Author;
import io.airlift.airline.Arguments;
import io.airlift.airline.Command;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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

		if (authorName.size() != 3) {
			System.err.println("invalid name format. <firstname> <lastname>");
			return;
		}

		String firstName = authorName.get(0);
		String lastName = authorName.get(1);
		String birthdate = authorName.get(2);

		if (firstName == null || lastName == null) {
			System.err.println("invalid name");
			return;
		}

		Author newAuthor = new Author();

		newAuthor.setFirstname(firstName);
		newAuthor.setLastname(lastName);
		newAuthor.setBirthdate(birthdate);

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080").path("rest/author");


		Response resp =
				target.request(MediaType.APPLICATION_JSON_TYPE)
						.put(Entity.entity(newAuthor, MediaType.APPLICATION_JSON_TYPE),
								Response.class);


		if (resp.getStatus() == 200) {
			System.out.println("Success");
		} else {
			System.out.println(resp.readEntity(String.class));
		}
	}
}
