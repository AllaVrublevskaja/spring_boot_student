package com.student.springbootstudent.repository;

import com.student.springbootstudent.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepositotry extends JpaRepository<Student, Integer> {
    List<Student> findAllByName(String name);
    List<Student> findAllBySurname(String surname);
    List<Student> findAllByNameAndSurname(String name,String surname);
}
