package homework.q5;
import java.util.*;

public class Game
{
    private int number;
    private int chances;
    private Random random_number = new Random(); // Random number generator

    // Constructor
    public Game()
    {
        // Generates a random number & gives the user 8 chances
        number = random_number.nextInt(100) + 1;
        chances = 8;
    }

    // Getter methods
    public int getChances()
    {
        return chances;
    }

    public int getNumber()
    {
        return number;
    }

    // Subtracts chances by 1
    public void decrementChances()
    {
        chances--;
    }
}
