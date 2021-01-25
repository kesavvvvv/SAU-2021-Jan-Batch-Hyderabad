package entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Entity
@NoArgsConstructor
public class EmployeeData {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<EmployeeAddress> EmpAddress = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Emp_Course", joinColumns = @JoinColumn(name = "EmpId"), inverseJoinColumns = @JoinColumn(name="Course_Id"))
    private Collection<EmployeeCourse> course = new HashSet<>();

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<EmployeeAddress> getEmpAddress() {
        return EmpAddress;
    }

    public void setEmpAddress(List<EmployeeAddress> empAddress) {
        this.EmpAddress = empAddress;
    }

    public Collection<EmployeeCourse> getCourse() {
        return course;
    }

    public void setCourse(Collection<EmployeeCourse> course) {
        this.course = course;
    }

    public EmployeeData(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
