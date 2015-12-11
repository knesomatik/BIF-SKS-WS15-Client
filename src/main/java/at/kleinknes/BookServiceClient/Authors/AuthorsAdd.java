package at.kleinknes.BookServiceClient.Authors;

import at.kleinknes.BookServiceClient.CliCommand;
import at.kleinknes.bookservicewebapp.Author;
import io.airlift.airline.Arguments;
import io.airlift.airline.Command;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;

import javax.ws.rs.client.*;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedHashMap;
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

		Form form = new Form();
		form.param("firstname", firstName);
		form.param("lastname", lastName);

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:9991").path("rest/author");


		Object resp =
				target.request(MediaType.APPLICATION_JSON_TYPE)
						.put(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE),
								Object.class);


		System.err.println(resp);
	}
}
