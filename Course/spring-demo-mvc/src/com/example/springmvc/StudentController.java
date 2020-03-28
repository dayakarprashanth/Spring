package com.example.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

		@RequestMapping("/showPage")
		public String showPage(Model theModel) {
		
		// create Student Object 
		Student theStudent = new Student();
		
		//assign the data to model
		theModel.addAttribute("student", theStudent);
		
		return "student-Form";
	}	
		
		@RequestMapping("/processPage")
		public String processPage(@ModelAttribute("student") Student theStudent) {
			
			
				return "student-Confirmation";
			}
		
}
