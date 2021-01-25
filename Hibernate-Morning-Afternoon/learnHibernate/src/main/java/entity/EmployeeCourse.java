package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class EmployeeCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    private  String courseName;

    @ManyToMany(mappedBy = "course")
    private List<EmployeeData> employee = new ArrayList<>();

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<EmployeeData> getEmployee() {
        return employee;
    }

    public void setEmployee(List<EmployeeData> employee) {
        this.employee = employee;
    }
    public EmployeeCourse(String course){
        this.courseName = course;
    }
}
