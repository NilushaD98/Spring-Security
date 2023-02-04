package com.example.springSecurity.student;

public class Student {
    private final int studentID;
    private final String studentName;

    public Student(Integer studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }
}
