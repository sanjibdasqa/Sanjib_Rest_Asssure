package Unit_Test;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import io.restassured.response.Response;

public class Get_Test {
	
	 @Test(enabled = false)
	 public void getEmployeePretty() {
	 RestAssured.get(" http://localhost:3000/employees").prettyPrint();
	 }

	 @Test(enabled = false)
	 public void getEmployeeVar() {
	 Response response =RestAssured.get(" http://localhost:3000/employees");
	 System.out.println(response.asString());
	 }

	 @Test(enabled = false)
	 public void getEmployeeResponseCodeValidation() {
	     RestAssured.get(" http://localhost:3000/employees/5")
	     .then()
	     .statusCode(200);

	 }

	 @Test(enabled = false)
	 public void getEmployeeResponseCodeValidationNegativeTest404() {
	     RestAssured.get(" http://localhost:3000/employees/6")
	     .then()
	     .statusCode(404);
	 }

	 @Test(enabled = false)
	 public void getEmployeeLogs() {
	 RestAssured.given()
	 .log().all()
	 .get(" http://localhost:3000/employees")
	 .then()
	 .log().all()
	 .statusCode(200);
	 }

	 @Test(enabled =true )
	 public void getEmployeeResponseValidation() {
		 RestAssured.given()
		 .log().all()
		 .get(" http://localhost:3000/employees/4")
		 .then()
		 .log().all()
		 .statusCode(200)
		 .and()
		 .body("id",equalTo(4))
		 .body("name",equalTo("Manoj"))
		 .body("gpa",equalTo("2.2"));
		 
		 }

	 }
	
	
	
	


