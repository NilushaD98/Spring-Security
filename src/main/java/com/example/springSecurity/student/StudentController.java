package com.example.springSecurity.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1,"James"),
            new Student(2,"maria"),
            new Student(3,"anna")
    );

    @GetMapping(path = "/{studentID}")
    public Student getStudent(@PathVariable(value = "studentID")Integer studentID){
    return STUDENTS.stream()
            .filter(student -> studentID.equals(student.getStudentID()))
            .findFirst()
            .orElseThrow(()-> new IllegalStateException("Student" +studentID+"does not exists"));
    }
}
