package at.kleinknes.BookServiceClient.Publishers;

import at.kleinknes.BookServiceClient.CliCommand;
import at.kleinknes.bookservicewebapp.Publisher;
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
@Command(name = "add", description = "add publisher")
public class PublishersAdd extends CliCommand {
	@Arguments(description = "name")
	public List<String> pubName;

	@Override
	public void run() {

		if (pubName.size() != 3) {
			System.err.println("invalid name format. <name>");
			return;
		}

		String publishername = pubName.get(0);
		Long postcode = Long.valueOf(pubName.get(1));
		String contrycode = pubName.get(2);

		if (publishername == null) {
			System.err.println("invalid name");
			return;
		}

		Publisher newPub = new Publisher();
		newPub.setName(publishername);
		newPub.setCountrycode(contrycode);
		newPub.setPostcode(postcode);

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080").path("rest/publisher");


		Response resp =
				target.request(MediaType.APPLICATION_JSON_TYPE)
						.put(Entity.entity(newPub, MediaType.APPLICATION_JSON_TYPE),
								Response.class);


		if (resp.getStatus() == 200) {
			System.out.println("success");
		} else {
			System.out.println(resp.readEntity(String.class));
		}
	}
}
