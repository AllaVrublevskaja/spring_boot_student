package com.student.springbootstudent.entity.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GradeRequest {
    private int id;
    private int value;
    private int studentId;
    private int courseId;
}

