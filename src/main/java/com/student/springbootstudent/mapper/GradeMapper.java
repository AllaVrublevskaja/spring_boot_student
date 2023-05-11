package com.student.springbootstudent.mapper;

import com.student.springbootstudent.entity.Grade;
import com.student.springbootstudent.entity.dto.request.GradeRequest;
import com.student.springbootstudent.entity.dto.response.GradeResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GradeMapper {
    Grade GradeRequestToGrade(GradeRequest gradeRequest);
    GradeResponse gradeToGradeResponse(Grade grade);
    List<GradeResponse> gradeToGradeResponses(List<Grade> grades);
}

