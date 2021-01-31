package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    private int TeacherId;
    private String TeacherName;
    private String TeacherDesg;

    public Teacher() {}
    public Teacher(int teacherId, String teacherName, String teacherDesg) {
        this.TeacherId = teacherId;
        this.TeacherName = teacherName;
        this.TeacherDesg = teacherDesg;
    }

    public int getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(int teacherId) {
        TeacherId = teacherId;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    public String getTeacherDesg() {
        return TeacherDesg;
    }

    public void setTeacherDesg(String teacherDesg) {
        TeacherDesg = teacherDesg;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "TeacherId=" + TeacherId +
                ", TeacherName='" + TeacherName + '\'' +
                ", TeacherDesg='" + TeacherDesg + '\'' +
                '}';
    }
}
