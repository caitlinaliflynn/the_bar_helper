package org.launchcode.the_bar_helper.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class TodoTasks extends AbstractEntity {

    @NotBlank(message = "Name is required.")
    @Size(min = 0, max = 20, message = "Task must be 20 characters or less")
    private String todoTaskName;
    @Size(min = 0, max = 100, message = "Notes must be 100 characters or less.")
    private String todoTaskNotes;
    private String todoTaskDate;
    private TaskType todoTaskType;

    public TodoTasks() {

    }

    public TodoTasks(String todoTaskName, String todoTaskNotes, String todoTaskDate, TaskType todoTaskType) {
        this.todoTaskName = todoTaskName;
        this.todoTaskNotes = todoTaskNotes;
        this.todoTaskDate = todoTaskDate;
        this.todoTaskType = todoTaskType;
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

    public String getTodoTaskDate() {
        return todoTaskDate;
    }

    public void setTodoTaskDate(String todoTaskDate) {
        this.todoTaskDate = todoTaskDate;
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
                ", todoTaskName='" + todoTaskName + '\'' +
                ", todoTaskNotes='" + todoTaskNotes + '\'' +
                ", desiredCompletionDate='" + todoTaskDate + '\'' +
                ", todoTaskType=" + todoTaskType +
                '}';
    }

}
