package com.devonterry.taskmaster.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devonterry.taskmaster.R;
import com.devonterry.taskmaster.model.Task;

import java.util.List;

public class TaskRecyclerViewAdapter extends RecyclerView.Adapter <TaskRecyclerViewAdapter.TaskViewHolder>{
    List<Task> taskList;
    public TaskRecyclerViewAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View taskFragment = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_task, parent, false);
        return new TaskViewHolder(taskFragment);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 30;
    }
    public static class  TaskViewHolder extends RecyclerView.ViewHolder{

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
