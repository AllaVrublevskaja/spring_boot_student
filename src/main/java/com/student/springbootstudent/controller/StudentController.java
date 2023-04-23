package com.student.springbootstudent.controller;

import com.student.springbootstudent.entity.Student;
import com.student.springbootstudent.repository.StudentRepositotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
    private final StudentRepositotry studentRepositotry;

    @Autowired
    public StudentController(StudentRepositotry studentRepositotry) {
        this.studentRepositotry = studentRepositotry;
    }
    @GetMapping
    public List<Student> allStudent(){
        return studentRepositotry.findAll();
    }
    @GetMapping("/id/{id}")
    public List<Student> studentById(@PathVariable(value = "id") Integer id){
        return studentRepositotry.findAllById(Collections.singleton(id));
    }
    @GetMapping("/name/{name}")
    public List<Student> studentByName(@PathVariable(value = "name") String name){
        return studentRepositotry.findAllByName(name);
    }
    @GetMapping("/surname/{surname}")
    public List<Student> studentBySurname(@PathVariable(value ="surname") String surname){
        return studentRepositotry.findAllBySurname(surname);
    }

    @GetMapping("/name/{name}/surname/{surname}")
        public List<Student> findStudent(@PathVariable(value = "name") String name,
                                         @PathVariable(value = "surname") String surname){
        return studentRepositotry.findAllByNameAndSurname(name,surname);
        }
        @PostMapping(consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
        public Student saveStudent(@RequestBody Student student){
        return studentRepositotry.save(student);
        }
}
