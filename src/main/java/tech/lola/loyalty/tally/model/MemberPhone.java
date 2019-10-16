package tech.lola.loyalty.tally.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tech.lola.loyalty.otares.model.CustomerDto;
import tech.lola.loyalty.otares.model.PhoneDto;

@Getter @Setter @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberPhone {

    private String phoneNumber;
    private String phoneType;
    private String carrier;
    private String phoneExtension;

    /**
     * Creates a Tally ready MemberPhone object from an OTRRes PhoneDto
     * 
     * @param dtoPhone The rest template object from OTARes
     * @return The rest template object ready for Tally.
     */
	public static MemberPhone factory(PhoneDto dtoPhone) {
		MemberPhone memberPhone = new MemberPhone();
		return memberPhone;
	}
	
    /**
     * Creates a list of Tally ready MemberPhone objects from a list of OTRRes PhoneDto
     * 
     * @param dtoPhones The rest template object from OTARes
     * @return The rest template object ready for Tally.
     */
	public static ArrayList<MemberPhone> factory(PhoneDto dtoPhones[]) {
		ArrayList<MemberPhone> phones = new ArrayList<MemberPhone>();
		
		if (dtoPhones != null) {
			for (int i=0; i<dtoPhones.length; i++) {
				phones.add(MemberPhone.factory(dtoPhones[i]));
			}	
		}
		return phones;
	}
}
