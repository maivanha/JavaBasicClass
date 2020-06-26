package platform.web;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import platform.web.springmvc.model.Employee;
import platform.web.springmvc.controller.UserRestURIConstants;

public class TestSpringRestExample {

	public static final String SERVER_URI = "http://localhost:8080/";

	public static void main(String args[]) {
		testGetDummyEmployee();
		System.out.println("*****");
		/*testCreateEmployee();
		System.out.println("*****");*/
		testGetEmployee();
		System.out.println("*****");
		testGetAllEmployee();
	}

	private static void testGetAllEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		// we can't get List<Employee> because JSON convertor doesn't know the type of
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

	private static void testCreateEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Pankaj Kumar");
		Employee response = restTemplate.postForObject(SERVER_URI + UserRestURIConstants.CREATE_USER, emp,
				Employee.class);
		printEmpData(response);
	}

	private static void testGetEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		String httpRequest = SERVER_URI + UserRestURIConstants.GET_USER.replaceFirst("/", "").replace("{id}", "1");
		System.out.println(httpRequest);
		Employee emp = restTemplate.getForObject(httpRequest, Employee.class);
		printEmpData(emp);
	}

	private static void testGetDummyEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		Employee emp = restTemplate.getForObject(SERVER_URI + UserRestURIConstants.DUMMY_USER, Employee.class);
		printEmpData(emp);
	}

	public static void printEmpData(Employee emp) {
		System.out.println("ID=" + emp.getId() + ",Name=" + emp.getName() + ",CreatedDate=" + emp.getCreatedDate());
	}
}