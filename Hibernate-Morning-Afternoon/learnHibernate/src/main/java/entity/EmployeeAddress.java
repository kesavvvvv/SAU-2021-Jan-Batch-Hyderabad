package entity;

import javax.persistence.*;

@Entity
public class EmployeeAddress {

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int addressId;

    @Column
    private String streetName;

    @Column
    private String city;

    @Column
    private String pincode;

    @ManyToOne(cascade = CascadeType.ALL)
    private EmployeeData employee;


    public EmployeeAddress(String streetName, String city, String pincode, EmployeeData employee) {
        this.streetName = streetName;
        this.city = city;
        this.pincode = pincode;
        this.employee = employee;
    }
}
