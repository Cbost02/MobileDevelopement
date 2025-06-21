package homework.q4;

import android.graphics.Color;
import java.util.Random;

public class Shape
{
    public int type;
    public int centerx;
    public int centery;
    public int size;
    public int speed;
    public int direction;
    public int color;

    public Shape()
    {

        // Initialize all the type with random numbers
        type = (int)(Math.random() * (2 - 1 + 1)) + 1; // (Between 1 - 2)
        centerx = (int)(Math.random() * (1600 + 1)); // (Between 0 - 2000)
        centery = (int)(Math.random() * (1000 + 1)); // (Between 0 - 1000)
        size = (int)(Math.random() * (100 - 50 + 1)) + 50; // (Between 50 - 100)
        speed = (int)(Math.random() * (10 - 5 + 1)) + 5;  // Between 5 and 10
        direction = (int)(Math.random() * (4 - 1 + 1)) + 1; // (Between 1 - 4)

        // Color values
        int red = (int)(Math.random() * (255 + 1));
        int green = (int)(Math.random() * (255 + 1));
        int blue = (int)(Math.random() * (255 + 1));

        color = Color.rgb(red,green,blue);
    }

    public void move()
    {
        if(direction == 1) // Right
        {
            centerx = (centerx + speed) % 1600;
        }
        else if(direction == 2) // Left
        {
            centerx = (centerx - speed + 1600) % 1600;
        }
        else if(direction == 3) // Up
        {
            centery = (centery + speed) % 1000;
        }
        else if(direction == 4) // Down
        {
            centery = (centery - speed + 1000) % 1000;
        }
    }
}

