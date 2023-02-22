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
import com.devonterry.taskmaster.R;

public class AddTaskActivity extends AppCompatActivity {
    Spinner taskTypeSpinner;

    public final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        taskTypeSpinner = findViewById(R.id.AddTaskActivityStateSpinner);
        taskTypeSpinner();
        saveButton();
    }

    public void taskTypeSpinner(){
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