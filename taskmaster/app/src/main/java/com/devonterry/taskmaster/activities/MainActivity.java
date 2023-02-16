package com.devonterry.taskmaster.activities;

import static com.devonterry.taskmaster.activities.SettingsActivity.USER_USERNAME_TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.devonterry.taskmaster.R;
import com.devonterry.taskmaster.adapter.TaskRecyclerViewAdapter;
import com.devonterry.taskmaster.model.Task;

import java.util.ArrayList;
import java.util.List;

//import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static final String TASK_ADD_EXTRA_TAG = "taskDetail";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taskRecyclerView();

        Button allTasksButton = (Button) findViewById(R.id.MainActivityAllTasksButton);
        allTasksButton.setOnClickListener(v -> {
            Intent goToAllTasksIntent = new Intent(this, AllTasksActivity.class);
            startActivity(goToAllTasksIntent);
        });

        Button addATaskButton = (Button) findViewById(R.id.MainActivityAddATaskButton);
        addATaskButton.setOnClickListener(v -> {
            Intent goToAddATaskIntent = new Intent(this, AddTaskActivity.class);
            startActivity(goToAddATaskIntent);
        });

        ImageButton settingsButton = (ImageButton) findViewById(R.id.MainActivitySettingsButton);
        settingsButton.setOnClickListener(v -> {
            Intent goToSettingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(goToSettingsIntent);
        });

//        TextView taskDetailButtonOne = (TextView) findViewById(R.id.MainActivityBudgetButton);
//        taskDetailButtonOne.setOnClickListener(v -> {
//            String taskDetail = taskDetailButtonOne.getText().toString();
//            Intent goToTaskDetailIntent = new Intent(this, TaskDetailActivity.class);
//            goToTaskDetailIntent.putExtra(TASK_ADD_EXTRA_TAG, taskDetail);
//            startActivity(goToTaskDetailIntent);
//        });
//
//        TextView taskDetailButtonTwo = (TextView) findViewById(R.id.MainActivityLearnFrenchButton);
//        taskDetailButtonTwo.setOnClickListener(v -> {
//            String taskDetail = taskDetailButtonTwo.getText().toString();
//            Intent goToTaskDetailIntent = new Intent(this, TaskDetailActivity.class);
//            goToTaskDetailIntent.putExtra(TASK_ADD_EXTRA_TAG, taskDetail);
//            startActivity(goToTaskDetailIntent);
//        });
//
//        TextView taskDetailButtonThree = (TextView) findViewById(R.id.MainActivityWatchYouPeopleButton);
//        taskDetailButtonThree.setOnClickListener(v -> {
//            String taskDetail = taskDetailButtonThree.getText().toString();
//            Intent goToTaskDetailIntent = new Intent(this, TaskDetailActivity.class);
//            goToTaskDetailIntent.putExtra(TASK_ADD_EXTRA_TAG, taskDetail);
//            startActivity(goToTaskDetailIntent);
//        });

    }

    public void taskRecyclerView() {
        List<Task> taskList = new ArrayList<>();
    Task task = new Task("Name", "Body");
    Task task2 = new Task("Name", "Body");
    Task task3 = new Task("Name", "Body");
    Task task4 = new Task("Name", "Body");
    Task task5 = new Task("Name", "Body");
    Task task6 = new Task("Name", "Body");
    Task task7 = new Task("Name", "Body");
    Task task8 = new Task("Name", "Body");
    Task task9 = new Task("Name", "Body");
    taskList.add(task);
        taskList.add(task2);
        taskList.add(task3);
        taskList.add(task4);
        taskList.add(task5);
        taskList.add(task6);
        taskList.add(task7);
        taskList.add(task8);
        taskList.add(task9);

        RecyclerView tasksRecyclerView = findViewById(R.id.MainActivityRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        tasksRecyclerView.setLayoutManager(layoutManager);
        TaskRecyclerViewAdapter adapter = new TaskRecyclerViewAdapter(taskList);
        tasksRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void  onResume() {

        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String userUserName = preferences.getString(USER_USERNAME_TAG, "No Username");
        ((TextView)findViewById(R.id.MainActivityUserNameTextView)).setText(userUserName + "'s Tasks");
    }
}