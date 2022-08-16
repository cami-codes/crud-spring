package com.angular.crudspring.controller;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angular.crudspring.model.Course;
import com.angular.crudspring.repository.CourseRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
// o lombok cria o construtor pra mim
@AllArgsConstructor
public class CourseController {

//	@Autowired
	private CourseRepository courseRepository;
	
	/* boa prática invés do autowired
	public CourseController(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}*/
	
	@GetMapping
	public List<Course> list() {
		return courseRepository.findAll();
	}
	
	
}
