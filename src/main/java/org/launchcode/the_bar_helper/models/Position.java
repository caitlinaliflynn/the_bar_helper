package org.launchcode.the_bar_helper.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Position extends AbstractEntity {

    @Size(min = 3, message = "Position must be at least 3 characters long.")
    private String name;

    @OneToMany(mappedBy = "employeePosition")
    private final List<EmployeeInformation> employeeInformationList = new ArrayList<>();

    public Position(String name) {
        this.name = name;
    }

    public Position() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmployeeInformation> getEmployeeInformationList() {
        return employeeInformationList;
    }

    @Override
    public String toString() {
        return name;
    }
}
