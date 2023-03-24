package utils;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import reporting.Logs;

public class RestSpacifications {


	protected RequestSpecification request;
	protected Response response;
	
	public void init() {
		String baseUrl = TestConfig.getUrl();
		request = RestAssured.given().baseUri(baseUrl);
	}
	
	public void getCall(String endpoint) {
		request.log().all();
		response = request.get(endpoint);
		Logs.log("Response :\n" + response.asPrettyString());
	}
	
	public void postCall(String endpoint) {
		request.log().all();
		response = request.post(endpoint);
		Logs.log("Response :\n" + response.asPrettyString());
	}
	
	public void validateStatusCode(int statusCode) {
		Logs.log("Expected Response Code is :" + statusCode + ". Actual Status code is : " + response.statusCode());
		response.then().statusCode(statusCode);
	}
	
	public void validatePayloadObject(String key, Object expectedValue) {
		Logs.log("Key is : "+key+". Expected value is : " + expectedValue);
		response.then().body(key, Matchers.equalTo(expectedValue));
	}
	
	public void validate_w_JsonPath(String path, Object expectedValue) {
		response.then().body(path, Matchers.equalTo(expectedValue));
		Logs.log("Expected : " + expectedValue + ". Actual :" + response.getBody().jsonPath().get(path));
	}
	
	public void setContentTypeAsJson() {
		request.contentType(ContentType.JSON);
	}
	
	public void setBody(File file) {
		request.body(file);
	}
	
	public void setBody(Map<String, ?> map) {
		request.body(map);
	}
	
	public void setBody(InputStream is) {
		request.body(is);
	}
	
	public void setBasicAuth(String user, String pass) {
		request.auth().basic(user, pass);
	}
	
	public void setOauth2Token(String token) {
		request.auth().preemptive().oauth2(token);
	}
	
	public void setHeader(String key, String value) {
		request.header(key, value);
	}
	
	public void setHeaders(Header... headers) {
		for(Header header : headers) {
			request.header(header);
		}
	}
	
	public Header setHeaderObj(String key, String value) {
		Header header = new Header(key, value);
		return header;
	}
	
	public Response getResponse() {
		return response;
	}

}
