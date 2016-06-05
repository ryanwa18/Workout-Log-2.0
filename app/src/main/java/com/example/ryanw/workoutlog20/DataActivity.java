package com.example.ryanw.workoutlog20;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class DataActivity extends AppCompatActivity {
    final Context context = this;
    private ArrayList<Workout> workouts = new ArrayList<Workout>();
    private User user;
    private TextView displayProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        createNewUser();
    }

    /**
     * Creates a new user.
     */
    private void createNewUser() {
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.newuser_dialog_layout, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);
        alertDialogBuilder.setView(promptsView);
        displayProfile = (TextView) findViewById(R.id.profileInfo);
        final EditText userInputName = (EditText) promptsView
                .findViewById(R.id.name);
        final EditText userInputFeet = (EditText) promptsView
                .findViewById(R.id.feet);
        final EditText userInputInches = (EditText) promptsView
                .findViewById(R.id.inches);
        final EditText userInputWeight = (EditText) promptsView
                .findViewById(R.id.weightInput);
        final EditText userInputAge = (EditText) promptsView
                .findViewById(R.id.ageInput);
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                if (userInputName.getText().toString().trim().equals("") ||
                                        userInputFeet.getText().toString().trim().equals("") ||
                                        userInputInches.getText().toString().trim().equals("") ||
                                        userInputWeight.getText().toString().trim().equals("") ||
                                        userInputAge.getText().toString().trim().equals("")) {
                                    CharSequence text = "Enter all Information";
                                    int duration = Toast.LENGTH_SHORT;
                                    Toast toast = Toast.makeText(context, text, duration);
                                    toast.show();
                                    createNewUser();
                                } else {
                                    user = new User(userInputName.getText().toString(), Integer.parseInt(userInputFeet.getText().toString()),
                                            Integer.parseInt(userInputInches.getText().toString()), Double.parseDouble(userInputWeight.getText().toString()),
                                            Integer.parseInt(userInputAge.getText().toString()));
                                    DatabaseOperations database = new DatabaseOperations(context);
                                    database.putInformation(database, user);
                                    Snackbar.make(findViewById(android.R.id.content), "New User Created!", Snackbar.LENGTH_LONG)
                                            .setActionTextColor(Color.RED)
                                            .show();
                                    displayProfile.setText(user.toString());
                                    newWorkout();
                                }
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

    /**
     * Creates a workout dialog to add a title and amount of exercises.
     */
    private void createWorkoutDialog() {
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.workout_dialog_layout, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);
        alertDialogBuilder.setView(promptsView);
        final EditText userInputTitle = (EditText) promptsView
                .findViewById(R.id.title);

        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Workout workout = new Workout(userInputTitle.getText().toString());
                                workouts.add(workout);
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void newWorkout()
    {
        final Button addWorkout = (Button) findViewById(R.id.addWorkout);
        addWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createWorkoutDialog();
            }
        });
    }
}

