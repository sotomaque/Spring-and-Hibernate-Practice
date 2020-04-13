package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// controller method to show initial form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// controller method to process form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// new controller method to read form data and
	// add form data to the model
	@RequestMapping("/processFormTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		// read request param from html form
		String theName = request.getParameter("studentName");
		
		// convert data to all caps
		theName = theName.toUpperCase();
		
		// create message
		String result = "YO! " + theName;
		
		// add message to model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	// same as above method, however here we make use of request param binding
	// spring will read the http server request, grab the param studentName, and 
	// bind it to the method variable 'theName'
	@RequestMapping("/processFormThree")
	public String letsShoutDudeVersion2(
			@RequestParam("studentName") String theName,
			Model model) {
		
		// convert data to all caps
		theName = theName.toUpperCase();
		
		// create message
		String result = "Hey my friend from v3: " + theName;
		
		// add message to model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
}
