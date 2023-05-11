package com.student.springbootstudent.mapper;

import com.student.springbootstudent.entity.Course;
import com.student.springbootstudent.entity.dto.request.CourseRequest;
import com.student.springbootstudent.entity.dto.response.CourseResponse;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course CourseRequestToCourse(CourseRequest courseRequest);
    CourseResponse courseToCourseResponse(Course course);
    List<CourseResponse> coursesToCourseResponses(List<Course> courses);
}

