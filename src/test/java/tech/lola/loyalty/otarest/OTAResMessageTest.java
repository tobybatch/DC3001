package tech.lola.loyalty.otarest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tech.lola.loyalty.otares.OTAResMessageConsumer;
import tech.lola.loyalty.otares.OTAResMessageProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OTAResMessageTest {
	  @Autowired
	  private OTAResMessageProducer producer;

	  @Autowired
	  private OTAResMessageConsumer consumer;

	  @Test
	  public void testReceive() throws Exception {
		  producer.send("Hello Spring JMS ActiveMQ!");
		  
	  }
}
