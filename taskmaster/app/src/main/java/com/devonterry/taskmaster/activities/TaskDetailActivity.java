package com.devonterry.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.devonterry.taskmaster.R;
import com.devonterry.taskmaster.activities.MainActivity;

public class TaskDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
        Intent callingIntent = getIntent();
        String userTaskString;
        if (callingIntent !=null){
            userTaskString = callingIntent.getStringExtra(MainActivity.TASK_ADD_EXTRA_TAG);
            TextView userTaskTextView = (TextView) findViewById(R.id.TaskDetailActivityTextView);
            if (userTaskString != null) {
                userTaskTextView.setText(userTaskString);
            }else {
                userTaskTextView.setText(R.string.no_input);
            }
        }
    }
}