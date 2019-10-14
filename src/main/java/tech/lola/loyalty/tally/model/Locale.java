package tech.lola.loyalty.tally.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Locale {
	private String language;
	private String script;
	private String country;
	private String variant;

	private String[] extensionKeys;
	private String[] unicodeLocaleAttributes;
	private String[] unicodeLocaleKeys;
	
	private String iso3Language;
	private String iso3Country;
	private String displayLanguage;
	private String displayScript;
	private String displayCountry;
	private String displayVariant;
	private String displayName;
}
