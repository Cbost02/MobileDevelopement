package homework.q7;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{
    private Game game;
    private AppInterface screen;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        game = new Game();
        ButtonHandler handler = new ButtonHandler();
        screen = new AppInterface(this,handler);
        super.onCreate(savedInstanceState);

    }

    private class ButtonHandler implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            // Find the button that was clicked


            // Display current board
        }
    }
}