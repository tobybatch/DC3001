package tech.lola.loyalty.tally.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tech.lola.loyalty.otares.model.CustomerDto;

@Getter @Setter @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalUpdateMemberProfileRequest {
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
		return customer;
	}
}
