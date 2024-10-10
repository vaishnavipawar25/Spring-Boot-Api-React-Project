package com.SpringRest.SpringRest.Service;

import java.util.List;

import com.SpringRest.SpringRest.Entity.Course;

public interface CourseService {
	
	public List<Course> getCourses();
	public Course getCourse(long courseId);
	public Course addCourse(Course c);
	public Course updateCourse(Course c);
	public Course deleteCourse(long courseId); 
}

