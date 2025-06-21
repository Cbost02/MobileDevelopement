package homework.q4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class GameView extends View
{
    private Game game;
    private Paint paint;

    public GameView(Context context, Game game)
    {
        super(context);
        this.game = game;

        // Create paint object will fill style
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

    }

    public void onDraw(Canvas canvas)
    {
        // initialize values needed
        int type, centerx, centery, size, color;

        // Set background color to black
        canvas.drawColor(Color.BLACK);

        // Get the array of shapes
        Shape[] shapes = game.getShapes();

        for(int i = 0; i < shapes.length; i++)
        {
            // Get the attributes
            type = shapes[i].type;
            centerx = shapes[i].centerx;
            centery = shapes[i].centery;
            size = shapes[i].size;
            color = shapes[i].color;

            // What color will the shape be?
            paint.setColor(color);

            if(type == 1)
            {
                canvas.drawCircle(centerx,centery,size,paint);
            }
            else if (type == 2)
            {
                // Calculate half the side length
                int halfSide = size;  // size represents half of the side length

                // Calculate the coordinates of the top-left corner
                int left = centerx - halfSide;
                int top = centery - halfSide;

                // Calculate the coordinates of the bottom-right corner
                int right = centerx + halfSide;
                int bottom = centery + halfSide;

                // Draw the square
                canvas.drawRect(left, top, right, bottom, paint);
            }

            postInvalidate();

        }
    }

}
