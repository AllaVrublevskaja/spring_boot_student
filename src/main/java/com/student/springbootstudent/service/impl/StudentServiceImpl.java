package com.student.springbootstudent.service.impl;

import com.student.springbootstudent.entity.Student;
import com.student.springbootstudent.entity.dto.request.StudentRequest;
import com.student.springbootstudent.entity.dto.response.StudentResponse;
import com.student.springbootstudent.mapper.StudentMapper;
import com.student.springbootstudent.repository.StudentRepositotry;
import com.student.springbootstudent.service.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepositotry studentRepositotry;
    private final StudentMapper studentMapper;

    @Override
    public StudentResponse save(StudentRequest dto) {
        Student student = studentMapper.StudentRequestToStudent(dto);
        studentRepositotry.save(student);
        log.info(String.format("Student %s has been successfully created and saved!", student.getId()));
        return studentMapper.studentToStudentResponse(student);
    }

    @Override
    public void delete(int studentId) {
        Student student = studentRepositotry.findById(studentId)
                .orElseThrow(() -> new NoSuchElementException(
                        String.format("Student with id %s doesn't exist!", studentId)
                ));
        studentRepositotry.delete(student);
        student.getGrades().clear();
        log.info(String.format("Student %s has been successfully deleted", studentId));
    }
}
