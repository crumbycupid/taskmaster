package com.devonterry.taskmaster.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devonterry.taskmaster.R;
import com.devonterry.taskmaster.activities.TaskDetailActivity;
import com.devonterry.taskmaster.model.Task;

import java.util.List;

public class TaskRecyclerViewAdapter extends RecyclerView.Adapter <TaskRecyclerViewAdapter.TaskViewHolder>{
    public static final String USER_TASK_TITLE_TAG = "task_title";
    public static final String USER_TASK_BODY_TAG = "task_body";
    public static final String USER_TASK_STATE_TAG = "task_state";

    Context callingActivity;

    List<Task> taskList;
    public TaskRecyclerViewAdapter(List<Task> taskList, Context callingActivity) {
        this.taskList = taskList;
        this.callingActivity = callingActivity;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View taskFragment = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_task, parent, false);
        return new TaskViewHolder(taskFragment);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        TextView taskFragNameView = holder.itemView.findViewById(R.id.TaskFragTVTitle);
        TextView taskFragBodyView = holder.itemView.findViewById(R.id.TaskFragTVBody);
        TextView taskFragStateView = holder.itemView.findViewById((R.id.TaskFragTVState));
        String taskTitle = taskList.get(position).getTaskTitle();
        String taskBody = taskList.get(position).getTaskBody();
        String taskState = taskList.get(position).getTaskState();
        taskFragNameView.setText(taskTitle);
        taskFragBodyView.setText(taskBody);
        taskFragStateView.setText(taskState);
        View userTaskViewHolder = holder.itemView;
        userTaskViewHolder.setOnClickListener(v ->{
            Intent goToUserTasksDetailsIntent = new Intent(callingActivity, TaskDetailActivity.class);
            goToUserTasksDetailsIntent.putExtra(USER_TASK_TITLE_TAG, taskTitle);
            goToUserTasksDetailsIntent.putExtra(USER_TASK_BODY_TAG, taskBody);
            goToUserTasksDetailsIntent.putExtra(USER_TASK_STATE_TAG, taskState);
            callingActivity.startActivity(goToUserTasksDetailsIntent);
        });
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
    public static class  TaskViewHolder extends RecyclerView.ViewHolder{

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
