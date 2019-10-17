package tech.lola.loyalty.otares.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString @EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDto {

    private Long id;
    private String loyaltyId;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String middleName;
    private String suffix;
    private String title;
    private String dateOfBirth;
    private int gender;
    private int acquisitionSource;
    private String passwordResetToken;

    private ProfileDto profile;
    private AddressDto[] addresses;
    private PhoneDto[] phoneNumbers;
    private EmailAddressDto[] secondaryEmailAddresses;
    private CustomerProgramDto[] customerPrograms;
    private Credential credential;
}