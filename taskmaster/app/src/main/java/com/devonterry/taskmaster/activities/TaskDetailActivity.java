package com.devonterry.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.devonterry.taskmaster.R;
import com.devonterry.taskmaster.adapter.TaskRecyclerViewAdapter;

public class TaskDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
        consumeExtras();
    }

    public void consumeExtras() {
        Intent callingIntent = getIntent();
        String userTaskTitle = null;
        String userTaskBody = null;
        Enum userTaskState = null;
        if (callingIntent != null) {
            userTaskTitle = callingIntent.getStringExtra(TaskRecyclerViewAdapter.USER_TASK_TITLE_TAG);
            userTaskBody = callingIntent.getStringExtra(TaskRecyclerViewAdapter.USER_TASK_BODY_TAG);
            userTaskState = callingIntent.getStringExtra(TaskRecyclerViewAdapter.USER_TASK_STATE_TAG);
        }
        ((TextView)findViewById(R.id.TaskDetailActivityTVTitle)).setText(userTaskTitle);
        ((TextView)findViewById(R.id.TaskDetailActivityTVBody)).setText(userTaskBody);
        ((TextView)findViewById(R.id.TaskDetailActivityTVState)).setText(userTaskState);
    }
}