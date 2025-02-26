package homework.q8;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.appcompat.app.AppCompatActivity;

// MainActivity
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

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                TextChangeHandler temp = new TextChangeHandler(i, j);
                appInterface.setTextChangeHandler(temp, i, j);
            }
        }
        setContentView(appInterface);
    }

    private class TextChangeHandler implements TextWatcher
    {
        private int x;
        private int y;

        public TextChangeHandler(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {
            // Not needed for this implementation
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            // Not needed for this implementation
        }

        @Override
        public void afterTextChanged(Editable e)
        {
            String input = appInterface.getInput(x, y);

            if (input.isEmpty()) {
                game.set(0, x, y);
            } else if (input.equals("0")) {
                game.set(0, x, y);
                appInterface.clear(x, y);
            } else if (input.length() > 1) {
                game.set(0, x, y);
                appInterface.clear(x, y);
            } else {
                try {
                    int value = Integer.parseInt(input);
                    if (game.check(value, x, y)) {
                        game.set(value, x, y);
                    } else {
                        game.set(0, x, y);
                        appInterface.clear(x, y);
                    }
                } catch (NumberFormatException ex) {
                    //Handle exception, if the input cannot be converted to integer
                    game.set(0, x, y);
                    appInterface.clear(x,y);
                }
            }
        }
    }
}