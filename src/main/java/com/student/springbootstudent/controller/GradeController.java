package com.student.springbootstudent.controller;

import com.student.springbootstudent.entity.Grade;
import com.student.springbootstudent.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {

    private final GradeRepository gradeRepository;

    @Autowired
    public GradeController(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @GetMapping
    public List<Grade> allGrades(){
        return gradeRepository.findAll();
    }

    @GetMapping("/value/{value}")
    public List<Grade> gradesByValue(@PathVariable(value = "value") int value){
        return gradeRepository.findAllByValue(value);
    }

//    @GetMapping("/idstudent/{idstudent}")
//    public List<Grade> gradesByIdStudent(@PathVariable(value = "idstudent") int idstudent){
//        return gradeRepository.findAllByIdStudent(idstudent);
//    }

//    @GetMapping("/idcourse/{idcourse}")
//    public List<Grade> gradesByIdCourse(@PathVariable(value = "idcourse") int idcourse){
//        return gradeRepository.findAllByIdCourse(idcourse);
//    }

    @PostMapping
    public Grade saveGrade(@RequestBody Grade grade){
        return gradeRepository.save(grade);
    }

}
