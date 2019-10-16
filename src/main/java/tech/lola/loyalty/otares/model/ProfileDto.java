package tech.lola.loyalty.otares.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString @EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileDto {
	private String preferredDepartAirport;
	private boolean receiveNewsletter;
	private String iata;
	private String employeeId;
	private String redressNbr;
	private String emergencyContactFirstName;
	private String emergencyContactLastName;
	private String emergencyContactPhoneNumber;
	private String knownTravelerNumber;
}
