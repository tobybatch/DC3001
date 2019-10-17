package tech.lola.loyalty.otares.service;

import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.springframework.web.client.RestTemplate;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;


import tech.lola.loyalty.otares.OTAResMessageConsumer;
import tech.lola.loyalty.otares.model.AddressDto;
import tech.lola.loyalty.otares.model.CustomerDto;
import tech.lola.loyalty.tally.model.ExternalUpdateMemberProfileRequest;

@Configuration
@Service
public class CustomerService {

	@Value("${otares.api.endpoint}")
	private String apiRoute;
	
	@Autowired
	RestTemplate restTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

	public CustomerDto getCustomer(String id) {
		// We have the customer id, get the customer
		String customerEndoint = this.getCustomerRoute(id);
		LOGGER.info("Looking up: " + id);

		// TODO catch 404
		CustomerDto customer = restTemplate.getForObject(customerEndoint, CustomerDto.class);
		LOGGER.info("Customer found: " + id);
		return customer;
	}
		
	public String getCustomerRoute(String id) {
		return this.apiRoute + "/customers/" + id;
	}
}
