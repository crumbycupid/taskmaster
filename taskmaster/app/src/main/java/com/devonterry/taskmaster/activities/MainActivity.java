package com.devonterry.taskmaster.activities;

import static com.devonterry.taskmaster.activities.SettingsActivity.USER_USERNAME_TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.devonterry.taskmaster.R;
import com.devonterry.taskmaster.adapter.TaskRecyclerViewAdapter;
import com.devonterry.taskmaster.database.TaskMasterDatabase;
import com.devonterry.taskmaster.model.Task;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    TaskMasterDatabase taskMasterDatabase;
    public static final String DATABASE_NAME = "task_master";
    List<Task> taskList;
    TaskRecyclerViewAdapter adapter;
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskMasterDatabase = Room.databaseBuilder(
                        getApplicationContext(),
                        TaskMasterDatabase.class,
                        DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        taskList = taskMasterDatabase.taskDao().findAll();
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
    }
    public void taskRecyclerView() {
        RecyclerView tasksRecyclerView = findViewById(R.id.MainActivityRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        tasksRecyclerView.setLayoutManager(layoutManager);
        adapter = new TaskRecyclerViewAdapter(taskList, this);
        tasksRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void  onResume() {

        super.onResume();
        taskList.clear();
        taskList.addAll(taskMasterDatabase.taskDao().findAll());
        String userUserName = preferences.getString(USER_USERNAME_TAG, "No Username");
        ((TextView)findViewById(R.id.MainActivityUserNameTextView)).setText(userUserName + "'s Tasks");
        adapter.notifyDataSetChanged();
    }
}


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

