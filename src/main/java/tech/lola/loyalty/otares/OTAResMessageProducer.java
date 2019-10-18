package tech.lola.loyalty.otares;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class OTAResMessageProducer {

	  private static final Logger LOGGER =
	      LoggerFactory.getLogger(OTAResMessageProducer.class);

	  @Autowired
	  private JmsTemplate jmsTemplate;

	  public void send(String message) {
	    LOGGER.info("sending message='{}'", message);
	    jmsTemplate.convertAndSend("ActiveMQ.Advisory.Topic", message);
	  }
}
