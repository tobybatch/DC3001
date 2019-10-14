package tech.lola.loyalty.tally.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberPreference {
	private String preferenceRuleCode;
	private String preferenceRuleDesc;
	private String preferenceRuleDetailCode;
	private String preferenceRuleDetailDesc;
	private String preferenceRuleDetailValue;
}
