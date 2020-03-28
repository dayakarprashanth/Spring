package com.example.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// need a controller method to show the initital Form 
	
	@RequestMapping("/showForm")
	public String showForm()
	{
		return "helloworld-form";
		
	}
	
	//need a controller method to process the HTML form
	
	@RequestMapping("/processForm")
	public String processForm()
	{
		return "helloworld";
		
	}
	
	// new controller to read the form data and 
	//add data to the model
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude (HttpServletRequest request, Model model)
	{
		//read the request parameter from html form
		String thename= request.getParameter("studentName");
		
		//convert the data to all caps
		thename=thename.toUpperCase();
		
		//create the message 
		String result = "Yo!!!  " + thename;
		
		//add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
		
	}
	
	// making use of the RequestParam annotation to read the http servlet request and raed the form parameter 
	// and bind it to String theName
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree (
			@RequestParam ("studentName") String theName, 
			Model model)
	{
		//convert the data to all caps
		theName=theName.toUpperCase();
		
		//create the message 
		String result = "Yo!!! Hey My Friend! " + theName;
		
		//add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	@RequestMapping("/loveMessage")
	public String loveMessage(HttpServletRequest request, Model model)
	{
		// read the request parameter from html form
		String love = request.getParameter("studentName");
		
		//convert data to all caps
		love = love.toUpperCase();
		 
		//create a message 
		String result = love + " " + " Loves Kumba ";
		
		// add message to model
		model.addAttribute("lovemessage", result);
		
		return "helloworld";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
