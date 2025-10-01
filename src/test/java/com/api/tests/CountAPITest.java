package com.api.tests;

import static com.api.constant.Role.FD;
import static com.api.utils.SpecUtil.requestSpec;
import static com.api.utils.SpecUtil.requestSpecWithAuth;
import static com.api.utils.SpecUtil.responseSpec_OK;
import static com.api.utils.SpecUtil.responseSpec_TEXT;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

import org.testng.annotations.Test;

public class CountAPITest {

	
	@Test(description = "Verifying if count api is giving correct response", groups ={"api", "regression","smoke"} )

	public void verifyCountAPIResponse() {
		given()
		.spec(requestSpecWithAuth(FD))
		.when()
		.get("/dashboard/count")
		.then()
		.spec(responseSpec_OK())
		.body("message", equalTo("Success"))
		.body("data", notNullValue())	
		.body("data.size()",equalTo(3))
		.body("data.count",everyItem(greaterThanOrEqualTo(0)))
		.body("data.label",everyItem(not(blankOrNullString())))
		.body("data.key", containsInAnyOrder("pending_fst_assignment","pending_for_delivery","created_today"))
		.body(matchesJsonSchemaInClasspath("response-schema/CountAPIResponseSchema-FD.json"));
	}
	
	
	@Test(description = "Verifying if count api is giving correct status code for invalid token", groups ={"api", "negative","regression","smoke"} )
	public void countAPITest_MisssingAuthToken() {
		given()
		.spec(requestSpec())
		.when()
		.get("/dashboard/count")
		.then()
		.spec(responseSpec_TEXT(401));
	}
	
	
	
	
	
	
}
