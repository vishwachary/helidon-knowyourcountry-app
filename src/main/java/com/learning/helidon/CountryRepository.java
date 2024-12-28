package com.learning.helidon;

import java.util.List;
import java.util.Map;

import jakarta.ws.rs.core.Response;

public interface CountryRepository {

	List<Country> all();

	Country add(Country country) throws CountryServiceException;

	Country findByCode(String code) throws CountryServiceException;
	
	Country findByName(String code) throws CountryServiceException;

}
