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
	
	public OTAResMessageConsumer() {
	    LOGGER.info("Started");
	}

    @JmsListener(destination = "VirtualTopic.events.ota.customers")
    public void customerUpdated1(String message) {
        LOGGER.info("Message Received: " + message);
    }

    @JmsListener(destination = "events.ota.customers")
    public void customerUpdated2(String message) {
        LOGGER.info("Message Received: " + message);
    }

    @JmsListener(destination = "VirtualTopic.events.ota.customers.events.ota.customers")
    public void customerUpdated3(String message) {
        LOGGER.info("Message Received: " + message);
    }
    
}
