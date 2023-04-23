package com.student.springbootstudent.controller;

import com.student.springbootstudent.entity.Course;
import com.student.springbootstudent.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
        @GetMapping
        public List<Course> allCourses(){
             return courseRepository.findAll();
    }
    @GetMapping("/id/{id}")
    public List<Course> courseById(@PathVariable(value = "id") Integer id){
        return courseRepository.findAllById(Collections.singleton(id));
    }
    @GetMapping("/name/{name}")
    public List<Course> courseByName(@PathVariable(value = "name") String name){
        return courseRepository.findAllByName(name);
    }

    @PostMapping
    public Course saveCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }
}
