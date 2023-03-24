package functionalTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import endpoints.StudentCode;

public class PostStudentCodeTest {
	
StudentCode studentCode;
	
	@BeforeMethod
	public void init() {
		studentCode = new StudentCode();
		studentCode.init();
	}
	
	@Test
	public void postAStudent() {
		studentCode.postAStudentCode();
		studentCode.validateStatusCode(201);
		studentCode.validatePayloadObject("Name", "Sultana");
		studentCode.validate_w_JsonPath("studentCode", 4500);
	}
}



