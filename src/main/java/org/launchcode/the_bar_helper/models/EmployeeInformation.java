package org.launchcode.the_bar_helper.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class EmployeeInformation extends AbstractEntity {

    private Position employeePosition;

    private String dateOfBirth;

    private String phoneNumber;

    private String address;

    @OneToOne(mappedBy = "employeeInformation")
    private Employees employees;

    public EmployeeInformation(Position employeePosition, String dateOfBirth, String phoneNumber, String address, Employees employees) {
        this.employeePosition = employeePosition;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.employees = employees;
    }

    public EmployeeInformation() {

    }

    public Position getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(Position employeePosition) {
        this.employeePosition = employeePosition;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }
}
