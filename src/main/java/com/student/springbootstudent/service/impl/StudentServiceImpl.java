package com.student.springbootstudent.service.impl;

import com.student.springbootstudent.entity.Student;
import com.student.springbootstudent.service.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {
    @Override
    public Student save() {
        return null;
    }
}
