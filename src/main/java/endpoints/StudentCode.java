package endpoints;

import utils.RestSpacifications;

public class StudentCode  extends RestSpacifications{
	private final String ENDPOINT = "/StudentCode";
	private final String fileName = "studentCode.json";
	
	public void getStudentCode() {
		getCall(ENDPOINT);
	}
	
	public void getEachStudentCode(int studentCode) {
		getCall(ENDPOINT + "/" + studentCode);
	}
	
	public void postAStudentCode() {
		setBody(getClass().getClassLoader().getResourceAsStream(fileName));
		setContentTypeAsJson();
		setBasicAuth("user", "pass");
		postCall(ENDPOINT);
	}

}
