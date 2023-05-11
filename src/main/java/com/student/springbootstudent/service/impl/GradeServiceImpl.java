package com.student.springbootstudent.service.impl;

import com.student.springbootstudent.entity.Course;
import com.student.springbootstudent.entity.Grade;
import com.student.springbootstudent.entity.Student;
import com.student.springbootstudent.entity.dto.request.GradeRequest;
import com.student.springbootstudent.entity.dto.response.GradeResponse;
import com.student.springbootstudent.mapper.GradeMapper;
import com.student.springbootstudent.repository.CourseRepository;
import com.student.springbootstudent.repository.GradeRepository;
import com.student.springbootstudent.repository.StudentRepositotry;
import com.student.springbootstudent.service.GradeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;
    private final StudentRepositotry studentRepositotry;
    private final CourseRepository courseRepository;
    private final GradeMapper gradeMapper;

    @Override
    public GradeResponse save(GradeRequest dto) {
        Student student = studentRepositotry.findById(dto.getStudentId())
                .orElseThrow(()->new NoSuchElementException(
                        String.format("Student with id %s doesn't exist!", dto.getStudentId())
        ));
        Course course = courseRepository.findById((dto.getCourseId()))
                .orElseThrow(()-> new NoSuchElementException(
                        String.format("Course with id %s doesn't exist!", dto.getCourseId())
        ));

        Grade grade = gradeMapper.GradeRequestToGrade(dto);

        grade.setStudent(student);
        grade.setCourse(course);
        gradeRepository.save(grade);
        log.info(String.format("Grade %s has been successfully created and saved!", grade.getId()));

        return gradeMapper.gradeToGradeResponse(grade);
    }

    @Override
    public void delete(int gradeId) {
        Grade grade = gradeRepository.findById(gradeId)
                .orElseThrow(()-> new NoSuchElementException(
                        String.format("Grade with id %s doesn't exist!", gradeId)
                ));
        gradeRepository.delete(grade);
        log.info(String.format("Grade with id %s has been successfully deleted!", gradeId));
    }
}

