package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.model.Country;
import java.util.List;
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

public static void main(String[] args) {

	ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

	countryService = context.getBean(CountryService.class);

LOGGER.info("Inside main");

	testGetAllCountries();
}


}
