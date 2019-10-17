package tech.lola.loyalty.tally.service;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

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
import tech.lola.loyalty.tally.model.MemberProfile;

@Configuration
@Service
public class MemberService {

	@Value("${tally.api.endpoint}")
	private String apiRoute;
	
	@Autowired
	RestTemplate restTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberService.class);
	
	public MemberProfile getMemberProfile(String id) {
		// We have the customer id, get the customer
		String memberEndoint = this.getMemberProfileRoute(id);
		LOGGER.info("Looking up: " + id);

		// TODO catch 404
		MemberProfile member = null;
		try {
			member = restTemplate.getForObject(memberEndoint, MemberProfile.class);
			LOGGER.info("MemberProfile found: " + id);
		}
		catch (RestClientException rce) {
			LOGGER.error(rce.toString());
		}
		catch (Throwable t) {
			LOGGER.error(t.toString());
		}
		
		return member;
	}	
	
	public boolean memberExists(String loyaltyId) {
		MemberProfile memberProfile = this.getMemberProfile(loyaltyId);
		return memberProfile != null;		
	}
	
	public void updateMemberProfile(CustomerDto customerDto) {

		String loyaltyId = customerDto.getLoyaltyId();
		
		if (loyaltyId == null) {
			// If this customer doesn't have a loyalty it's not in the program.
			LOGGER.warn("Update request on account not in the loyalty program, %s %s (id=%s, loyaltyid=null)", customerDto.getFirstName(), customerDto.getLastName(), customerDto.getId());
			return;
		}
		
		if (this.memberExists(loyaltyId)) {
			// Update it
			ExternalUpdateMemberProfileRequest eumpr = ExternalUpdateMemberProfileRequest.factory(customerDto);

			try {
				restTemplate.put(this.getMemberProfileRoute(loyaltyId), eumpr);
				LOGGER.info("MemberProfile updated: " + loyaltyId);
			}
			catch (RestClientException rce) {
				LOGGER.error(rce.toString());
			}
			catch (Throwable t) {
				LOGGER.error(t.toString());
			}
		}
		else {
			// Create it
			this.createMemberProfile(customerDto);
		}

	}
	
	public void createMemberProfile(CustomerDto customerDto) {
		// TODO This should wire into Bogdan's code for creation.
	}

	public String getMemberProfileRoute(String id) {
		return this.apiRoute + "/rest/members/" + id;
	}

}
