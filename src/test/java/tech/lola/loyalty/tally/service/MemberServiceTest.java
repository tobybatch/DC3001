package tech.lola.loyalty.tally.service;

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
import tech.lola.loyalty.tally.model.MemberProfile;

@RunWith(SpringRunner.class)
@SpringBootTest
@Configuration
public class MemberServiceTest {

	@Autowired
	private MemberService memberService;

	@Autowired
	private RestTemplate restTemplate;

	private MockRestServiceServer mockServer;
	private ObjectMapper mapper = new ObjectMapper();

	@Before
	public void init() {
		mockServer = MockRestServiceServer.createServer(restTemplate);
	}

	@Test
	public void testFindMemberProfile() throws Exception {
		MemberProfile memberProfile = new MemberProfile();
		// Set at least on field so the equals is not matching empty
		memberProfile.setFirstName("Freddy Kruger");
		mockServer.expect(ExpectedCount.once(), requestTo(new URI(memberService.getMemberProfileRoute("abc"))))
				.andExpect(method(HttpMethod.GET)).andRespond(withStatus(HttpStatus.OK)
						.contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(memberProfile)));

		MemberProfile memeber = this.memberService.getMemberProfile("abc");
		mockServer.verify();
		assertEquals(memberProfile, memeber);
	}

	@Test
	public void testFindMemberProfileNotFound() throws Exception {
		MemberProfile memberProfile = new MemberProfile();
		// Set at least on field so the equals is not matching empty
		memberProfile.setFirstName("Freddy Kruger");
		mockServer.expect(ExpectedCount.once(), requestTo(new URI(memberService.getMemberProfileRoute("abc"))))
				.andExpect(method(HttpMethod.GET))
				.andRespond(withStatus(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
						.body("{\n" + "  \"errors\" : [ {\n" + "    \"code\" : \"1001\",\n"
								+ "    \"fieldName\" : \"accountNumber\",\n"
								+ "    \"message\" : \"Member not found.\",\n"
								+ "    \"messageParameters\" : [ \"accountNumber\", \"abc\" ]\n" + "  } ]\n" + "}"));

		MemberProfile member = this.memberService.getMemberProfile("abc");
		assertNull(member);
		mockServer.verify();
	}

	@Test
	public void testUpdateMemberProfile() throws Exception {
		CustomerDto customerDto = new CustomerDto();
		// Set at least on field so the equals is not matching empty
		customerDto.setFirstName("Freddy Kruger");
		customerDto.setLoyaltyId("123456789");
		
		MemberProfile memberProfile = new MemberProfile();
		// Set at least on field so the equals is not matching empty
		memberProfile.setFirstName("Freddy Kruger");
		
		mockServer.expect(ExpectedCount.once(), requestTo(new URI(memberService.getMemberProfileRoute("abc"))))
				.andExpect(method(HttpMethod.GET)).andRespond(withStatus(HttpStatus.OK)
						.contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(memberProfile)));
		
		mockServer.expect(ExpectedCount.once(), requestTo(new URI(memberService.getMemberProfileRoute("123456789"))))
				.andExpect(method(HttpMethod.PUT)).andRespond(withStatus(HttpStatus.OK));

		this.memberService.updateMemberProfile(customerDto);
	}

}
