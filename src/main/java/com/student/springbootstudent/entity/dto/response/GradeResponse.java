package com.student.springbootstudent.entity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GradeResponse {
    private int id;
    private int value;
    private int studentId;
    private int courseId;
}

