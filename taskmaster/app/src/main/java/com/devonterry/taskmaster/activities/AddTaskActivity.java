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
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Task;
import com.amplifyframework.datastore.generated.model.TaskStateEnum;
import com.amplifyframework.datastore.generated.model.Team;
import com.devonterry.taskmaster.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AddTaskActivity extends AppCompatActivity {
    public final String TAG = "addTaskActivity";
    Spinner taskTypeSpinner;
    Spinner taskTeamSpinner;
    CompletableFuture<List<Team>> taskTeamFuture = new CompletableFuture<>();
    ArrayList<String> teamNames;
    ArrayList<Team> teams;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        taskTypeSpinner = findViewById(R.id.AddTaskActivityStateSpinner);
        taskTeamSpinner = findViewById(R.id.AddTaskActivityTeamSpinner);

        teamNames = new ArrayList<>();
        taskTeam = new ArrayList<>();

        //CompletableFuture
        Amplify.API.query(
                ModelQuery.list(Team.class),
                success -> {
                    Log.i(TAG, "Read Team successfully!");
                    for (Team databaseTeam : success.getData()){
                    teamNames.add(databaseTeam.getName());
                    teams.add(databaseTeam);
                }
                    taskTeamFuture.complete(teams);
                    runOnUiThread(this::);
        )

//        Team team1 = Team.builder()
//                .name("Red")
//                .id("")
//                .build();
//
//        Team team2 = Team.builder()
//                .name("Green")
//                .id("")
//                .build();
//
//        Team team3 = Team.builder()
//                .name("Blue")
//                .id("")
//                .build();
//        Amplify.API.mutate(
//                ModelMutation.create(team1),
//                success ->{},
//                failure ->{}
//        );
//        Amplify.API.mutate(
//                ModelMutation.create(team2),
//                success ->{},
//                failure ->{}
//        );
//        Amplify.API.mutate(
//                ModelMutation.create(team3),
//                success ->{},
//                failure ->{}
//        );

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
    findViewById(R.id.AddTaskActivityAddButton).setOnClickListener(v -> {
            String selectedTaskTeamName = taskTeamSpinner.getSelectedItem().toString();
            try {
                teams = (ArrayList<Team>) taskTeamFuture.get();
            }catch (InterruptedException ie){
                ie.printStackTrace();
            } catch (ExecutionException ee){
                ee.printStackTrace();
            }

            Team selectedTeam = teams.stream().filter(team -> team.getName().equals(selectedTaskTeamName)).findAny().orElseThrow(RuntimeException::new);
            Task newTask = Task.builder()
                    .taskTitle(((EditText)findViewById(R.id.AddTaskActivityAddTaskEditTextBox)).getText().toString())
                    .taskBody(((TextView) findViewById(R.id.AddTaskActivityDescriptionTextView)).getText().toString())
                    .taskState((TaskStateEnum)taskTypeSpinner.getSelectedItem())
                    .team(selectedTeam)
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