package org.launchcode.the_bar_helper.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class CompletedTasks extends AbstractEntity {

    @NotBlank(message = "Name is required.")
    @Size(min = 0, max = 20, message = "Task must be 20 characters or less")
    private String completedTaskName;
    @Size(min = 0, max = 100, message = "Notes must be 100 characters or less.")
    private String completedTaskNotes;
    private String completedTaskDate;
    private TaskType completedTaskType;

    private String employeeNames;

    public CompletedTasks() {

    }

    public CompletedTasks(String completedTaskName, String completedTaskNotes, String completedTaskDate, TaskType completedTaskType, String employeeNames) {
        this.completedTaskName = completedTaskName;
        this.completedTaskNotes = completedTaskNotes;
        this.completedTaskDate = completedTaskDate;
        this.completedTaskType = completedTaskType;
        this.employeeNames = employeeNames;
    }

    public String getCompletedTaskName() {
        return completedTaskName;
    }

    public void setCompletedTaskName(String completedTaskName) {
        this.completedTaskName = completedTaskName;
    }

    public String getCompletedTaskNotes() {
        return completedTaskNotes;
    }

    public void setCompletedTaskNotes(String completedTaskNotes) {
        this.completedTaskNotes = completedTaskNotes;
    }

    public String getCompletedTaskDate() {
        return completedTaskDate;
    }

    public void setCompletedTaskDate(String completedTaskDate) {
        this.completedTaskDate = completedTaskDate;
    }

    public TaskType getCompletedTaskType() {
        return completedTaskType;
    }

    public void setCompletedTaskType(TaskType completedTaskType) {
        this.completedTaskType = completedTaskType;
    }

    public String getEmployeeNames() {
        return employeeNames;
    }

    public void setEmployeeNames(String employeeNames) {
        this.employeeNames = employeeNames;
    }

    @Override
    public String toString() {
        return "CompletedTasks{" +
                ", completedTaskName='" + completedTaskName + '\'' +
                ", completedTaskNotes='" + completedTaskNotes + '\'' +
                ", dateCompleted='" + completedTaskDate + '\'' +
                ", completedTaskType=" + completedTaskType +
                ", employeeNames='" + employeeNames + '\'' +
                '}';
    }

}
