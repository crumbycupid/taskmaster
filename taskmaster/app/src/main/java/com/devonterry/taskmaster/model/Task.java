package com.devonterry.taskmaster.model;

import java.util.List;

public class Task {
    private String taskTitle;
    private String taskBody;
    private String taskState;

    public Task(String taskTitle, String taskBody, String taskState){
        this.taskTitle = taskTitle;
        this.taskBody = taskBody;
        this.taskState = taskState;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(){
        this.taskTitle = taskTitle;
    }

    public String getTaskBody() {
        return taskBody;
    }

    public void setTaskBody(){
        this.taskBody = taskBody;
    }

    public String getTaskState(){ return taskState; }

    public void setTaskState() { this.taskState = taskState; }
}
