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

import tech.lola.loyalty.otares.model.AddressDto;
import tech.lola.loyalty.otares.model.CustomerDto;

@Configuration
public class OTAResMessageConsumer {

	@Value("${otares.api.endpoint}")
	private String apiRoute;
			
	private static final Logger LOGGER = LoggerFactory.getLogger(OTAResMessageConsumer.class);

	@JmsListener(destination = "helloworld.q")
	public void customerUpdated(String message) {

		// String customerId = "29533087";
		String customerId = "1";
		
		// We have the customer id, get the customer
		String oatresCustomerEndoint = this.apiRoute + "/customers/" + customerId;
		LOGGER.info("oatresCustomerEndoint: " + oatresCustomerEndoint);
		
		// TODO catch 404
        RestTemplate restTemplate = new RestTemplate();
        CustomerDto customer = restTemplate.getForObject(oatresCustomerEndoint, CustomerDto.class);
        LOGGER.info(customer.toString());
        
        // If this customer doesn't have a loyalty it's not in the program.
        String loyaltyId = "010101010";
        
        // Does the use exist in Tally
        
        // Update it
        // Create it
	}
}
