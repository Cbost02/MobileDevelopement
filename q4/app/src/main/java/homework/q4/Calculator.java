package homework.q4;

import java.util.StringTokenizer;
import java.util.*;

public class Calculator
{
    private String numbers;
    private double[] values;
    private int size;

    // Array object
    Array array;

    // Constructor
    public Calculator()
    {
        size = 0;
        values = null;
        numbers = "";
        array = null;

    }


    public void set(String numbers)
    {
        // Splitting the numbers by whitespace
        String[] parts = numbers.split("\\s+");

        // Initializing the array
        values = new double[parts.length];

        // Converts each integer into a double then stores into values[]
        for(int i = 0; i < parts.length; i++)
        {
            values[i] = Double.parseDouble(parts[i]);
        }

        // Passes the information into the Array object
        array = new Array(numbers);
    }

    // Getter methods for each button
    public float getSum()
    {
        return (float)array.getSum();
    }

    public float getMin()
    {
        return (float)array.getMin();
    }

    public float getMax()
    {
        return (float)array.getMax();
    }


    public float getMean()
    {
        return (float)array.getMean();
    }

    public float getStandardDeviation()
    {
        return (float)array.getStdv();
    }

    public float getMedian()
    {
        return (float) array.getMedian();
    }

}
