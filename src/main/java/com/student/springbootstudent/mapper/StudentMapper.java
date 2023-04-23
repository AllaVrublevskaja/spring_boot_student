package com.student.springbootstudent.mapper;

import com.student.springbootstudent.entity.Student;
import com.student.springbootstudent.entity.dto.request.StudentRequest;
import com.student.springbootstudent.entity.dto.response.StudentResponse;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student StudentRequestToStudent(StudentRequest studentRequest);

    @Mapping(source = "course.name", target = "nameCourse")
    @Mapping(source = "course.id",target = "courseId")

    StudentResponse studentToStudentResponse(Student student);

    List<StudentResponse> commentsToCommentResponses(List<Student> students);
}
