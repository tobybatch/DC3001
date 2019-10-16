package tech.lola.loyalty.tally.model;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.lenient;

import org.junit.Test;

import net.bytebuddy.dynamic.TypeResolutionStrategy.Passive;
import tech.lola.loyalty.otares.model.AddressDto;
import tech.lola.loyalty.otares.model.CustomerDto;
import tech.lola.loyalty.otares.model.EmailAddressDto;
import tech.lola.loyalty.otares.model.PhoneDto;

public class ExternalUpdateMemberProfileRequestTest {
	
	private static final String stateCode = null;

	@Test
	public void testCreateFromDtoCustomer() {		
		CustomerDto dtoCustomer = new CustomerDto();
		dtoCustomer.setEmailAddress("mac@macgyver.org");
		dtoCustomer.setFirstName("Angus");
		dtoCustomer.setLastName("MacGyver");
		dtoCustomer.setMiddleName("Mac");
		dtoCustomer.setSuffix("jr.");
		dtoCustomer.setTitle("Mr.");
		dtoCustomer.setDateOfBirth("1950-01-23");
		dtoCustomer.setGender(2);

	    AddressDto[] addresses = new AddressDto[2];
	    addresses[0] = this.builAddressDto(1, "Home address", "13 Elm Street", "", "Los Angeles", "CA", "US", "90210", true);
	    addresses[1] = this.builAddressDto(1, "Work address", "Universal Studios", "", "Los Angeles", "CA", "US", "90210", false);
	    dtoCustomer.setAddresses(addresses);
	    
	    PhoneDto[] phoneNumbers = new PhoneDto[2];
	    phoneNumbers[0] = this.buildPhoneDto("555-1234", 1, "Home phone", "USA", true);
	    phoneNumbers[1] = this.buildPhoneDto("789-1234", 1, "Work phone", "USA", false);
	    dtoCustomer.setPhoneNumbers(phoneNumbers);
	    
	    EmailAddressDto[] secondaryEmailAddresses = new EmailAddressDto[1];
	    secondaryEmailAddresses[0] = this.buildEmailAddressDto("angus@macgyver.org", "Extra address");
	    dtoCustomer.setSecondaryEmailAddresses(secondaryEmailAddresses);
		
		ExternalUpdateMemberProfileRequest eumpr = ExternalUpdateMemberProfileRequest.factory(dtoCustomer);

		assertEquals("Angus", eumpr.getFirstName());
		assertEquals("MacGyver", eumpr.getLastName());
		assertEquals("M", eumpr.getMiddleInitial());
		assertEquals("jr.", eumpr.getSuffix());
		assertEquals("Mr.", eumpr.getTitle());
		assertEquals("1950-01-23", eumpr.getBirthDate());
		assertEquals("male", eumpr.getGenderCode());

		MemberAddress[] memberAddresses = eumpr.getAddresses();
		MemberPhone[] memberPhones = eumpr.getPhones();
		MemberEmail[] memberEmails = eumpr.getEmails();

		assertEquals(addresses.length, memberAddresses.length);
		assertEquals(phoneNumbers.length, memberPhones.length);
		assertEquals(secondaryEmailAddresses.length + 1, memberEmails.length);
	}
	
	private EmailAddressDto buildEmailAddressDto(String email, String friendlyName) {
		EmailAddressDto emailAddressDto = new EmailAddressDto();

		emailAddressDto.setEmail(email);
		emailAddressDto.setFriendlyName(friendlyName);
				
		return emailAddressDto;
	}
	
	private PhoneDto buildPhoneDto(String nbr, int phoneType, String friendlyName, String country, boolean primary) {
		PhoneDto phoneDto = new PhoneDto();

		phoneDto.setNbr(nbr);
		phoneDto.setPhoneType(phoneType);
		phoneDto.setFriendlyName(friendlyName);
		phoneDto.setCountry(country);
		phoneDto.setPrimary(primary);
		
		return phoneDto;
	}

	private AddressDto builAddressDto(int addressTypeId, String friendlyName, String line1, String line2, String city, String stateCode, String countryCode, String postalCode, boolean primary) {
		AddressDto addressDto = new AddressDto();
		
		addressDto.setAddressTypeId(addressTypeId);
		addressDto.setFriendlyName(friendlyName);
		addressDto.setLine1(line1);
		addressDto.setLine2(line2);
		addressDto.setCity(city);
		addressDto.setStateCode(stateCode);
		addressDto.setCountryCode(countryCode);
		addressDto.setPostalCode(postalCode);
		addressDto.setPrimary(primary);
		
		return addressDto;
	}
}
