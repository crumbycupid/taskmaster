package com.devonterry.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Task;
import com.amplifyframework.datastore.generated.model.Team;
import com.devonterry.taskmaster.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SettingsActivity extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String USER_USERNAME_TAG = "userUsername";
    public static final String CHOOSE_TEAM_TAG = "ChooseTeam";
    public static final String TAG = "SettingsActivity";
    CompletableFuture<List<Team>> taskTeamFuture = new CompletableFuture<>();
    Spinner teamSpinner;
    ArrayList<String> teamNames;
    ArrayList<Team> taskTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
//        teamSpinner = findViewById(R.id.AddTaskActivityTeamSpinner);
        teamNames = new ArrayList<>();
        taskTeam = new ArrayList<>();

        Amplify.API.query(
                ModelQuery.list(Team.class),
                success -> {
                    Log.i(TAG, "Read Team successfully!");
                    for (Team databaseTeam : success.getData()) {
                        teamNames.add(databaseTeam.getName());
                        taskTeam.add(databaseTeam);
                    }
                    taskTeamFuture.complete(taskTeam);
//                    runOnUiThread(this::);
                },
                failure -> {
                    taskTeamFuture.complete(null);
                    Log.e(TAG, "Failed to read TaskTeam", failure);
                }
        );

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        String userName = preferences.getString(USER_USERNAME_TAG, "No name found");
        EditText userUserNameEditText = findViewById(R.id.SettingsActivityNameInputTextView);
        userUserNameEditText.setText(userName);
        setupSaveButton();
    }
//    public void setupTaskSpinner() {
//
//    }


    public void setupSaveButton() {

        Button saveButton = findViewById(R.id.SettingsActivitySaveButton);
        saveButton.setOnClickListener(v -> {
            EditText editUsernameText = findViewById(R.id.SettingsActivityNameInputTextView);
            String selectedTaskTeamStringName = teamSpinner.getSelectedItem().toString();
            SharedPreferences.Editor preferencesEditor = preferences.edit();
//            String userUsernameString = userUsernameEditText.getText().toString();

//            preferencesEditor.putString(USER_USERNAME_TAG, userUsernameString);
            preferencesEditor.putString(CHOOSE_TEAM_TAG, selectedTaskTeamStringName);
            preferencesEditor.apply();

            Snackbar.make(findViewById(R.id.settingsActivity), "Settings Saved", Snackbar.LENGTH_SHORT).show();


        });
    }
    }
}