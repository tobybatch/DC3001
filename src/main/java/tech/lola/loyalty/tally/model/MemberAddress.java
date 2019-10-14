package tech.lola.loyalty.tally.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberAddress {
	private String address1;
	private String address2;
	private String address3;
	private String city;
	private String stateCode;
	private String unicodeStateCode;
	private String zip;
	private String type;
	private String unicodeAddress1;
	private String unicodeAddress2;
	private String unicodeAddress3;
	private String unicodeCity;
	private String unicodeZip;
	private boolean active;
	private String countryCode;
	private String unicodeCountryCode;
	private String order;

}
