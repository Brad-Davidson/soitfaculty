package com.soit.soitfaculty.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soit.soitfaculty.dao.FacultyRepository;
import com.soit.soitfaculty.entity.Faculty;


@Service
public class FacultyServiceImpl implements FacultyService {

	private FacultyRepository facultyRepository;

	@Autowired
	public FacultyServiceImpl (FacultyRepository theFacultyRepository) {
		facultyRepository = theFacultyRepository;
	}

	@Override
	public List<Faculty> findAll() {
		return facultyRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Faculty findById(int theId) {
		Optional<Faculty> facultyid =  facultyRepository.findById(theId);
		Faculty theFaculty = null;
		if(facultyid.isPresent()) {
			theFaculty = facultyid.get();
		}
		else {
			throw new RuntimeException ("The FacultyID you've entered is invalid - " + theId);
		}
		
		return theFaculty;
	}

	@Override
	public void save(Faculty theFaculty) {
		facultyRepository.save(theFaculty);
	}

	@Override
	public void deleteById(int theId) {
		facultyRepository.deleteById(theId);

	}

}