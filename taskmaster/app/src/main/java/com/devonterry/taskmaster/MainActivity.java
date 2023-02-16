package com.devonterry.taskmaster;

import static com.devonterry.taskmaster.SettingsActivity.USER_USERNAME_TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

//import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static final String TASK_ADD_EXTRA_TAG = "taskDetail";

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

        TextView taskDetailButtonOne = (TextView) findViewById(R.id.MainActivityBudgetButton);
        taskDetailButtonOne.setOnClickListener(v -> {
            String taskDetail = taskDetailButtonOne.getText().toString();
            Intent goToTaskDetailIntent = new Intent(this, TaskDetailActivity.class);
            goToTaskDetailIntent.putExtra(TASK_ADD_EXTRA_TAG, taskDetail);
            startActivity(goToTaskDetailIntent);
        });

        TextView taskDetailButtonTwo = (TextView) findViewById(R.id.MainActivityLearnFrenchButton);
        taskDetailButtonTwo.setOnClickListener(v -> {
            String taskDetail = taskDetailButtonTwo.getText().toString();
            Intent goToTaskDetailIntent = new Intent(this, TaskDetailActivity.class);
            goToTaskDetailIntent.putExtra(TASK_ADD_EXTRA_TAG, taskDetail);
            startActivity(goToTaskDetailIntent);
        });

        TextView taskDetailButtonThree = (TextView) findViewById(R.id.MainActivityWatchYouPeopleButton);
        taskDetailButtonThree.setOnClickListener(v -> {
            String taskDetail = taskDetailButtonThree.getText().toString();
            Intent goToTaskDetailIntent = new Intent(this, TaskDetailActivity.class);
            goToTaskDetailIntent.putExtra(TASK_ADD_EXTRA_TAG, taskDetail);
            startActivity(goToTaskDetailIntent);
        });

    }

    @Override
    protected void  onResume() {

        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String userUserName = preferences.getString(USER_USERNAME_TAG, "No Username");
        ((TextView)findViewById(R.id.MainActivityUserNameTextView)).setText(userUserName + "'s Tasks");
    }
}