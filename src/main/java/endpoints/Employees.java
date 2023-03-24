package endpoints;

import utils.RestSpacifications;

public class Employees extends RestSpacifications {
private final String ENDPOINT = "/employees";
	
	public void getPlayers() {
		getCall(ENDPOINT);
	}

}
