package tech.lola.loyalty.tally.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tech.lola.loyalty.otares.model.CustomerDto;
import tech.lola.loyalty.otares.model.EmailAddressDto;

@Getter @Setter @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberEmail {
	private String email;
	private String type;

    /**
     * Creates a Tally ready MemberEmail object from an OTRRes EmailAddressDto
     * 
     * @param dtoPhone The rest template object from OTARes
     * @return The rest template object ready for Tally.
     */
	public static MemberEmail factory(EmailAddressDto dtoEmail) {
		MemberEmail memberEmail = new MemberEmail();
		return memberEmail;
	}
}
