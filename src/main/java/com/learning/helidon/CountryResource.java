package com.learning.helidon;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * A CountryResource (controller) that exposes the endpoints for retrieving country data.
 */

@Path("/country")
public class CountryResource {
	
	 @Inject
	 CountryRepositoryImpl countryService;
	 
	 // Endpoint to get all countries  /country/countries
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getAllCountries() {
	        List<Country> countries = countryService.all();
	        return Response.ok(countries).build();
	    }
	    
	    // Endpoint to get country details by country code  GET /country/{code} 
	    @GET
	    @Path("/{countryCode}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getCountryDetails(@PathParam("countryCode") String countryCode) throws CountryServiceException {
	        Country country = countryService.findByCode(countryCode);
	        if (country != null) {
	            return Response.ok(country).build();
	        } else {
	            return Response.status(Response.Status.NOT_FOUND)
	                    .entity("Country not found")
	                    .build();
	        }
	    }

}
