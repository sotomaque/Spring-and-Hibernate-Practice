package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	// show form
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// create a new student object
		Student theStudent = new Student();
		
		// add student obj as model attribute
		theModel.addAttribute("student", theStudent);
		
		// student-form is a jsp page that makes use of Spring MVC Form tags
		// to generate html / bind data to our model attribute (student)
		return "student-form";
	}
	
	// process form
	// making use of @modelattribute to bind form data to model attributes
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		// log input data
		System.out.println("theStudent: " + theStudent.getFirstName() + 
				" " + theStudent.getLastName());
		
	
		return "student-confirmation";
	}
	
}
