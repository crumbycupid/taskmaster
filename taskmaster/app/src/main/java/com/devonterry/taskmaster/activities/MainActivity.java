package com.devonterry.taskmaster.activities;

//import static com.devonterry.taskmaster.activities.SettingsActivity.USER_USERNAME_TAG;
import static com.devonterry.taskmaster.activities.SettingsActivity.CHOOSE_TEAM_TAG;
import static com.devonterry.taskmaster.activities.SettingsActivity.USER_USERNAME_TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Task;
import com.amplifyframework.datastore.generated.model.TaskStateEnum;
import com.devonterry.taskmaster.R;
import com.devonterry.taskmaster.adapter.TaskRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    public static final String TAG = "mainActivity";
    List<Task> taskList;
    TaskRecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Amplify.API.query(
//                ModelQuery.list(Task.class),
//                success -> {
//                    taskList.clear();
//                    Log.i(TAG, "Read Tasks successfully!");
//                    for (Task databaseSuperPet : success.getData()) {
//                        taskList.add(databaseSuperPet);
//                    }
//                    runOnUiThread(() -> adapter.notifyDataSetChanged()); // since this runs asynchronously, the adapter may already have rendered, so we have to tell it to update
//                },
//                failure -> Log.e(TAG, "FAILED to read Tasks from the Database")
//        );
//        Hardcoded Task Data
//        taskList = new ArrayList<>();
//        Task newTask = Task.builder()
//                .taskTitle("run")
//                        .taskBody("run")
//                .taskState(TaskStateEnum.Assigned)
//                        .build();
//        taskList.add(newTask);

        taskRecyclerView();
        setupBttns();

    }
    @Override
    protected void  onResume() {

        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String teamChosen = preferences.getString(CHOOSE_TEAM_TAG, "no team chosen");
        Amplify.API.query(
                ModelQuery.list(Task.class),
                success -> {
                    taskList.clear();
                    Log.i(TAG, "Read Tasks successfully!");
                    for (Task databaseTask : success.getData()) {
                        String selectedTaskTeamStringName = teamChosen;
                        if (databaseTask.getTeam() !=null) {
                            if (databaseTask.getTeam().getName().equals(selectedTaskTeamStringName))
                                taskList.add(databaseTask);
                        }
                    }
                    runOnUiThread(() -> adapter.notifyDataSetChanged()); // since this runs asynchronously, the adapter may already have rendered, so we have to tell it to update
                },
                failure -> Log.e(TAG, "FAILED to read Tasks from the Database")
        );

        String userUserName = preferences.getString(USER_USERNAME_TAG, "No Username");
        ((TextView)findViewById(R.id.MainActivityUserNameTextView)).setText(userUserName + "'s Tasks");
//        adapter.notifyDataSetChanged();
    }
    public void taskRecyclerView() {
        taskList = new ArrayList<>();
        RecyclerView tasksRecyclerView = findViewById(R.id.MainActivityRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        tasksRecyclerView.setLayoutManager(layoutManager);
        adapter = new TaskRecyclerViewAdapter(taskList, this);
        tasksRecyclerView.setAdapter(adapter);
    }

    public void setupBttns() {
        Button allTasksButton = findViewById(R.id.MainActivityAllTasksButton);
        allTasksButton.setOnClickListener(v -> {
            Intent goToAllTasksIntent = new Intent(this, AllTasksActivity.class);
            startActivity(goToAllTasksIntent);
        });

        Button addATaskButton = findViewById(R.id.MainActivityAddATaskButton);
        addATaskButton.setOnClickListener(v -> {
            Intent goToAddATaskIntent = new Intent(this, AddTaskActivity.class);
            startActivity(goToAddATaskIntent);
        });

        ImageButton settingsButton = findViewById(R.id.MainActivitySettingsButton);
        settingsButton.setOnClickListener(v -> {
            Intent goToSettingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(goToSettingsIntent);
        });
    }
}


