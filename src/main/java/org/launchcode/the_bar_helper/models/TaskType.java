package org.launchcode.the_bar_helper.models;

public enum TaskType {
    CLEANING("Cleaning"),
    STOCKING("Stocking"),
    ROTATING("Rotating"),
    ORDERING("Ordering"),
    MISCELLANEOUS("Miscellaneous");

    private final String taskTypeDisplayName;

    TaskType(String taskTypeDisplayName) {
        this.taskTypeDisplayName = taskTypeDisplayName;
    }

    public String getTaskTypeDisplayName() {
        return taskTypeDisplayName;
    }
}
