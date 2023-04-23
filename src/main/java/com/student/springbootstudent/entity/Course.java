package com.student.springbootstudent.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

//    @Column(name = "student_id",insertable=false, updatable=false)
//    private int studentId;
//
//    @ManyToOne
//    @JoinColumn(name = "student_id",referencedColumnName = "id")
//    private Student student;
    @JsonManagedReference
    @OneToMany(mappedBy = "course")
//    @ToString.Exclude
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JsonIgnore
    private List<Grade> grades;
//    @JsonManagedReference
//    public List<Grade> getGrades(){
//        return grades;
//    }

//    @Override
//    public String toString() {
//        return "Course{" + name + getGrades() + '}';
//    }
}
