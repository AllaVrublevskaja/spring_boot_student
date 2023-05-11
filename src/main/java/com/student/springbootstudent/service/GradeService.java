package com.student.springbootstudent.service;

import com.student.springbootstudent.entity.dto.request.GradeRequest;
import com.student.springbootstudent.entity.dto.response.GradeResponse;

public interface GradeService {
    GradeResponse save(GradeRequest dto);
    void delete(int gradeId);
}
