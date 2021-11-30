package edu.wccnet.jopataylor.springMVC.domain;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class PetRegService {

	public Map<String, String> populateSpecies() {

		Map<String, String> speciesList = new LinkedHashMap<String, String>();

		speciesList.put("None", "---Select---");
		speciesList.put("Dog", "Dog");
		speciesList.put("Cat", "Cat");
		speciesList.put("Bird", "Bird");
		speciesList.put("Rabbit", "Rabbit");

		return speciesList;

	}

	public Map<String, String> populateGender() {

		Map<String, String> genderList = new LinkedHashMap<String, String>();

		genderList.put("Male", "Male");
		genderList.put("Female", "Female");
		genderList.put("Neutered", "Neutered");
		genderList.put("Spayed", "Spayed");

		return genderList;

	}

	public Map<String, String> populateSource() {

		Map<String, String> sourceList = new LinkedHashMap<String, String>();

		sourceList.put("Google", "Google");
		sourceList.put("Close", "Close");
		sourceList.put("Family/Friends", "Family/Friends");
		sourceList.put("Other", "Other");

		return sourceList;

	}

}
