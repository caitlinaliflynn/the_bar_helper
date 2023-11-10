package org.launchcode.the_bar_helper.models;

import jakarta.persistence.Entity;

@Entity
public class CompletedTasks extends AbstractEntity {

    private String employeeNames;

    private TaskType completeTaskType;

    public CompletedTasks(String employeeNames, TaskType completeTaskType) {
        this.employeeNames = employeeNames;
        this.completeTaskType = completeTaskType;
    }

    public CompletedTasks() {

    }

    public String getEmployeeNames() {
        return employeeNames;
    }

    public void setEmployeeNames(String employeeNames) {
        this.employeeNames = employeeNames;
    }

    public TaskType getCompleteTaskType() {
        return completeTaskType;
    }

    public void setCompleteTaskType(TaskType completeTaskType) {
        this.completeTaskType = completeTaskType;
    }

    @Override
    public String toString() {
        return employeeNames;
    }

}
