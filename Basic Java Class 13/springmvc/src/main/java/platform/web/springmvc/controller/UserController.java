package platform.web.springmvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import platform.web.springmvc.model.User;
import platform.web.springmvc.service.UserService;

/**
 * Handles requests for the Employee service.
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = UserRestURIConstants.DUMMY_USER, method = RequestMethod.GET)
	public @ResponseBody User getDummyUser() {
		logger.info("Start getDummyEmployee");
		User user = userService.getUserByID(01);
		System.out.println("\n\n\n\n>>>>>> user: " + user.getUserName());
		return user;
	}
	
	@RequestMapping(value = UserRestURIConstants.GET_USER, method = RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable("id") int empId) {
		logger.info("Start getEmployee. ID="+empId);
		
		return userService.getUserByID(empId);
	}
	
	@RequestMapping(value = UserRestURIConstants.GET_ALL_USER, method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUser() {
		logger.info("Start getAllEmployees.");
		return userService.getAll();
	}
	
	@RequestMapping(value = UserRestURIConstants.CREATE_USER, method = RequestMethod.POST)
	public @ResponseBody User createUser(@RequestBody User emp) {
		logger.info("Start createEmployee.");
		userService.insertUser(emp);
		return emp;
	}
	
	@RequestMapping(value = UserRestURIConstants.DELETE_USER, method = RequestMethod.PUT)
	public @ResponseBody User deleteUser(@PathVariable("id") int empId) {
		logger.info("Start deleteEmployee.");
		return userService.getUserByID(01);
	}
	
}