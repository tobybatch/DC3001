package tech.lola.loyalty.tally.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tech.lola.loyalty.otares.model.AddressDto;
import tech.lola.loyalty.otares.model.CustomerDto;

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

    /**
     * Creates a Tally ready MemberAddress object from an OTRRes AddressDto
     * 
     * @param dtoAddress The rest template object from OTARes
     * @return The rest template object ready for Tally.
     */
	public static MemberAddress factory(AddressDto dtoAddress) {
		MemberAddress address = new MemberAddress();
		return address;
	}
	
    /**
     * Creates a list of Tally ready MemberAddress objects from a list of OTRRes AddressDto
     * 
     * @param dtoPhones The rest template object from OTARes
     * @return The rest template object ready for Tally.
     */
	public static ArrayList<MemberAddress> factory(AddressDto dtoAddresses[]) {
		ArrayList<MemberAddress> addresses = new ArrayList<MemberAddress>();
		if (dtoAddresses != null) {
			for (int i=0; i<dtoAddresses.length; i++) {
				addresses.add(MemberAddress.factory(dtoAddresses[i]));
			}	
		}
		return addresses;
	}
}
