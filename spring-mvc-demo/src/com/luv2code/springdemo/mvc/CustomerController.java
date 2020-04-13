package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// add customer obj as attribute
		theModel.addAttribute("customer", new Customer());
		
		return "customer-form";
	}
	
	
	// @Valid performs the validation
	// BindingResult holds the result of the validation
	@RequestMapping("/processForm")
	public String processForm(
			@Valid @ModelAttribute("customer") Customer theCustomer,
			BindingResult theBindingResult) {
		
		System.out.println("Binding Result: " + theBindingResult);
		
		System.out.println("\n\n\n");
		
		if(theBindingResult.hasErrors()) {
			return "customer-form";
		} else {
			return "customer-confirmation";
		}

	}
	
	
	// @InitBinder will pre-process all web requests coming into our controller
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		// StringTrimmerEditor will trim the leading and trailing white-spaces
		// will trim a string of all white-spaces to be equal to null (which is what
		// the null in the constructor is specifying)
		
		// StringTrimmerEditor is part of the spring api
		// WebDataBinder is also from the spring api
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

}
