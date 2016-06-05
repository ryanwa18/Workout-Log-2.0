package com.example.ryanw.workoutlog20;

import java.util.ArrayList;

/**
 * Created by ryanw on 2/26/2016.
 */
public class Exercise
{
    private String title;
    private ArrayList<ExerciseSet> sets;

    /**
     * Constructor for an Exercise.
     * @param title the name of the exercise.
     */
    public Exercise(String title)
    {
        this.title = title;
        sets = new ArrayList<ExerciseSet>();
    }

    /**
     * Adds a new set to the exercise.
     * @param reps the amount of reps in the set.
     * @param weight the amount of weight in the set.
     */
    public void addSet(int reps, int weight)
    {
        sets.add(new ExerciseSet(reps, weight));
    }

    /**
     * Removes a set from the exercise.
     * @return the removed set.
     */
    public ExerciseSet removeSet(ExerciseSet removed)
    {
        sets.remove(removed);
        return removed;
    }

    /**
     * Returns the sets as an ArrayList.
     * @return the sets as an ArrayList.
     */
    public ArrayList<ExerciseSet> getSets()
    {
        return sets;
    }

    /**
     * Returns the exercise as a string.
     * @return the exercises as a string.
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(title);
        builder.append("\n");
        for (int i = 0; i < getSets().size(); i++)
        {
            builder.append("Set ");
            builder.append(i + 1);
            builder.append(" ");
            builder.append("\n");
            builder.append(getSets().get(i).toString());
        }
        return builder.toString();
    }
}
