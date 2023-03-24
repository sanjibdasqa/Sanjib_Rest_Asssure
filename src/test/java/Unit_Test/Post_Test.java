package Unit_Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Post_Test {
	@Test(enabled = false)
	public void PostTest() {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body("{\r\n"
				+ "      \"id\": 10,\r\n"
				+ "      \"name\": \"Silan\",\r\n"
				+ "      \"gpa\": \"3.15\",\r\n"
				+ "      \"studentcode\": \"6\"\r\n"
				+ "    }")
		.basePath("/employees")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
						
	}
		
	@Test(enabled=true)
	public void PostTestFileBody500() {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body(new File("src/test/resources/employees.json"))
		.basePath("/employees")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(500);
				
	}
	
	@Test(enabled=true)
	public void PostTestinputStreamBody() {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body(getClass().getClassLoader().getResourceAsStream("employees2.json"))
		.basePath("/employees")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
				
	}
	
	@Test(enabled=false)
	public void PostTestByByteBody() {
		try {
			RestAssured.given()
			.baseUri("http://localhost:3000")
			.contentType(ContentType.JSON)
			.body(getClass().getClassLoader().getResourceAsStream("employees2.json").readAllBytes())
			.basePath("/employees")
			.when()
			.log().all()
			.post()
			.then()
			.log().all()
			.statusCode(201);
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	
	@Test(enabled = true)
	public void postTestMapBody() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "sajid");
		map.put("gpa", "3.99");
		map.put("StudentCode", 80);
		
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body(map)
		.basePath("/employees")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
	}


}
