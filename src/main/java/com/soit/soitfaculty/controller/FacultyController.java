package com.soit.soitfaculty.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soit.soitfaculty.model.Faculty;

@Controller
@RequestMapping("/Faculties")
public class FacultyController {
	
	//upload Faculty Info
	private List<Faculty> facultyMembers;
	
	@PostConstruct
	private void loadData() {
		
		//Create Faculties
		Faculty facultyMember1 = new Faculty(1, "Kelly", "Miller", "kmiller@mail.com");
		Faculty facultyMember2 = new Faculty(2, "Brad", "Davidson", "bdavidson@mail.com");
		Faculty facultyMember3 = new Faculty(3, "John", "Smith", "jsmith@mail.com");
		
		//Create our List
		facultyMembers = new ArrayList<Faculty>();
		
		//Add to our list
		facultyMembers.add(facultyMember1);
		facultyMembers.add(facultyMember2);
		facultyMembers.add(facultyMember3);
	}
	
	//Mapping for "/list"
	@GetMapping("/list")
	public String listFaculties(Model facultiesModel) {
		
		
		//add faculties to the spring model
		facultiesModel.addAttribute("faculties", facultyMembers);
		return "list-faculties";
		
	}
}
