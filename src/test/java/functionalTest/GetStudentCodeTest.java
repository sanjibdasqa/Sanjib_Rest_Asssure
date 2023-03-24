package functionalTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import endpoints.StudentCode;

public class GetStudentCodeTest {
StudentCode studentCode;
	
	@BeforeMethod
	public void init() {
		studentCode = new StudentCode();
		studentCode.init();
	}
	
	@Test(enabled = true)
	public void getStudentCode() {
		studentCode.getStudentCode();
		studentCode.validateStatusCode(200);
	}
	
	@Test(enabled = false)
	public void getStudentCodeById() {
		studentCode.getEachStudentCode(1);
		studentCode.validateStatusCode(200);
		studentCode.validatePayloadObject("name", "Rahim");
		studentCode.validatePayloadObject("studentCode", 1500);
		studentCode.validate_w_JsonPath("id", 1);
	}
	
	@Test (enabled = false)
	public void responValidation() {
		studentCode.getEachStudentCode(1);
		System.out.println(studentCode.getResponse().getBody().jsonPath().getString("studentCode"));
	}

}
