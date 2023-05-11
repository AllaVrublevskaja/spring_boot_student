package com.student.springbootstudent.mapper;

import com.student.springbootstudent.entity.Student;
import com.student.springbootstudent.entity.dto.request.StudentRequest;
import com.student.springbootstudent.entity.dto.response.StudentResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student StudentRequestToStudent(StudentRequest studentRequest);
    StudentResponse studentToStudentResponse(Student student);
    List<StudentResponse> studentToStudentResponses(List<Student> students);
}

