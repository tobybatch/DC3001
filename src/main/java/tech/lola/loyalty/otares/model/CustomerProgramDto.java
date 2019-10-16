package tech.lola.loyalty.otares.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString @EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerProgramDto {
	private int id;
	private int programId;
	private String programName;
	private int status;
	private String programNamestatusName;
	private String programNameeffDatetime;
	private String programNameexpDatetime;
	private ProfileCouponCodeDto[] couponCodes;
}
