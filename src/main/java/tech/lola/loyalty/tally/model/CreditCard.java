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
public class CreditCard {
	private String cardTypeCode;
	private String enrollDate;
	private String lastOpenDate;
	private String lastCloseDate;
	private String firstUseDate;
	private String lastStatementDate;
	private String accountStatusDate;
	private String productType;
	private String spendAmount;
	private String sourceCode;
	private String merchantCode;
	private String channelCode;
	private String storeEmployeeId;
	private int cardCount;
	private String arn;
}
