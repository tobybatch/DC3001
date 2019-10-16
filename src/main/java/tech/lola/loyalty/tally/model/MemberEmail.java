package tech.lola.loyalty.tally.model;

import java.util.ArrayList;

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
	// Currently only supported value and OTARES does not have this concept.
	public static final String TYPE_HOME = "home";
	
	private String email;
	private String type;

    /**
     * Creates a Tally ready MemberEmail object from an OTRRes EmailAddressDto
     * 
     * @param dtoEmail The rest template object from OTARes
     * @return The rest template object ready for Tally.
     */
	public static MemberEmail factory(EmailAddressDto dtoEmail) {
		MemberEmail memberEmail = new MemberEmail();		
		memberEmail.setEmail(dtoEmail.getEmail());
		memberEmail.setType(TYPE_HOME);		
		return memberEmail;
	}
	
    /**
     * Creates a list of Tally ready MemberEmail objects from a list of OTRRes EmailAddressDto
     * 
     * @param dtoEmail The rest template object from OTARes
     * @return The rest template object ready for Tally.
     */
	public static ArrayList<MemberEmail> factory(EmailAddressDto dtoEmails[]) {
		ArrayList<MemberEmail> emails = new ArrayList<MemberEmail>();
		if (dtoEmails != null) {
			for (int i=0; i<dtoEmails.length; i++) {
				emails.add(MemberEmail.factory(dtoEmails[i]));
			}	
		}
		return emails;
	}

    /**
     * Creates a Tally ready MemberEmail object from an email address
     * 
     * @param email The email address
     * @return The rest template object ready for Tally.
     */
	public static MemberEmail factory(String email) {
		MemberEmail memberEmail = new MemberEmail();		
		memberEmail.setEmail(email);
		memberEmail.setType(TYPE_HOME);		
		return memberEmail;
	}
}
