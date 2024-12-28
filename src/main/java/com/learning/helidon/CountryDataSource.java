package com.learning.helidon;

import java.util.HashMap;
import java.util.Map;

public class CountryDataSource {
	
	    public static final Map<String, Country> COUNTRIES_BY_NAME = new HashMap<>();
	    public static final Map<String, Country> COUNTRIES_BY_CODE = new HashMap<>();
	    
	    static {
	        /* load the country data */
	        Country canada = new Country("Canada", "CA", new CountryInfo("Ottawa", "Dollar (CAD)", "English (official) ", 33679000, 26960000, 26263000));
	        Country usa = new Country("United States", "US", new CountryInfo("Washington", "Dollar (USD)", "English", 310232863, 245000000, 310000000));
	        Country france = new Country("France", "FR", new CountryInfo("Paris", "Euro (EUR)", "French (official)", 64768389, 45262000, 62280000));
	        Country srilanka = new Country("SRILNAKA", "LKA", new CountryInfo("Colombo", "Rupee (LKR)", "Sinhala (official)", 21513990,1777000,19533000));
	        Country india = new Country("India", "IN", new CountryInfo("New Delhi", "Rupee (INR)", "Telugu (official)", 1173108018,61338000,893862000));
	        Country china = new Country("China", "CHN", new CountryInfo("Beijing", "Yuan Renminbi (CNY)", "Standard Chinese",1330044000,389000000,1100000000));
	        
	        
	        
	        COUNTRIES_BY_NAME.put(canada.getCountryName().toLowerCase(), canada);
	        COUNTRIES_BY_NAME.put(usa.getCountryName().toLowerCase(), usa);
	        COUNTRIES_BY_NAME.put(france.getCountryName().toLowerCase(), france);
	        COUNTRIES_BY_NAME.put(srilanka.getCountryName().toLowerCase(), srilanka);
	        COUNTRIES_BY_NAME.put(india.getCountryName().toLowerCase(), india);
	        COUNTRIES_BY_NAME.put(china.getCountryName().toLowerCase(), china);
	       
	        
	        COUNTRIES_BY_CODE.put(canada.getCountryCode(), canada);
	        COUNTRIES_BY_CODE.put(usa.getCountryCode(), usa);
	        COUNTRIES_BY_CODE.put(france.getCountryCode(), france);
	        COUNTRIES_BY_CODE.put(srilanka.getCountryCode(), srilanka);
	        COUNTRIES_BY_CODE.put(india.getCountryCode(), india);
	        COUNTRIES_BY_CODE.put(china.getCountryCode(), china);
	   
	    }

}
