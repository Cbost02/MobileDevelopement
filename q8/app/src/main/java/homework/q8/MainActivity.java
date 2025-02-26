package homework.q8;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.appcompat.app.AppCompatActivity;

// MainActivity - Handles the main game logic and UI interactions
public class MainActivity extends AppCompatActivity
{
    private Game game;
    private AppInterface appInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        game = new Game();
        appInterface = new AppInterface(this);
        appInterface.drawInitialBoard(game.getBoard());


        // Sets up text change listeners for each cell in the grid
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                TextChangeHandler temp = new TextChangeHandler(i, j);
                appInterface.setTextChangeHandler(temp, i, j);
            }
        }
        setContentView(appInterface); // Displays the game UI
    }

    // Handles text changes in the game board cells
    private class TextChangeHandler implements TextWatcher
    {
        private int x; // Row index
        private int y; // Column index

        // Constructor
        public TextChangeHandler(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {
            // Not used, but required by interface
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            // Not used, but required by interface
        }

        @Override
        public void afterTextChanged(Editable e)
        {
            // Get the user input from the cell
            String input = appInterface.getInput(x, y);

            // If empty, set cell value to 0
            if (input.isEmpty())
            {
                game.set(0, x, y);
            }
            else if (input.equals("0"))
            {
                // If "0" is entered, clear the cell
                game.set(0, x, y);
                appInterface.clear(x, y);
            }
            else if (input.length() > 1)
            {
                // If input is more than one character, reset the cell
                game.set(0, x, y);
                appInterface.clear(x, y);
            }
            else
            {
                try
                {
                    // Convert input to integer
                    int value = Integer.parseInt(input);

                    // check if the number is valid
                    if (game.check(value, x, y))
                    {
                        game.set(value, x, y);

                        // Check if the player has won
                        if (game.checkWin())
                        {
                            appInterface.displayWinMessage();
                        }
                    }
                    else
                    {
                        // If invalid, reset the cell
                        game.set(0, x, y);
                        appInterface.clear(x, y);
                    }
                }
                catch (NumberFormatException ex)
                {

                    // If input is not a valid number, reset the cell
                    game.set(0, x, y);
                    appInterface.clear(x, y);
                }
            }
        }
    }
}