package com.example.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FunnyController {
	@RequestMapping("/showForm")
	public String showForm()
	{
		return "funnyform";
		
	}

}
