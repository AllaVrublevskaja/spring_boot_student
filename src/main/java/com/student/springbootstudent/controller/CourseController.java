package com.student.springbootstudent.controller;

import com.student.springbootstudent.entity.Course;
import com.student.springbootstudent.entity.dto.request.CourseRequest;
import com.student.springbootstudent.entity.dto.response.CourseResponse;
import com.student.springbootstudent.repository.CourseRepository;
import com.student.springbootstudent.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseRepository courseRepository;
    private final CourseService courseService;

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
    public CourseResponse saveCourse(@RequestBody CourseRequest dto){
        return courseService.save(dto);
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable(value = "id") int courseId) {
        courseService.delete(courseId);
        return String.format("Course with id: %s has been successfully deleted", courseId);
    }
}

