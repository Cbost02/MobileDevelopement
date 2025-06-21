package homework.q4;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Array
{
    private double[] values;
    private int size;

    // Constructor that takes a space-separated string of numbers
    public Array(String input)
    {
        StringTokenizer tokenizer = new StringTokenizer(input);
        size = tokenizer.countTokens(); // Number of values
        values = new double[size];

        int index = 0;
        while (tokenizer.hasMoreTokens())
        {
            values[index++] = Double.parseDouble(tokenizer.nextToken());
        }
    }

    // Get the sum of the array
    public double getSum()
    {
        double sum = 0;
        for (double num : values)
        {
            sum += num;
        }
        return sum;
    }

    // Get the minimum value
    public double getMin()
    {
        double min = values[0];
        for (double num : values)
        {
            if (num < min)
            {
                min = num;
            }
        }
        return min;
    }

    // Get the maximum value
    public double getMax()
    {
        double max = values[0];
        for (double num : values)
        {
            if (num > max)
            {
                max = num;
            }
        }
        return max;
    }

    // Get the mean (average)
    public double getMean()
    {
        return getSum() / size;
    }

    // Get the standard deviation
    public double getStdv() {

        double mean = getMean();
        double sumOfSquares = 0;
        for (double num : values)
        {
            sumOfSquares += Math.pow(num - mean, 2);
        }
        return Math.sqrt(sumOfSquares / size);
    }

    // Get the median
    public double getMedian()
    {
        double[] sortedArray = Arrays.copyOf(values, size);
        Arrays.sort(sortedArray);

        if (size % 2 == 0)
        {
            return (sortedArray[size / 2 - 1] + sortedArray[size / 2]) / 2.0;
        }
        else
        {
            return sortedArray[size / 2];
        }
    }

    // Sort the array
    public void sort()
    {
        Arrays.sort(values);
    }

    // Display the values for debugging
    public void displayValues()
    {
        System.out.println(Arrays.toString(values));
    }
}
