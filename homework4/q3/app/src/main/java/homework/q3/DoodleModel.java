package homework.q3;

import java.util.LinkedList;

public class DoodleModel
{
    private int color;
    private LinkedList<Point> point_list;

    public DoodleModel()
    {
        color = 0; // Set color to 0
        point_list = new LinkedList<Point>(); // Empty List
    }

    // This method retrieves the next color
    public void nextColor()
    {
        color = (color + 1) % 8;
    }

    public void addPoint(float x, float y)
    {
        // Add the point to the list using x & y parameters. The color will come from this class
        point_list.add(new Point(x,y,color));
    }

    // Returns the current color
    public int getColor()
    {
        return color;
    }

    // returns the point list
    public LinkedList<Point> getPoints()
    {
        return point_list;
    }
}
