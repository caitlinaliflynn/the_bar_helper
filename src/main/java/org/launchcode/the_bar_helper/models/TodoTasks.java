package org.launchcode.the_bar_helper.models;

import jakarta.persistence.Entity;

@Entity
public class TodoTasks extends AbstractEntity {

    private TaskType type;

    public TodoTasks() {

    }

    public TodoTasks(TaskType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TodoTasks{" +
                "type=" + type +
                '}';
    }
}
