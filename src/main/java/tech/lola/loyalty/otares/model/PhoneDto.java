package tech.lola.loyalty.otares.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString @EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class PhoneDto {

    private Long id;
    private String nbr;
    private int phoneType; // Should be an enum
    private String friendlyName;
    private String country;
    private boolean primary;
}
