package platform.web.springmvc.core;

import org.springframework.context.annotation.*;

public class HelloWorld {
	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return "Your Message : " + message;
	}
}
