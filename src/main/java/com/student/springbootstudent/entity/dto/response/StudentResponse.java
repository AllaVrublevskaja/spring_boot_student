package com.student.springbootstudent.entity.dto.response;

import com.student.springbootstudent.entity.Grade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private String nameCourse;
    private int courseId;
    private List<Grade> grades;
}
