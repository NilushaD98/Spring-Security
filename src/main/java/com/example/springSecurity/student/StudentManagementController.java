package com.example.springSecurity.student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "management/api/v1/students")
public class StudentManagementController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1,"James"),
            new Student(2,"maria"),
            new Student(3,"anna")
    );

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
    public static List<Student> getAllSTUDENTS() {
        return STUDENTS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('course:write')")
    public void registerStudent(Student student){
        System.out.println(student);
    }
    @DeleteMapping
    @PreAuthorize("hasAuthority('course:write')")
    public void deleteStudent(Integer studentID){
        System.out.println(studentID);
    }
    @PutMapping
    @PreAuthorize("hasAuthority('course:write')")
    public void updateStudent(Integer studentID,Student student){
        System.out.println(String.format("%s %s",student,student));
    }
}
