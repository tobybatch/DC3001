package tech.lola.loyalty.tally.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tech.lola.loyalty.otares.model.CustomerDto;

@Getter @Setter @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberPreference {
	private String preferenceRuleCode;
	private String preferenceRuleDesc;
	private String preferenceRuleDetailCode;
	private String preferenceRuleDetailDesc;
	private String preferenceRuleDetailValue;

    /*
    The current user in OTARes does not really have a preferences object.
    TODO Check if it comes from custcoms about recieve email/direct mail etc
	public static MemberPreference factory(Object preference) {
		MemberPreference memberPreference = new MemberPreference();
		return memberPreference;
	}
	*/
}
