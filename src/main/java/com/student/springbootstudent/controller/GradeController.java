package com.student.springbootstudent.controller;

import com.student.springbootstudent.entity.Grade;
import com.student.springbootstudent.entity.dto.request.GradeRequest;
import com.student.springbootstudent.entity.dto.response.GradeResponse;
import com.student.springbootstudent.repository.GradeRepository;
import com.student.springbootstudent.service.GradeService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/grades")
public class GradeController {

    private final GradeRepository gradeRepository;
    private final GradeService gradeService;

    @GetMapping
    public List<Grade> allGrades(){
        return gradeRepository.findAll();
    }

    @GetMapping("/value/{value}")
    public List<Grade> gradesByValue(@PathVariable(value = "value") int value){
        return gradeRepository.findAllByValue(value);
    }

    @GetMapping("/studentid/{studentid}")
    public List<Grade> gradesByIdStudent(@PathVariable(value = "studentid") int studentid){
    return gradeRepository.findAllByStudentId(studentid);
    }

    @GetMapping("/courseid/{courseid}")
    public List<Grade> gradesByIdCourse(@PathVariable(value = "courseid") int courseid){
    return gradeRepository.findAllByCourseId(courseid);
    }

    @PostMapping
    public GradeResponse saveGrade(@RequestBody GradeRequest dto){
        return gradeService.save(dto);
    }

    @DeleteMapping("/{id}")
    public String deleteGrade(@PathVariable(value = "id") int gradeId) {
        gradeService.delete(gradeId);
        return String.format("Grade with id: %s has been successfully deleted",gradeId);
    }
}

