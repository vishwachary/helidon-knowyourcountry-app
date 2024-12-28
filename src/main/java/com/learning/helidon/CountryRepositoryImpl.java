package com.learning.helidon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CountryRepositoryImpl implements CountryRepository{
	
	

	@Override
	public List<Country> all() {
		Map<String, Country> countriesByCode = CountryDataSource.COUNTRIES_BY_CODE;
		 return countriesByCode.values().stream().collect(Collectors.toList());
	}

	@Override
	public Country add(Country country) throws CountryServiceException {
		System.out.println("Enters CountryRepositoryImpl.add()");

        if (!isValid(country)) {
            throw new CountryServiceException(400, "Given country information is not valid");
        }
        CountryDataSource.COUNTRIES_BY_NAME.put(country.getCountryName().toLowerCase(), country);
      
        return country;
	}

	@Override
	public Country findByCode(String code) throws CountryServiceException {
		Map<String, Country> countriesByCode = CountryDataSource.COUNTRIES_BY_CODE;
		 return countriesByCode.get(code.toUpperCase());
	}

	@Override
	public Country findByName(String name) throws CountryServiceException {
		Map<String, Country> countriesByCode = CountryDataSource.COUNTRIES_BY_NAME;
		 return countriesByCode.get(name.toUpperCase());
	}
	
	
	 private boolean isValid(Country country) {
	        if (country.getCountryCode() == null || country.getCountryCode().isEmpty()) {
	            return false;
	        }

	        if (country.getCountryName() == null || country.getCountryName().isEmpty()) {
	            return false;
	        }

	        return true;
	    }
}
