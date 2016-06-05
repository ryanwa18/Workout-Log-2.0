package com.example.ryanw.workoutlog20;

/**
 * Created by ryanw on 3/6/2016.
 */
public class User
{
    private String height;
    private String name;
    private int age;
    private double weight;

    /**
     * Constructor for a new user.
     * @param name the users name.
     * @param feet the users height in feet.
     * @param inches the users height in inches.
     * @param weight the users weight.
     * @param age the users age.
     */
    public User(String name, int feet, int inches, double weight, int age)
    {
        this.name = name;
        this.height = feet + "'" + inches + "\"";
        this.weight = weight;
        this.age = age;
    }

    /**
     * Gets the users height.
     * @return the users height.
     */
    public String getHeight()
    {
        return height;
    }

    /**
     * Gets the users name.
     * @return the users name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Gets the users weight.
     * @return the users weight.
     */
    public double getWeight()
    {
        return weight;
    }

    /**
     * Gets the users age.
     * @return the users age.
     */
    public int getAge()
    {
        return age;
    }

    /**
     * Returns the user as a string.
     * @return the user as a string.
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Name: ");
        builder.append(getName());
        builder.append("\nHeight: ");
        builder.append(getHeight());
        builder.append("\nWeight: ");
        builder.append(getWeight());
        builder.append("\nAge: ");
        builder.append(getAge());
        return builder.toString();
    }
}
