package at.kleinknes.BookServiceClient.Publishers;

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
@Command(name = "add", description = "add publisher")
public class PublishersAdd extends CliCommand {
	@Arguments(description = "name")
	public List<String> pubName;

	@Override
	public void run() {

		if (pubName.size() != 1) {
			System.err.println("invalid name format. <name>");
			return;
		}

		String publishername = pubName.get(0);

		if (publishername == null) {
			System.err.println("invalid name");
			return;
		}

		Form form = new Form();
		form.param("name", publishername);
		form.param("postcode", "123");
		form.param("countrycode", "123");

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:9991").path("rest/publisher");


		Object resp =
				target.request(MediaType.APPLICATION_JSON_TYPE)
						.put(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE),
								Object.class);


		System.err.println(resp);
	}
}
