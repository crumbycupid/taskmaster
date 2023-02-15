package com.devonterry.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddTask extends AppCompatActivity {

    public final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        Button addTaskButton = (Button) findViewById(R.id.AddTaskActivityAddButton);
        addTaskButton.setOnClickListener(v -> {
            TextView submittedTextView = (TextView) findViewById(R.id.AddActivitySubmittedTextView);
            submittedTextView.setVisibility(View.VISIBLE);
        Log.e(TAG, "Submitted");
        });
    }
}