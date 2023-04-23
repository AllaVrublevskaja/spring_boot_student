package com.student.springbootstudent.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;
    @JsonManagedReference
    @OneToMany(mappedBy = "student")
//    @ToString.Exclude
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
//    @JsonIgnore
    private List<Grade> grades=new ArrayList<>();
//    @JsonManagedReference
//    public List<Grade> getGrades(){
//        return grades.stream().collect(Collectors.toList());

//    }

//    @Override
//    public String toString() {
//        return "Student{" +
//                name + ' ' + surname + " "+ getGrades()+
//        '}';
//    }
}
