package tech.lola.loyalty.tally.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tech.lola.loyalty.otares.model.CustomerDto;
import tech.lola.loyalty.otares.model.EmailAddressDto;

@Getter @Setter @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalUpdateMemberProfileRequest {
	
	// TODO move these to config
	private static final int GENDER_MALE = 2;
	private static final int GENDER_FEMALE = 1;
	private static final String LANGUAGE = "US";
	
	private String title;
	private String firstName;
	private String middleInitial;
	private String lastName;
	private String suffix;
	private String companyName;
	private String genderCode;
	private String mergeSurvivorAccountNumber;
	private String unicodeFirstName;
	private String unicodeInitial;
	private String unicodeKName;
	private String unicodeLanguage;
	private String unicodeLastName;
	private String unicodeSuffix;
	private String unicodeTitle;
	private String birthDate;
	private MemberAddress[] addresses;
	private MemberPreference[] preferences;
	private MemberEmail[] emails;
	private MemberPhone[] phones;

    /**
     * Creates a Tally ready ExternalUpdateMemberProfileRequest object from an OTRRes CustomerDto
     * 
     * @param dtoPhone The rest template object from OTARes
     * @return The rest template object ready for Tally.
     */
	public static ExternalUpdateMemberProfileRequest factory(CustomerDto dtoCustomer) {
		ExternalUpdateMemberProfileRequest customer = new ExternalUpdateMemberProfileRequest();
		customer.setTitle(dtoCustomer.getTitle());
		customer.setFirstName(dtoCustomer.getFirstName());
		customer.setMiddleInitial(dtoCustomer.getMiddleName() != null ? dtoCustomer.getMiddleName().substring(0, 1) : null);
		customer.setLastName(dtoCustomer.getLastName());
		customer.setSuffix(dtoCustomer.getSuffix());
		customer.setGenderCode(genderCodeToString(dtoCustomer.getGender()));
		
		// customer.setMergeSurvivorAccountNumber(dtoCustomer.get??????());
		// customer.setCompanyName(dtoCustomer.get??????());
		
		customer.setUnicodeFirstName(customer.getFirstName());
		customer.setUnicodeInitial(customer.getFirstName() != null ? customer.getFirstName().substring(0, 1) : null);
		// customer.setUnicodeKName(dtoCustomer.get??????());
		customer.setUnicodeLanguage(ExternalUpdateMemberProfileRequest.LANGUAGE);
		customer.setUnicodeLastName(customer.getLastName());
		customer.setUnicodeSuffix(customer.getSuffix());
		customer.setUnicodeTitle(customer.getTitle());
		
		customer.setBirthDate(dtoCustomer.getDateOfBirth());

		// There isn't really mapping for user prefs, maybe from cust coms

		ArrayList<MemberAddress> addresses = MemberAddress.factory(dtoCustomer.getAddresses()); 
		customer.setAddresses(addresses.toArray(new MemberAddress[addresses.size()]));
		
		ArrayList<MemberEmail> emails = new ArrayList<MemberEmail>();
		emails.add(MemberEmail.factory(dtoCustomer.getEmailAddress()));
		emails.addAll(MemberEmail.factory(dtoCustomer.getSecondaryEmailAddresses()));
		customer.setEmails(emails.toArray(new MemberEmail[emails.size()]));

		ArrayList<MemberPhone> phones = MemberPhone.factory(dtoCustomer.getPhoneNumbers()); 
		customer.setPhones(phones.toArray(new MemberPhone[phones.size()]));

		return customer;
	}
		
	public static final String genderCodeToString(int genderCode) {
		String gender = "unknown";

		// We can use a switch if we want to set the values for gender in properties.
		// These values are set by the auto increment in the DB so are not immutable
		if (genderCode == ExternalUpdateMemberProfileRequest.GENDER_MALE) {
			gender = "male";
		}
		else if (genderCode == ExternalUpdateMemberProfileRequest.GENDER_FEMALE) {
			gender = "female";
		}
		
		return gender;
	}
}
