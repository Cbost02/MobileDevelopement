package homework.q4;

public class Game
{
    private Shape[] shapes;
    private int number_of_shapes;

    public Game()
    {
        number_of_shapes = 20;
        shapes = new Shape[number_of_shapes];

        // initialize the shapes
        for(int i = 0; i < number_of_shapes; i++)
        {
            shapes[i] = new Shape();
        }
    }

    public void move()
    {
        // Move every shape in the array!
        for(int i = 0; i < number_of_shapes; i++)
        {
            shapes[i].move();
        }
    }

    public Shape[] getShapes()
    {
        return shapes;
    }

}
