package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class EmployeeDetails implements Serializable {
    @Column
    private String phoneNo;

    @Column
    private String email;

    @OneToOne
    @Id
    @MapsId
    private EmployeeData employee;

    public EmployeeDetails(String phoneNo, String email, EmployeeData employee) {
        this.phoneNo = phoneNo;
        this.email = email;
        this.employee = employee;
    }
}
