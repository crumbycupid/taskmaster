package com.devonterry.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button allTasksButton = (Button) findViewById(R.id.MainActivityAllTasksButton);
        allTasksButton.setOnClickListener(v -> {
            Intent goToAllTasksIntent = new Intent(this, AllTasks.class);
            startActivity(goToAllTasksIntent);
        });

        Button addATaskButton = (Button) findViewById(R.id.MainActivityAddATaskButton);
        addATaskButton.setOnClickListener(v -> {
            Intent goToAddATaskIntent = new Intent(this, AddTask.class);
            startActivity(goToAddATaskIntent);
        });

        ImageButton settingsButton = (ImageButton) findViewById(R.id.MainActivitySettingsButton);
        settingsButton.setOnClickListener(v -> {
            Intent goToSettingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(goToSettingsIntent);
        });


    }
}