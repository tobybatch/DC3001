package tech.lola.loyalty.otares.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDto {

	private Long id;
	private String line1;
	private String line2;
	private String city;
	private String stateCode;
	private String postalCode;
	private String countryCode;
	private String friendlyName;
	private int addressTypeId;
	private boolean primary;
}
/*profile
customerPrograms
credential
*/