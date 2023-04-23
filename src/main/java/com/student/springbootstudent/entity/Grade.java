package com.student.springbootstudent.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

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

//    @Column(name = "student_id")
//    private int studentId;
//
//    @Column(name = "course_id")
//    private int course_id;
    @ManyToOne
//    @ToString.Exclude
    @JoinColumn(name= "student_id",referencedColumnName = "id")
    private Student student;
    @JsonBackReference
    public Student getStudent(){
        return student;
    }

    @ManyToOne
//    @ToString.Exclude
    @JoinColumn(name= "course_id", referencedColumnName = "id")
    private Course course;
    @JsonBackReference
    public Course getCourse(){
        return course;
    }
    @Column(name = "student_id",insertable=false, updatable=false)
        private int studentId;
    @Column(name = "course_id",insertable=false, updatable=false)
    private int coursetId;

//    @Override
//    public String toString() {
//        return "Grade{ "+
//                student.getName() + " " + student.getSurname() + " " +
//                course.getName() + " " + value + " }";
//    }
}
