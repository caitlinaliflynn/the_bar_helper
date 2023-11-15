package org.launchcode.the_bar_helper.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class EmployeeInformation extends AbstractEntity {

    private Position employeePosition;

    private String dateOfBirth;

    @OneToOne(mappedBy = "employeeInformation")
    private Employees employees;

    public EmployeeInformation(Position employeePosition, String dateOfBirth) {
        this.employeePosition = employeePosition;
        this.dateOfBirth = dateOfBirth;
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
}
