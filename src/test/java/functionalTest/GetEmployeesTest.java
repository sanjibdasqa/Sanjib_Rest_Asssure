package functionalTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import endpoints.Employees;

public class GetEmployeesTest {
Employees employees;
	
	@BeforeMethod
	public void initTests() {
		employees = new Employees();
		employees.init();
	}
	
	@Test
	public void getEmployeesValidation() {
		employees.getEmployees();
		employees.validateStatusCode(200);
	}

}
