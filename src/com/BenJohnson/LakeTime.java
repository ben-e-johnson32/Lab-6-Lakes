package com.BenJohnson;

import java.util.ArrayList;
import java.util.Collections;

public class LakeTime
{
    // A list for the lake's times and a string for its name.
    private ArrayList<Double> times = new ArrayList<>();
    private String name;

    // Basic constructor - only needs the name.
    public LakeTime(String lake)
    {
        this.name = lake;
    }

    // A getter for the name.
    public String getName()
    {
        return this.name;
    }

    // A class method to add a time.
    public void addTime(Double time)
    {
        this.times.add(time);
    }

    // A class method to get the fastest time in the lake's list of times.
    public Double getFastestTime()
    {
        return Collections.min(this.times);
    }
}
