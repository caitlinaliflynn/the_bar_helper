package org.launchcode.the_bar_helper.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
public class CompletedTasks {

    @Id
    @GeneratedValue
    private int completedTaskId;
    @NotBlank(message = "Name is required.")
    @Size(min = 0, max = 20, message = "Task must be 20 characters or less")
    private String completedTaskName;
    @Size(min = 0, max = 100, message = "Notes must be 100 characters or less.")
    private String completedTaskNotes;
    @NotBlank(message = "Date completed is required.")
    private String dateCompleted;
    private TaskType completedTaskType;

    private String employeeNames;

    public CompletedTasks() {

    }

    public CompletedTasks(int completedTaskId, String completedTaskName, String completedTaskNotes, String dateCompleted, TaskType completedTaskType, String employeeNames) {
        this.completedTaskId = completedTaskId;
        this.completedTaskName = completedTaskName;
        this.completedTaskNotes = completedTaskNotes;
        this.dateCompleted = dateCompleted;
        this.completedTaskType = completedTaskType;
        this.employeeNames = employeeNames;
    }

    public int getCompletedTaskId() {
        return completedTaskId;
    }

    public void setCompletedTaskId(int completedTaskId) {
        this.completedTaskId = completedTaskId;
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

    public String getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(String dateCompleted) {
        this.dateCompleted = dateCompleted;
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
                "completedTaskId=" + completedTaskId +
                ", completedTaskName='" + completedTaskName + '\'' +
                ", completedTaskNotes='" + completedTaskNotes + '\'' +
                ", dateCompleted='" + dateCompleted + '\'' +
                ", completedTaskType=" + completedTaskType +
                ", employeeNames='" + employeeNames + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompletedTasks that)) return false;
        return getCompletedTaskId() == that.getCompletedTaskId() && Objects.equals(getCompletedTaskName(), that.getCompletedTaskName()) && Objects.equals(getCompletedTaskNotes(), that.getCompletedTaskNotes()) && Objects.equals(getDateCompleted(), that.getDateCompleted()) && getCompletedTaskType() == that.getCompletedTaskType() && Objects.equals(getEmployeeNames(), that.getEmployeeNames());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCompletedTaskId(), getCompletedTaskName(), getCompletedTaskNotes(), getDateCompleted(), getCompletedTaskType(), getEmployeeNames());
    }
}
