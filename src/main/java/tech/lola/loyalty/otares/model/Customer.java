package tech.lola.loyalty.otares.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

    private Long id;
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

    private Address[] addresses;
    private PhoneNumber[] phoneNumbers;
    private SecondaryEmailAddress[] secondaryEmailAddresses;
}
