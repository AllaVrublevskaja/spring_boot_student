package com.student.springbootstudent.repository;

import com.student.springbootstudent.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findAllByName(String name);

}
