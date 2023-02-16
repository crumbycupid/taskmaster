package com.devonterry.taskmaster;

public class Task {
    private String taskName;
    private String taskDescription;

    public Task(String taskName, String taskDescription){
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(){
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(){
        this.taskDescription = taskDescription;
    }
}
