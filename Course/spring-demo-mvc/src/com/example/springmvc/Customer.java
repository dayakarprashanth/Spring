package com.example.springmvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.springmvc.validation.CourseCode;


public class Customer {
	
	private String firstName;
	
	@NotNull(message= "is required")
	@Size(min=1,message= "is required")
	private String lastName;
	
	@NotNull(message= "is required")
	@Min(value=0,message="should be greater than or equal to 0")
	@Max(value=10,message="should be less than or equal to 10")
	private int freePasses;
	
	@Pattern(regexp = "^[0-9]{5}",message="should be only 5 digits")
	private String postalCode;
	
	@CourseCode(value = "CSCI", message="must start with CSCI")
	@NotNull(message= "is required")
	private String courseCode;

	public Customer() {
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}


	
	
	

}
