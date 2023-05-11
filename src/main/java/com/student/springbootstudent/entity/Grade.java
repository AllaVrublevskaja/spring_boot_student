package com.student.springbootstudent.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="Grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "value")
    private int value;

    @Column(name = "student_id",insertable=false, updatable=false)
    private int studentId;

    @Column(name = "course_id",insertable=false, updatable=false)
    private int courseId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name= "student_id",referencedColumnName = "id")
    private Student student;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name= "course_id", referencedColumnName = "id")
    private Course course;
}

