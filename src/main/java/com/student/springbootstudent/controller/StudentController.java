package com.student.springbootstudent.controller;

import com.student.springbootstudent.entity.Student;

import com.student.springbootstudent.entity.dto.request.StudentRequest;
import com.student.springbootstudent.entity.dto.response.StudentResponse;
import com.student.springbootstudent.repository.StudentRepositotry;

import com.student.springbootstudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    private final StudentRepositotry studentRepositotry;
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentRepositotry studentRepositotry,
                             StudentService studentService) {
        this.studentRepositotry = studentRepositotry;
        this.studentService = studentService;
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

    @GetMapping("/name_surname/{name} {surname}")
    public List<Student> findStudent(@PathVariable(value = "name") String name,
                                     @PathVariable(value = "surname") String surname){
        return studentRepositotry.findAllByNameAndSurname(name,surname);
        }

    @PostMapping
    public StudentResponse saveStudent(@RequestBody StudentRequest dto){
           return studentService.save(dto);
        }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable(value = "id") int studentId) {
        studentService.delete(studentId);
        return String.format("Student with id: %s has been successfully deleted", studentId);
    }
}

