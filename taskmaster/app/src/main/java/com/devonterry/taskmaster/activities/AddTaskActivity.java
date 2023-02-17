package com.devonterry.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.devonterry.taskmaster.R;
import com.devonterry.taskmaster.database.TaskMasterDatabase;
import com.devonterry.taskmaster.model.Task;

public class AddTaskActivity extends AppCompatActivity {
    TaskMasterDatabase taskMasterDatabase;
    Spinner taskTypeSpinner;

//    public final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        taskTypeSpinner = findViewById(R.id.AddTaskActivityStateSpinner);
        taskMasterDatabase =  Room.databaseBuilder(
                        getApplicationContext(),
                        TaskMasterDatabase.class,
                        MainActivity.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
        taskTypeSpinner();
        saveButton();
    }

    public void taskTypeSpinner(){
        taskTypeSpinner.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                Task.TaskStateEnum.values()
        ));
    }
    public void saveButton(){
        Button addTaskButton = (Button) findViewById(R.id.AddTaskActivityAddButton);
        addTaskButton.setOnClickListener(v -> {
            TextView submittedTextView = (TextView) findViewById(R.id.AddActivitySubmittedTextView);
            submittedTextView.setVisibility(View.VISIBLE);
        });

    }
}