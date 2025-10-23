package com.api.utils;

import java.util.Locale;

import com.github.javafaker.Faker;

public class FakerDemo {

	public static void main(String[] args) {
		//We will be using the faker library for our fake test data creation!!!
		
		// We will be creating a fakerUtil that uses this faker library!
		Locale locale = new Locale("en-IND");
		Faker faker = new Faker(locale);
		String firstName=faker.name().firstName();
		String lastName=faker.name().lastName();
		System.out.println(firstName);
		System.out.println(lastName);
		
		String buildingNumber=faker.address().buildingNumber();
		System.out.println(buildingNumber);
		
		
		System.out.println(faker.address().streetAddress());
		System.out.println(faker.address().streetName());
		System.out.println(faker.address().city());
		
		System.out.println(faker.number().digits(10));
		System.out.println(faker.numerify("704#######"));
		System.out.println(faker.numerify("704#######"));
		System.out.println(faker.numerify("704#######"));
		System.out.println(faker.numerify("704#######"));
		
		System.out.println(faker.internet().emailAddress());
		
		System.out.println(faker.phoneNumber().cellPhone());
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}









