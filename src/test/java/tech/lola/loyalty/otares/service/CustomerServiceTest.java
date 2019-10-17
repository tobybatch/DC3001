package tech.lola.loyalty.otares.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import java.net.URI;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import tech.lola.loyalty.otares.model.CustomerDto;

@RunWith(SpringRunner.class)
@SpringBootTest
@Configuration
public class CustomerServiceTest {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private RestTemplate restTemplate;

	private MockRestServiceServer mockServer;
	private ObjectMapper mapper = new ObjectMapper();

	@Before
	public void init() {
		mockServer = MockRestServiceServer.createServer(restTemplate);
	}

	@Test
	public void testFindCustomer() throws Exception {
		CustomerDto customerDto = new CustomerDto();
		// Set at least on field so the equals is not matching empty
		customerDto.setFirstName("Freddy Kruger");
		mockServer.expect(ExpectedCount.once(), 
			requestTo(new URI(customerService.getCustomerRoute("abc"))))
			.andExpect(method(HttpMethod.GET))
			.andRespond(withStatus(HttpStatus.OK)
			.contentType(MediaType.APPLICATION_JSON)
			.body(mapper.writeValueAsString(customerDto))
		);

		CustomerDto customer = this.customerService.getCustomer("abc");
		
        mockServer.verify();
		assertEquals(customerDto, customer);
	}

}
