package org.launchcode.the_bar_helper.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
public class Employees extends AbstractEntity {

    @NotBlank(message = "First name is required.")
    @Size(min = 0, max = 25, message = "First name must be 50 characters or less.")
    private String employeeFirstName;

    @NotBlank(message = "Last name is required.")
    @Size(min = 0, max = 25, message = "Last name must be 50 characters or less.")
    private String employeeLastName;

    private Position employeePosition;

    private String dateOfBirth;

    public Employees() {

    }

    public Employees(String employeeFirstName, String employeeLastName, Position employeePosition, String dateOfBirth) {
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeePosition = employeePosition;
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
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

    @Override
    public String toString() {
        return employeeFirstName + ' ' + employeeLastName;
    }

}
