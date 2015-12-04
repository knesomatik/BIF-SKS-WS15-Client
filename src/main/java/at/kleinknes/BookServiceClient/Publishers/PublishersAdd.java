package at.kleinknes.BookServiceClient.Publishers;

import at.kleinknes.BookServiceClient.CliCommand;
import at.kleinknes.bookservicewebapp.Author;
import at.kleinknes.bookservicewebapp.Publisher;
import io.airlift.airline.Arguments;
import io.airlift.airline.Command;

import javax.ws.rs.client.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by fekle on 03/12/15.
 */
@Command(name = "add", description = "add author")
public class PublishersAdd extends CliCommand {
	@Arguments(description = "name")
	public List<String> publisherData;

	@Override
	public void run() {

		if(publisherData.size() != 1){
			System.err.println("invalid publisher data. <name>");
			return;
		}


		String name = publisherData.get(0);

		if (name == null ){
			System.err.println("invalid name");
			return;
		}

		Publisher newPublisher = new Publisher();
		newPublisher.setName(name);


		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:9991").path("/rest/publisher");
		Invocation.Builder builder = target.request("application/json");
		Entity<Publisher>  request = Entity.entity(newPublisher, "application/json");

		Response resp = builder.post(request);

		System.err.println("success");
	}
}
