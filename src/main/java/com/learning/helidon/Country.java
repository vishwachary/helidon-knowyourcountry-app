package com.learning.helidon;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Country {
	
	public String countryName;
	public String countryCode;
	public CountryInfo countryInfo;

}
