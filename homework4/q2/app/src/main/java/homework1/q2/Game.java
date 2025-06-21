package homework1.q2;
import java.util.*;

public class Game
{
    private int[] number_array;
    private int window_location;
    private int swaps;

    // For random number generation
    private Random number_generator;

    public Game()
    {
        number_array = new int[10]; // Array will be filled with 10 random numbers
        number_generator = new Random();

        // Fill the array with 10 random numbers between 1 & 100
        for (int i = 0; i < number_array.length; i++)
        {
            number_array[i] = number_generator.nextInt(100 - 1 + 1) + 1;
        }

        // Assign window location
        window_location = number_generator.nextInt(8 + 1);


        // Initialize swaps
        swaps = 45;
    }

    // check this method
    public void move()
    {
        window_location = (window_location + 1) % 9;
    }

    // Swap the elements in the window
    public void swap()
    {
        int index1 = window_location;
        int index2 = (window_location + 1) % number_array.length; // handles wraparound
        int temp = number_array[index1];
        number_array[index1] = number_array[index2];
        number_array[index2] = temp;
        swaps--;
    }

    public int[] getArray()
    {
        return number_array;
    }

    public int getWindow()
    {
        return window_location;
    }

    // Checks if the array is sorted
    public boolean sorted(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            if (arr[i] < arr[i + 1])
            {
                return false;
            }
        }
        return true;
    }

    // Checks to see if the game is over ( swaps >= 45)
    public boolean gameOver()
    {
        if(swaps == 0 || sorted(number_array))
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public String getMessage()
    {
        if(sorted(number_array))
        {
            return "You Win!";
        }
        else if(gameOver())
        {
            return "You Lose";
        }
        else
        {
            return "Swaps left: " + swaps;
        }
    }

}
