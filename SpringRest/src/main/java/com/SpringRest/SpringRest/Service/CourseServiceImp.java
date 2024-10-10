package com.SpringRest.SpringRest.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringRest.SpringRest.Entity.Course;
import com.SpringRest.SpringRest.dao.CourseDao;

import org.springframework.transaction.annotation.Transactional;
@Service
public class CourseServiceImp implements CourseService {

	@Autowired
	private CourseDao coursedao;
	//List<Course> list;
	public CourseServiceImp()
	{
//		list=new ArrayList<>();
//		list.add(new Course(101,"Java","Basics of Java"));
//		list.add(new Course(102,"Python","Basics of Python"));
	}
	@Override
	public List<Course> getCourses() {
		
		return coursedao.findAll();
	}
	
	@Override
	public Course getCourse(long courseId) {
//		Course c=null;
//		for(Course course:list)
//		{
//			if(course.getId()==courseId)
//			{
//				c=course;
//				break;
//			}
//				
//		}
		return coursedao.getOne(courseId);
	}
	@Override
	public Course addCourse(Course c) {
		// TODO Auto-generated method stub
		//list.add(c);
		coursedao.save(c);
		return c;
	}
	@Override
	public Course updateCourse(Course c) {
//		list.forEach(e ->{
//			if(e.getId()==c.getId())
//			{
//				e.setTitle(c.getTitle());
//				e.setDescription(c.getDescription());
//			}
//		});
		coursedao.save(c);
		return c;
	}
	@Override
	public Course deleteCourse(long courseId) {
		// TODO Auto-generated method stub
//		Course courseToDelete = null;
//	    for (Course course : list) {
//	        if (course.getId() == courseId) {
//	            courseToDelete = course;
//	            break;
//	        }
//	    }
//	    
//	    // Remove the course from the list if it exists
//	    if (courseToDelete != null) {
//	        list = this.list.stream().filter(e -> e.getId() != courseId).collect(Collectors.toList());
//	    }
		Course entity=coursedao.getOne(courseId);
	    coursedao.delete(entity);
	    return entity;
	}

}
