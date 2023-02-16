package com.devonterry.taskmaster.model;

import java.util.List;

public class Task {
    private String taskName;
    private String body;

    public Task(String taskName, String body){
        this.taskName = taskName;
        this.body = body;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(){
        this.taskName = taskName;
    }

    public String getBody() {
        return body;
    }

    public void setBody(){
        this.body = body;
    }
}
