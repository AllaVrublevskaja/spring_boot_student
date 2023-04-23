package com.student.springbootstudent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
Создайте новый проект Spring Boot.

Создайте сущности "Студент" (Student), "Курс" (Course) и "Оценка" (Grade).

   Сущность "Студент" должна содержать поля "id", "имя" (name), "фамилия" (surname) и "курсы" (courses) - список курсов,
на которые записан студент.
   Сущность "Курс" должна содержать поля "id", "название" (name) и "студенты" (students)
 - список студентов, записанных на курс.
   Сущность "Оценка" должна содержать поля "id", "оценка" (value), "студент" (student)
и "курс" (course).

   Создайте репозитории для каждой из сущностей с использованием Spring Data JPA.

    Создайте контроллеры, которые будут принимать HTTP-запросы и использовать
методы репозиториев для работы с базой данных.

    Реализуйте простое приложение, которое позволит добавлять, удалять и просматривать
информацию о студентах, курсах и оценках.

    Контроллеры должны отдавать и принимать данные в формате JSON.
 */

@SpringBootApplication
public class SpringBootStudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStudentApplication.class, args);
    }

}
