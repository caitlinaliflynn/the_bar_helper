package org.launchcode.the_bar_helper.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
public class TodoTasks {

    @Id
    @GeneratedValue
    private int todoTaskId;
    @NotBlank(message = "Name is required.")
    @Size(min = 0, max = 20, message = "Task must be 20 characters or less")
    private String todoTaskName;
    @Size(min = 0, max = 100, message = "Notes must be 100 characters or less.")
    private String todoTaskNotes;
    @NotBlank
    private String desiredCompletionDate;
    private TaskType todoTaskType;

    public TodoTasks() {

    }

    public TodoTasks(String todoTaskName, String todoTaskNotes, String desiredCompletionDate, TaskType todoTaskType) {
        this.todoTaskName = todoTaskName;
        this.todoTaskNotes = todoTaskNotes;
        this.desiredCompletionDate = desiredCompletionDate;
        this.todoTaskType = todoTaskType;
    }

    public int getTodoTaskId() {
        return todoTaskId;
    }

    public String getTodoTaskName() {
        return todoTaskName;
    }

    public void setTodoTaskName(String todoTaskName) {
        this.todoTaskName = todoTaskName;
    }

    public String getTodoTaskNotes() {
        return todoTaskNotes;
    }

    public void setTodoTaskNotes(String todoTaskNotes) {
        this.todoTaskNotes = todoTaskNotes;
    }

    public String getDesiredCompletionDate() {
        return desiredCompletionDate;
    }

    public void setDesiredCompletionDate(String desiredCompletionDate) {
        this.desiredCompletionDate = desiredCompletionDate;
    }

    public TaskType getTodoTaskType() {
        return todoTaskType;
    }

    public void setTodoTaskType(TaskType todoTaskType) {
        this.todoTaskType = todoTaskType;
    }

    @Override
    public String toString() {
        return "TodoTasks{" +
                "todoTaskId=" + todoTaskId +
                ", todoTaskName='" + todoTaskName + '\'' +
                ", todoTaskNotes='" + todoTaskNotes + '\'' +
                ", desiredCompletionDate='" + desiredCompletionDate + '\'' +
                ", todoTaskType=" + todoTaskType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoTasks todoTasks)) return false;
        return getTodoTaskId() == todoTasks.getTodoTaskId() && Objects.equals(getTodoTaskName(), todoTasks.getTodoTaskName()) && Objects.equals(getTodoTaskNotes(), todoTasks.getTodoTaskNotes()) && Objects.equals(getDesiredCompletionDate(), todoTasks.getDesiredCompletionDate()) && getTodoTaskType() == todoTasks.getTodoTaskType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTodoTaskId(), getTodoTaskName(), getTodoTaskNotes(), getDesiredCompletionDate(), getTodoTaskType());
    }
}
