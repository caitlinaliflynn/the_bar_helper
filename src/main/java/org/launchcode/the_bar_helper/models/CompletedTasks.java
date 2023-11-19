package org.launchcode.the_bar_helper.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class CompletedTasks extends AbstractEntity {

    @NotBlank(message = "Name is required.")
    @Size(min = 0, max = 20, message = "Task must be 20 characters or less")
    private String completedTaskName;
    @Size(min = 0, max = 100, message = "Notes must be 100 characters or less.")
    private String completedTaskNotes;
    private String completedTaskDate;
    private TaskType completedTaskType;
    @ManyToMany
    @Valid
    private List<Employees> employeeNames;

    public CompletedTasks() {

    }

    public CompletedTasks(String completedTaskName, String completedTaskNotes, String completedTaskDate, TaskType completedTaskType, List<Employees> employeeNames) {
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

    public List<Employees> getEmployeeNames() {
        return employeeNames;
    }

    public void setEmployeeNames(List<Employees> employeeNames) {
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

    public String getFormattedEmployees() {
        StringBuilder employeeNamesStringBuilder = new StringBuilder("");
        for (int i = 0; i < employeeNames.size(); i++) {
            employeeNamesStringBuilder.append(employeeNames.get(i));
            if (i < employeeNames.size() - 1) {
                employeeNamesStringBuilder.append(", ");
            }
        }
        return employeeNamesStringBuilder.toString();
    }

}
