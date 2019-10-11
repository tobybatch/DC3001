package tech.lola.loyalty.otares;

import org.slf4j.Logger;
import org.springframework.web.client.RestTemplate;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;

import tech.lola.loyalty.otares.model.Address;
import tech.lola.loyalty.otares.model.Customer;

@Configuration
public class OTAResMessageConsumer {

	@Value("${otares.api.endpoint}")
	private String apiRoute;
			
	private static final Logger LOGGER = LoggerFactory.getLogger(OTAResMessageConsumer.class);

	@JmsListener(destination = "helloworld.q")
	public void customerUpdated(String message) {
		
		String customerId = "29533087";
		
		// We have the customer id, get the customer
		String oatresCustomerEndoint = this.apiRoute + "/customers/" + customerId;
		
        RestTemplate restTemplate = new RestTemplate();
        Customer customer = restTemplate.getForObject(oatresCustomerEndoint, Customer.class);
        LOGGER.error(customer.toString());
        

	}
}
