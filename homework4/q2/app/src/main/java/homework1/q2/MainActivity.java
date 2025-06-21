package homework1.q2;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity
{
    private Game game;
    private AppInterface appInterface;
    private GestureDetector gestureDetector;
    private boolean game_over;
    @Override
   protected void onCreate(Bundle savedInstanceState)
   {
       super.onCreate(savedInstanceState);
       game  = new Game();
       appInterface = new AppInterface(this);
       setContentView(appInterface);

       // Get the attributes from the Game class
       int[] numbers = game.getArray();
       int window_location = game.getWindow();
       String message = game.getMessage();

       // show the current game
       appInterface.showCurrent(numbers, window_location, message);

       TouchHandler temp = new TouchHandler();

       gestureDetector = new GestureDetector(this,temp);

       game_over = false;
   }

    public boolean onTouchEvent(MotionEvent event)
    {
        if(!game_over)
        {
            gestureDetector.onTouchEvent(event);
            return true;
        }
        else
        {
            return true;
        }
    }


    private class TouchHandler extends GestureDetector.SimpleOnGestureListener
    {

        public boolean onSingleTapConfirmed(MotionEvent e)
        {
            // Move the window
            game.move();

            // Show current state
            int[] arr = game.getArray();
            int window = game.getWindow();
            String message = game.getMessage();
            appInterface.showCurrent(arr, window, message);

            return true;
        }


        public boolean onDoubleTap(MotionEvent e)
        {
            // Swap the elements in the array
            game.swap();

            // Show current state
            int[] arr = game.getArray();
            int window = game.getWindow();
            String message = game.getMessage();
            appInterface.showCurrent(arr, window, message);

            // Update game over
            game_over = game.gameOver();

            return true;
        }
    }
}
