package com.api.tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.api.constant.Role;
import com.api.pojo.CreateJobPayload;
import com.api.pojo.Customer;
import com.api.pojo.CustomerAddress;
import com.api.pojo.CustomerProduct;
import com.api.pojo.Problems;
import com.api.utils.SpecUtil;

public class CreateJobAPITest {

	
	@Test
	public void createJobAPITest() {
		
		//Creating the CreateJobPayload Object
		
		Customer customer = new Customer("Jatin", "Shharma", "7045663552", "", "jatinvsharma@gmail.com", "");
		CustomerAddress customerAddress = new CustomerAddress("D 404", "Vasant Galaxy", "Bangur nagar", "Inorbit", "Mumbai", "411039", "India", "Maharashtra");
		CustomerProduct customerProduct = new CustomerProduct("2025-04-06T18:30:00.000Z", "39970332084732", "39970332084732", "39970332084732", "2025-04-06T18:30:00.000Z", 1, 1);
		Problems problems = new Problems(1, "Battery Issue");
		Problems[] problemsArray = new Problems[1];
		problemsArray[0]=problems;
		
		CreateJobPayload createJobPayload = new CreateJobPayload(0, 2, 1, 1, customer, customerAddress, customerProduct, problemsArray);
		
		
		
		given()
		.spec(SpecUtil.requestSpecWithAuth(Role.FD, createJobPayload))
		.when()
		.post("/job/create")
		.then()
		.spec(SpecUtil.responseSpec_OK());
	}
	
}
