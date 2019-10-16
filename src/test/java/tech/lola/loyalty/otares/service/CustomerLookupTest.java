package tech.lola.loyalty.otares.service;

import static org.junit.Assert.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

import java.net.URI;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import tech.lola.loyalty.otares.model.CustomerDto;

@RunWith(SpringRunner.class)
public class CustomerLookupTest {

	 
    // private RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private RestTemplate restTemplate;
 
    private MockRestServiceServer mockServer;
    private ObjectMapper mapper = new ObjectMapper();
 
    @Before
    public void init() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }
     
    @Test                                                                                         
    public void testCustomerLookup() throws Exception {   
        CustomerDto customerDto = new CustomerDto();
        
        mockServer.expect(ExpectedCount.once(),
                requestTo(new URI("http://localhost:8080/otares/v2/api/customers/1")))
                  .andExpect(method(HttpMethod.GET))
                  .andRespond(withStatus(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
          .body(mapper.writeValueAsString(customerDto))
        );                                   
                        
        // Employee employee = empService.getEmployee(id);
        // mockServer.verify();
        // Assert.assertEquals(customerDto, employee);                                                        
    }
}