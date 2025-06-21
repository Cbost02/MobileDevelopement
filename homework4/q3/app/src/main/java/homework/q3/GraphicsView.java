package homework.q3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphicsView extends View
{
    private DoodleModel model;
    private Paint paint;

    public GraphicsView(Context context, DoodleModel model)
    {
        super(context);
        this.model = model;
        paint = new Paint();

        // The paint object will be set to have a stroke with 40 width
        paint.setStrokeWidth(40f);
    }


    public void onDraw(Canvas canvas)
    {
        // Get the list of points
        LinkedList<Point> points = model.getPoints();

        // Iterate through the points
        Iterator<Point> it = points.iterator();
        while(it.hasNext())
        {
            // Reference the point
            Point point = it.next();

            // Get the color of the point
            int color = point.color;


            // Set the paint color
            paint.setColor(Color.parseColor(convert(color)));

            // Get the coordinates of the drawing point
            float x = point.x;
            float y = point.y;

            // Draw on the given coordinates
            canvas.drawPoint(x,y,paint);
        }

        // Set the paint color to the current color
        int current_color = model.getColor();
        paint.setColor(Color.parseColor(convert(current_color)));

        // Draw a filled-square at the bottom right corner of the screen

        final int square_size = 250; // dimensions
        int width = getWidth();
        int height = getHeight();

        // This section gets the bottom-right coordinates
        int left = width - square_size;
        int top = height - square_size;
        int right = width;
        int bottom = height;

        // Drawing the square
        canvas.drawRect(left,top,right,bottom, paint);

    }

    //
    public String convert(int code)
    {
        switch(code)
        {
            case 0:
                return "#000000"; // Black
            case 1:
                return "#FF0000"; // Red
            case 2:
                return "#00FF00"; // Green
            case 3:
                return "#0000FF"; // Blue
            case 4:
                return "#F5FF0C"; // Yellow
            case 5:
                return "#904201"; // Brown
            case 6:
                return "#7F7C7A"; // Grey
            case 7:
                return "#FFFFFF"; // White
            default:
                return "#000000";
        }
    }

}
