package Unit_Test;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutTest {
	@Test
	public void putTest() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "Rahim");
		map.put("gpa", "3.99");
		map.put("StudentCode", 90);
		
		
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.basePath("/employees/10") 
		.contentType(ContentType.JSON)
		.body(map)
		.log().all()
		.put()
		.then()
		.log().all()
		.statusCode(200);
	}


}
