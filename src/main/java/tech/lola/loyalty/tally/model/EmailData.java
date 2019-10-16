package tech.lola.loyalty.tally.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tech.lola.loyalty.otares.model.EmailAddressDto;

@Getter @Setter @NoArgsConstructor @ToString @EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailData {
	private int order;
	private boolean validated;
	private String email;
	private String type;
	private String status;
}
