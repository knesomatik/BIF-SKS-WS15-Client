package at.kleinknes.BookServiceClient;

import io.airlift.airline.Option;
import io.airlift.airline.OptionType;

/**
 * Created by fekle on 03/12/15.
 */
public class CliCommand implements Runnable {
	@Option(type = OptionType.GLOBAL, name = "-v", description = "Verbose mode")
	public boolean verbose;

	public void run()
	{
		System.out.println(getClass().getSimpleName());
	}
}
