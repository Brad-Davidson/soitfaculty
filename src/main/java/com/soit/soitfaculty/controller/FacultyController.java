package com.soit.soitfaculty.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.soit.soitfaculty.entity.Faculty;
import com.soit.soitfaculty.services.FacultyService;

@Controller
@RequestMapping("/Faculties")
public class FacultyController {
	
	//upload Faculty Info
	private List<Faculty> facultyMembers;
	
	private FacultyService facultyService;
	
	public FacultyController(FacultyService facSvc) {
		this.facultyService = facSvc;
	}
	
	@PostConstruct
	private void loadData() {
		
		//Create Faculties
//		Faculty facultyMember1 = new Faculty(1, "Kelly", "Miller", "kmiller@mail.com");
//		Faculty facultyMember2 = new Faculty(2, "Brad", "Davidson", "bdavidson@mail.com");
//		Faculty facultyMember3 = new Faculty(3, "John", "Smith", "jsmith@mail.com");
		
		//Create our List
//		facultyMembers = new ArrayList<Faculty>();
//		
//		//Add to our list
//		facultyMembers.add(facultyMember1);
//		facultyMembers.add(facultyMember2);
//		facultyMembers.add(facultyMember3);
	}
	
	//Mapping for "/list"
	@GetMapping("/list")
	public String listFaculties(Model facultiesModel) {
		
		//retrieve faculty from the database
		List<Faculty> faculties = facultyService.findAll();
		
		//add faculties to the spring model
		facultiesModel.addAttribute("faculties", faculties);
		return "faculties/list-faculties";
		
	}
	
	@GetMapping("/viewAddForm")
	public String viewAddForm(Model formModel) {
		
		//Model attributes for data binding
		Faculty fac = new Faculty();
		
		formModel.addAttribute("faculty", fac);
		
		return "faculties/viewAddForm";
	}
	
	@GetMapping("/viewUpdateForm")
	public String viewUpdateForm(@RequestParam("facultyId") int theId, Model formModel) {
		Faculty fac = facultyService.findById(theId);
		formModel.addAttribute("faculty", fac);
		return "faculties/viewUpdateForm";
	}
	
	@PostMapping("/save")
	public String saveFaculty(@ModelAttribute("faculty") Faculty fac) {
		facultyService.save(fac);
		
		//Block duplicate submission for accidental page refreshed
		return "redirect:/Faculties/list";
	}
	
}
