package homework.q5;
import java.util.*;

public class Game
{
    private int number;
    private int chances;
    private Random random_number = new Random();

    public Game()
    {
        // Generates a random number & gives the user 8 chances
        number = random_number.nextInt(100) + 1;
        chances = 8;
    }

    public int getChances()
    {
        return chances;
    }

    public int getNumber()
    {
        return number;
    }

    public void decrementChances()
    {
        chances--;
    }
}
