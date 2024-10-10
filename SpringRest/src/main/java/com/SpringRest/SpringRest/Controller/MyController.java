package com.SpringRest.SpringRest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringRest.SpringRest.Entity.Course;
import com.SpringRest.SpringRest.Service.CourseService;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from this origin
public class MyController {
	@Autowired
	private CourseService courseservice;

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	// get course
	@GetMapping("/courses")
	public List<Course> getCourses() {
		return this.courseservice.getCourses();
	}

	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseservice.getCourse(Long.parseLong(courseId));
	}
	
	
	@PostMapping("/courses") // by default it send application/json
	public Course addCourse(@RequestBody Course c) {
		return this.courseservice.addCourse(c);
	}

	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course c) {
		return this.courseservice.updateCourse(c);
	}

	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<?> deleteCourse(@PathVariable String courseId) {
		Course deletedCourse = courseservice.deleteCourse(Long.parseLong(courseId));

	    if (deletedCourse == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
	    }

	    // Instead of returning the deleted course, return a success message
	    return ResponseEntity.status(HttpStatus.OK).body("Course deleted successfully");
	}
}
