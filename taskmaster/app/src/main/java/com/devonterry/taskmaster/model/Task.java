package com.devonterry.taskmaster.model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Task {

    @PrimaryKey(autoGenerate = true)
    public Long id;
    private String taskTitle;
    private String taskBody;
    private TaskStateEnum taskState;


    public Task(String taskTitle, String taskBody, TaskStateEnum taskState){
        this.taskTitle = taskTitle;
        this.taskBody = taskBody;
        this.taskState = taskState;
    }

    public TaskStateEnum getTaskState() {return taskState;}

    public Long getId() {return id;}

    public String getTaskTitle() {return taskTitle;}

    public void setTaskTitle(){this.taskTitle = taskTitle;}

    public String getTaskBody() {
        return taskBody;
    }

    public void setTaskBody(){
        this.taskBody = taskBody;
    }

    public void setTaskState(TaskStateEnum taskState) { this.taskState = taskState; }

    public enum TaskStateEnum{
        NEW("New"),
        ASSIGNED("Assigned"),
        IN_PROGRESS("In Progress"),
        COMPLETE("Complete");

        private final String taskState;

        TaskStateEnum(String taskState) {
            this.taskState = taskState;
        }

        public static TaskStateEnum fromString(String possibleTaskStateTypes){
            for (TaskStateEnum state: TaskStateEnum.values()){
                if (state.taskState.equals(possibleTaskStateTypes)){
                    return state;
                }
            }
            return null;
        }

        @Override
        public String toString(){
            return "TaskStateEnum{" +
                    "taskState='" + taskState + '\'' +
                    '}';
        }
    }
}
