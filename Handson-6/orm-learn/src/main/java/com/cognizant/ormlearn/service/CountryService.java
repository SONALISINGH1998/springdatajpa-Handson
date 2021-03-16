package com.cognizant.ormlearn.service;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	@Autowired 
	private CountryRepository countryRepository;
	
	
	@Transactional
	public List<Country> getAllCountries() {
		List<Country> countryList=(List<Country>)countryRepository.findAll();
		
		return countryList;
	}
	
	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException{
		Optional<Country> result = countryRepository.findById(countryCode);
		if (!result.isPresent()) {
			throw new CountryNotFoundException();
		}
		Country country = result.get();
		return country;
	}
}
