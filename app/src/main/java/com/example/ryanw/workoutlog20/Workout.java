package com.example.ryanw.workoutlog20;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ryanw on 2/26/2016.
 */
public class Workout
{
    private String title;
    private ArrayList<Exercise> exercises;
    /**
     * Constructor for a Workout.
     * @param title the title of the workout.
     */
    public Workout(String title)
    {
        this.title = title;
        exercises = new ArrayList<Exercise>();
    }

    /**
     * Adds an exercise to the Workout.
     * @param exercise the exercise being added.
     */
    public void addExercise(Exercise exercise)
    {
        exercises.add(exercise);
    }

    /**
     * Removes an exercise from the Workout.
     * @param exercise the exercise being removed.
     */
    public void removeExercise(Exercise exercise)
    {
        exercises.remove(exercise);
    }

    /**
     * Returns the exercises in the Workout.
     * @return the exercises in the Workout.
     */
    public ArrayList<Exercise> getExercises()
    {
        return exercises;
    }

    public Exercise getLastExercise()
    {
        if (!exercises.isEmpty())
        {
            return exercises.get(exercises.size() - 1);
        }
        return null;
    }
    public String toString()
    {
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        return title + " - " + currentDateTimeString;
    }
}
