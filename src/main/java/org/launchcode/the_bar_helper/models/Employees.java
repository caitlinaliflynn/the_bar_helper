package org.launchcode.the_bar_helper.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employees extends AbstractEntity {

    @NotBlank(message = "First name is required.")
    @Size(min = 0, max = 25, message = "First name must be 50 characters or less.")
    private String employeeFirstName;

    @NotBlank(message = "Last name is required.")
    @Size(min = 0, max = 25, message = "Last name must be 50 characters or less.")
    private String employeeLastName;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    private EmployeeInformation employeeInformation;

    @ManyToMany(mappedBy = "employeeNames")
    private final List<CompletedTasks> completedTasks = new ArrayList<>();

    public Employees() {

    }

    public Employees(String employeeFirstName, String employeeLastName) {
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
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

    public EmployeeInformation getEmployeeInformation() {
        return employeeInformation;
    }

    public void setEmployeeInformation(EmployeeInformation employeeInformation) {
        this.employeeInformation = employeeInformation;
    }

    public List<CompletedTasks> getCompletedTasks() {
        return completedTasks;
    }

    @Override
    public String toString() {
        return employeeFirstName + ' ' + employeeLastName;
    }

}
