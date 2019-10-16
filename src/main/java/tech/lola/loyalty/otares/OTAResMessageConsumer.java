package tech.lola.loyalty.otares;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;

@Configuration
public class OTAResMessageConsumer {

	@Value("${otares.api.endpoint}")
	private String apiRoute;
			
	private static final Logger LOGGER = LoggerFactory.getLogger(OTAResMessageConsumer.class);

	@JmsListener(destination = "helloworld.q")
	public void customerUpdated(String message) {
		LOGGER.info("Message Received: " + message);
	}
}
