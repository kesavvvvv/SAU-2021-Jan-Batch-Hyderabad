package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {

    private int StudentId;
    private String StudentName;
    private Date SubmissionTime;

    public Assignment() {}

    public Assignment(int studentId, String studentName, Date submissionTime) {
        this.StudentId = studentId;
        this.StudentName = studentName;
        this.SubmissionTime = submissionTime;
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public Date getSubmissionTime() {
        return SubmissionTime;
    }

    public void setSubmissionTime(Date submissionTime) {
        SubmissionTime = submissionTime;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "StudentId=" + StudentId +
                ", StudentName='" + StudentName + '\'' +
                ", SubmissionTime=" + SubmissionTime +
                '}';
    }
}
