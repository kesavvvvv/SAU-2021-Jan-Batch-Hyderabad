package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

    private long StudentId;
    private String StudentName;
    private String StudentClass;

    public Student(){ }

    public Student(long studentId, String studentName, String StudentClass){
        this.StudentId = studentId;
        this.StudentName = studentName;
        this.StudentClass = StudentClass;
    }

    public long getStudentId() {
        return StudentId;
    }

    public void setStudentId(long studentId) {
        StudentId = studentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getStudentClass() {
        return StudentClass;
    }

    public void setStudentClass(String studentClass) {
        StudentClass = studentClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "StudentId=" + StudentId +
                ", StudentName='" + StudentName + '\'' +
                ", StudentClass='" + StudentClass + '\'' +
                '}';
    }
}
