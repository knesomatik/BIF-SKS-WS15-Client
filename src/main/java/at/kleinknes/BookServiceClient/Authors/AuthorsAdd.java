package at.kleinknes.BookServiceClient.Authors;

import at.kleinknes.BookServiceClient.CliCommand;
import at.kleinknes.bookservicewebapp.Author;
import io.airlift.airline.Arguments;
import io.airlift.airline.Command;

import javax.ws.rs.client.*;
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

		if(authorName.size() != 2){
			System.err.println("invalid name format. <firstname> <lastname>");
			return;
		}

		String firstName = authorName.get(0);
		String lastName = authorName.get(1);

		if (firstName == null || lastName == null) {
			System.err.println("invalid name");
			return;
		}

		Author newAuthor = new Author();
		newAuthor.setFirstname(firstName);
		newAuthor.setLastname(lastName);


		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:9991").path("rest/author");
		Invocation.Builder builder = target.request("application/json");
		Entity<Author>  request = Entity.entity(newAuthor, "application/json");

		Response resp = builder.put(request);

		Author ret = (Author) resp.getEntity();

		System.err.println(resp.getStatus());
	}
}
