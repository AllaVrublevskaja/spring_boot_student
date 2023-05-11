package com.student.springbootstudent.service.impl;

import com.student.springbootstudent.entity.Course;
import com.student.springbootstudent.entity.dto.request.CourseRequest;
import com.student.springbootstudent.entity.dto.response.CourseResponse;
import com.student.springbootstudent.mapper.CourseMapper;
import com.student.springbootstudent.repository.CourseRepository;
import com.student.springbootstudent.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public CourseResponse save(CourseRequest dto) {
        Course course = courseMapper.CourseRequestToCourse(dto);
        courseRepository.save(course);
        log.info(String.format("Course %s has been successfully created and saved!", course.getId()));
        return courseMapper.courseToCourseResponse(course);
    }

    @Override
    public void delete(int courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new NoSuchElementException(
                        String.format("Course with id %s doesn't exist!", courseId)
                ));
        courseRepository.delete(course);
        course.getGrades().clear();
        log.info(String.format("Course %s has been successfully deleted", courseId));
    }
}
