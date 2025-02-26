package homework.q7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
        super.onCreate(savedInstanceState);
        game = new Game(); // initialing the game
        ButtonHandler handler = new ButtonHandler(); // creating a button handler
        screen = new AppInterface(this,handler); // initializing the interface
        setContentView(screen);

        // get the current board & display it
        screen.drawCurrent(game.getCurrent_board());

        // get the goal board & display it
        screen.drawGoal(game.getGoal_board());
    }




    private class ButtonHandler implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            char buttonId = screen.findButton((Button) v);
            switch (buttonId)
            {
                case '1': // Up
                    game.up();
                    break;
                case '2': // Down
                    game.down();
                    break;
                case '3': // Left
                    game.left();
                    break;
                case '4': // Right
                    game.right();
                    break;
            }
            screen.drawCurrent(game.getCurrent_board()); // Update the display


            // Toast message is displayed when the game is won
            if(game.isSolved())
            {
                String message = "You won the game!";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(MainActivity.this, message, duration);
                toast.show();
                screen.disableButtons();
            }
        }



    }
}