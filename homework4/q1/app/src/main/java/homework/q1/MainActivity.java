package homework.q1;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{

    private AppInterface screen;
    private Game game;
    private GestureDetector gestureDetector;
    private static final float TILE_SIZE = 150; // size of each grid cell (in pixels)

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        screen = new AppInterface(this);
        setContentView(screen);


        // Create the Game instance
        game = new Game();

        // Create the AppInterface and pass the game object to it
        screen = new AppInterface(this);

        // Set the content view to AppInterface
        setContentView(screen);

        // Get the current board from the game and display it
        screen.drawCurrent(game.getCurrentBoard());

        // Create the TouchHandler and GestureDetector
        TouchHandler touchHandler = new TouchHandler();
        gestureDetector = new GestureDetector(this, touchHandler);
    }

    public boolean onTouchEvent(MotionEvent event)
    {
        gestureDetector.onTouchEvent(event);
        return true;
    }

    private class TouchHandler extends GestureDetector.SimpleOnGestureListener
    {
            final float DP = Resources.getSystem().getDisplayMetrics().density;

            // Grid position and size based on AppInterface
            final int gridLeft = (int)(50 * DP);
            final int gridTop = (int)(150 * DP);
            final int cellSize = (int)(150 * DP);
            final int gridWidth = 3 * cellSize;
            final int gridHeight = 3 * cellSize;

            final int margin = (int)(20 * DP); // Optional extra margin for easier detection

            @Override
            public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY)
            {
                if (inside(event1) && inside(event2))
                {
                    int u = getRow(event1);
                    int v = getColumn(event1);
                    int x = getRow(event2);
                    int y = getColumn(event2);

                    game.swap(u, v, x, y);
                    screen.drawCurrent(game.getCurrentBoard());
                }
                return true;
            }

            private boolean inside(MotionEvent event)
            {
                float x = event.getX();
                float y = event.getY();

                return x >= gridLeft - margin &&
                        x <= gridLeft + gridWidth + margin &&
                        y >= gridTop - margin &&
                        y <= gridTop + gridHeight + margin;
            }

            private int getRow(MotionEvent event)
            {
                float y = event.getY();
                return (int)((y - gridTop) / cellSize);
            }

            private int getColumn(MotionEvent event)
            {
                float x = event.getX();
                return (int)((x - gridLeft) / cellSize);
            }
    }

}