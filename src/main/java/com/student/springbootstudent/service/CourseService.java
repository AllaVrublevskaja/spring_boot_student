package com.student.springbootstudent.service;

import com.student.springbootstudent.entity.dto.request.CourseRequest;
import com.student.springbootstudent.entity.dto.response.CourseResponse;

public interface CourseService {
    CourseResponse save(CourseRequest dto);
    void delete(int courseId);
}
