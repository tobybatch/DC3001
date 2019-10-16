package tech.lola.loyalty.tally.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tech.lola.loyalty.otares.model.EmailAddressDto;

@Getter @Setter @NoArgsConstructor @ToString @EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberProfile {
	private String accountNumber;
	private String accountType;
	private String birthDate;
	private String closeDate;
	private String closeReasonCode;
	private String companyName;
	
	private CouponBalance[] couponBalance;
	private CreditCard[] creditCards;
	private EmailData[] emailAddresses;
	
	private String enrollCode;
	private String enrollmentDate;
	private String enrollmentDeviceCode;
	private String enrollmentSource;
	private String firstName;
	private String genderCode;
	private String lastName;
	
	private String middleInitial;
	private String onlineActivationDate;
	
	private MemberPhone[] phoneNumbers;
	private PointBalance[] pointBalance;
	
	private String status;
	private String suffix;
	private int testValue;
	
	private MemberTier tier;
	
	private String title;
	private String unicodeFirstName;
	private String unicodeInitial;
	private String unicodeKName;

	private Locale unicodeLanguage;
	
	private String unicodeLastName;
	private String unicodeSuffix;
	private String unicodeTitle;
	private String username;
}
