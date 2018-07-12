package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	//controller method to show initial form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	//controller method to process form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//read form data and add to the model
	@RequestMapping("/processFormVersion2")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		//read data from from
		String name = request.getParameter("studentName");
		
		//convert to upper case
		name = name.toUpperCase();
		
		//add to model
		model.addAttribute("message", name);
		return "helloworld";
		
		
	}
	
	@RequestMapping("/processFormVersion3")
	public String processFormVersion3(@RequestParam("studentName") String name, Model model) {
		
		//convert to upper case
		name = name.toUpperCase();
		
		String result = "hey friend " + name;
		//add to model
		model.addAttribute("message", result);
		return "helloworld";
		
		
	}
	
}

