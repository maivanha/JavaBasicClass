package platform.web.springmvc.controller;

import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import platform.web.springmvc.core.HelloWorld;

@Controller
public class HelloWorldController {
	String message = "Welcome to Spring MVC!<br/>";

	@RequestMapping("/hello")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		System.out.println("in controller");

		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		message += obj.getMessage() + " say hello to: ";

		/*
		 * ApplicationContext ctx = new
		 * AnnotationConfigApplicationContext(HelloWorldConfig.class);
		 * 
		 * HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
		 * helloWorld.setMessage("Hello World!"); helloWorld.getMessage();
		 */

		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}
}
