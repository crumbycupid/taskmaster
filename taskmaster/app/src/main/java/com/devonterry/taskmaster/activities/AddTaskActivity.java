package com.devonterry.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Task;
import com.amplifyframework.datastore.generated.model.TaskStateEnum;
import com.amplifyframework.datastore.generated.model.Team;
import com.devonterry.taskmaster.R;

public class AddTaskActivity extends AppCompatActivity {
    Spinner taskTypeSpinner;
    Spinner taskTeamSpinner;

    public final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        taskTypeSpinner = findViewById(R.id.AddTaskActivityStateSpinner);
        taskTeamSpinner = findViewById(R.id.AddTaskActivityTeamSpinner);

        Team team1 = Team.builder()
                .name("Red")
                .id("")
                .build();

        Team team2 = Team.builder()
                .name("Green")
                .id("")
                .build();

        Team team3 = Team.builder()
                .name("Blue")
                .id("")
                .build();
        Amplify.API.mutate(
                ModelMutation.create(team1),
                success ->{},
                failure ->{}
        );
        Amplify.API.mutate(
                ModelMutation.create(team2),
                success ->{},
                failure ->{}
        );
        Amplify.API.mutate(
                ModelMutation.create(team3),
                success ->{},
                failure ->{}
        );

        setupSpinners();
        saveButton();
    }

    public void setupSpinners(){
        taskTypeSpinner.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                TaskStateEnum.values()
        ));
    }
    public void saveButton(){
        Button addTaskButton = (Button) findViewById(R.id.AddTaskActivityAddButton);
        addTaskButton.setOnClickListener(v -> {
            Task newTask = Task.builder()
                    .taskTitle(((EditText)findViewById(R.id.AddTaskActivityAddTaskEditTextBox)).getText().toString())
                    .taskBody(((TextView) findViewById(R.id.AddTaskActivityDescriptionTextView)).getText().toString())
                    .taskState((TaskStateEnum)taskTypeSpinner.getSelectedItem())
                    .build();

            Amplify.API.mutate(
                    ModelMutation.create(newTask),
                    success -> Log.i(TAG, "Task created successfully!"),
                    failure -> Log.e(TAG, "FAILED to create task!", failure)
            );
            TextView submittedTextView = (TextView) findViewById(R.id.AddActivitySubmittedTextView);
            submittedTextView.setVisibility(View.VISIBLE);
        });

    }
}