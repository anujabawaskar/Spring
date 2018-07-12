package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;
import java.util.List;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	private String favouriteLanguage;
	private List<String> operatingSystem;
	
	private LinkedHashMap<String, String> countryOptions;
	public Student() {
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("ESP","Spain");
		countryOptions.put("ITL","Italy");
		countryOptions.put("AUS","Australia");
		countryOptions.put("IND","India");
		countryOptions.put("USA", "America");
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}
	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}
	public void setFavouriteLanguage(String favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}
	public List<String> getOperatingSystem() {
		return operatingSystem;
	}
	public void setOperatingSystem(List<String> operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	
}
