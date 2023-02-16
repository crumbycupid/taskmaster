package com.devonterry.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;

import com.devonterry.taskmaster.R;
import com.google.android.material.snackbar.Snackbar;

public class SettingsActivity extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String USER_USERNAME_TAG = "userUsername";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        String userName = preferences.getString(USER_USERNAME_TAG, "No name found");
        EditText userUserNameEditText = (EditText) findViewById(R.id.SettingsActivityNameInputTextView);
        userUserNameEditText.setText(userName);


        Button saveButton = findViewById(R.id.SettingsActivitySaveButton);
        saveButton.setOnClickListener(v -> {
            SharedPreferences.Editor preferencesEditor = preferences.edit();
        String userUsernameString = userUserNameEditText.getText().toString();

        preferencesEditor.putString(USER_USERNAME_TAG, userUsernameString);
        preferencesEditor.apply();

        Snackbar.make(findViewById(R.id.settingsActivity), "Settings Saved", Snackbar.LENGTH_SHORT).show();


        });
    }
}