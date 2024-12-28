package com.learning.helidon;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CountryInfo {
	
	public String capital;
	public String currency;
	public String langauge;
	public long population;
	public long internetusers;
	public long mobilephones;
	

}
