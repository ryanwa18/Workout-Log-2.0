package com.example.ryanw.workoutlog20;

/**
 * Created by ryanw on 3/5/2016.
 */
public class ExerciseSet
{
    private int weight;
    private int reps;

    /**
     * The constructor for a set.
     * @param reps the number of reps in a set.
     * @param weight the amount of weight per set.
     */
    public ExerciseSet(int reps, int weight)
    {
        this.reps = reps;
        this.weight = weight;
    }

    /**
     * Sets the number of reps.
     * @param n the number of reps.
     */
    public void setNumReps(int n)
    {
        reps = n;
    }

    /**
     * Sets the amount of weight.
     * @param n the amount of weight.
     */
    public void setWeight(int n)
    {
        weight = n;
    }

    /**
     * Returns the amount of reps per set.
     * @return the amount of reps per set.
     */
    public int getReps()
    {
        return reps;
    }

    /**
     * Returns the amount of weight per set.
     * @return the amount of weight per set.
     */
    public int getWeight()
    {
        return weight;
    }

    /**
     * Converts the set to a string.
     * @return the set as a string.
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Reps - ");
        builder.append(getReps());
        builder.append("\nWeight - ");
        builder.append(getWeight());
        return builder.toString();
    }
}
