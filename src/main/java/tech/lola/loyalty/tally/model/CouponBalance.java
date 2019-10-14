package tech.lola.loyalty.tally.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CouponBalance {
	private String couponTypeCode;
	private String couponName;
	private String promoCode;
	private String value;
	private int couponsAvailable;
	private int couponsEarned;
	private int couponsRedeemed;
	private int couponsExpired;
	private int couponsExpiringSoon;
	private int couponsPending;
	private int couponCount;
}
