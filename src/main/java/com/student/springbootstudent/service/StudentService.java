package com.student.springbootstudent.service;

import com.student.springbootstudent.entity.dto.request.StudentRequest;
import com.student.springbootstudent.entity.dto.response.StudentResponse;

public interface StudentService {
    StudentResponse save(StudentRequest dto);
    void delete(int studentId);
}
