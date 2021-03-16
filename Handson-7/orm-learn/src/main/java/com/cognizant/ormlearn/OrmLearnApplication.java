package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.model.Country;
import java.util.List;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class OrmLearnApplication {

private static CountryService countryService;
private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);


private static void testGetAllCountries() {

LOGGER.info("Start");

List<Country> countries = countryService.getAllCountries();

LOGGER.debug("countries={}", countries);

LOGGER.info("End");

}

private static void getAllCountriesTest() throws CountryNotFoundException {

LOGGER.info("Start");
Country country = countryService.findCountryByCode("IN");

LOGGER.debug("Country:{}", country);

LOGGER.info("End");
}

private static void testAddCountry() throws CountryNotFoundException {
	LOGGER.info("Start");
	Country country=new Country();
	country.setCode("YZ");
	country.setName("New Country");
	countryService.addCountry(country);
	Country obj=countryService.findCountryByCode("YZ");
	LOGGER.debug("Country:{}", obj);
	LOGGER.info("End");
}

public static void main(String[] args) throws CountryNotFoundException {

	ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

	countryService = context.getBean(CountryService.class);

LOGGER.info("Inside main");

	testGetAllCountries();
	getAllCountriesTest();
	testAddCountry();
}


}
