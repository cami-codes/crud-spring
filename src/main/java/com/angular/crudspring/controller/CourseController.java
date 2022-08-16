package com.angular.crudspring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

	/*
	 * boa prática invés do autowired public CourseController(CourseRepository
	 * courseRepository) { this.courseRepository = courseRepository; }
	 */

	@GetMapping
	public List<Course> list() {
		return courseRepository.findAll();
	}

	// eu posso fazer a mesma coisa sem o ResponseEntity através do ResponseStatus
	// já q só to fazendo um post
	// mas só se eu nao tiver colocado nada no cabeçalho et
//	@PostMapping
//	public ResponseEntity<Course> create(@RequestBody Course course) {
//		return ResponseEntity.status(HttpStatus.CREATED).body(courseRepository.save(course));

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Course create(@RequestBody Course course) {
		return courseRepository.save(course);
	}

}
