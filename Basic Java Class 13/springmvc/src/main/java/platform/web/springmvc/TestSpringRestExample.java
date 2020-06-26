package platform.web.springmvc;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import platform.web.springmvc.controller.UserRestURIConstants;
import platform.web.springmvc.model.User;

public class TestSpringRestExample {

	public static final String SERVER_URI = "http://localhost:8080/";

	public static void main(String args[]) {
		testGetDummyUser();
		System.out.println("*****");
		/*testCreateUser();
		System.out.println("*****");*/
		testGetUser();
		System.out.println("*****");
		testGetAllUser();
	}

	private static void testGetAllUser() {
		RestTemplate restTemplate = new RestTemplate();
		// we can't get List<User> because JSON convertor doesn't know the type of
		// object in the list and hence convert it to default JSON object type
		// LinkedHashMap
		List<LinkedHashMap> emps = restTemplate.getForObject(SERVER_URI + UserRestURIConstants.GET_ALL_USER, List.class);
		System.out.println(emps.size());
		for (LinkedHashMap map : emps) {
			System.out.println(
					"ID=" + map.get("id") + ",firstName=" + map.get("firstName") + ",userName=" + map.get("userName"));
			;
		}
	}

	private static void testCreateUser() {
		RestTemplate restTemplate = new RestTemplate();
		User emp = new User();
		emp.setId(1);
		emp.setUserName("Pankaj Kumar");
		User response = restTemplate.postForObject(SERVER_URI + UserRestURIConstants.CREATE_USER, emp,
				User.class);
		printEmpData(response);
	}

	private static void testGetUser() {
		RestTemplate restTemplate = new RestTemplate();
		String httpRequest = SERVER_URI + UserRestURIConstants.GET_USER.replaceFirst("/", "").replace("{id}", "1");
		System.out.println(httpRequest);
		User emp = restTemplate.getForObject(httpRequest, User.class);
		printEmpData(emp);
	}

	private static void testGetDummyUser() {
		RestTemplate restTemplate = new RestTemplate();
		User emp = restTemplate.getForObject(SERVER_URI + UserRestURIConstants.DUMMY_USER, User.class);
		printEmpData(emp);
	}

	public static void printEmpData(User emp) {
		System.out.println("ID=" + emp.getId() + ",Name=" + emp.getUserName());
	}
}