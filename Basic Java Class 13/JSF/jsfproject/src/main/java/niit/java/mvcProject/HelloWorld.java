package niit.java.mvcProject;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name = "helloWorld", eager = true)
@RequestScoped
public class HelloWorld {
	private String message;
	
	public HelloWorld() {
		message = "Hello, My name is Ha";
		System.out.println("\n\n\n\n>>>>> message:" + message);
	}
	
	public String getMessage() {
		return "My name is Ha";
	}
	
	/*
	 * public String toLogin() { return "login"; }
	 */
}
