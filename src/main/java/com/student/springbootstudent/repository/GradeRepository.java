package com.student.springbootstudent.repository;

import com.student.springbootstudent.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Integer> {
    List<Grade> findAllByValue(int value);
    List<Grade> findAllByStudentId(int studentId);
    List<Grade> findAllByCourseId(int courseId);
}
