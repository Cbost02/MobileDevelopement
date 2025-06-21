package homework.q3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity
{
    private DoodleModel model; // The model
    private GraphicsView view; // The view
    private GestureDetector gestureDetector; // Detects screen touching
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Create the model and the view
        model = new DoodleModel();
        view = new GraphicsView(this,model);
        setContentView(view);
        TouchHandler temp = new TouchHandler();
        gestureDetector = new GestureDetector(this, temp);
    }

    public boolean onTouchEvent(MotionEvent event)
    {
        // Find the coordinates of the event
        float x_location = event.getX();
        float y_location = event.getY();


        // Check if the touch is within the square
        if(check(x_location,y_location))
        {
            gestureDetector.onTouchEvent(event);
        }
        else
        {
            int action = event.getAction(); // Get the action that occurred

            // Do this if the user pressed down or dragged
            if(action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_MOVE)
            {
                model.addPoint(x_location,y_location);
                view.postInvalidate();
            }
        }

        return true;
    }

    public boolean check(float x, float y)
    {
        // Get screen dimensions
        int screenWidth = getWindowManager().getCurrentWindowMetrics().getBounds().width();
        int screenHeight = getWindowManager().getCurrentWindowMetrics().getBounds().height();

        // Check if the coordinates are inside the square
        int square_size = 250;
        int left = screenWidth - square_size;
        int top = screenHeight - square_size;
        int right = screenWidth;
        int bottom = screenHeight;

        // Checks if the coordinates are in the location of the square
        if (x >= left && x <= right && y >= top && y <= bottom)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    private class TouchHandler extends GestureDetector.SimpleOnGestureListener
    {

        public boolean onSingleTapConfirmed(MotionEvent e)
        {
            // Go to the next color
            model.nextColor();
            view.postInvalidate();
            return true;

        }
    }
}