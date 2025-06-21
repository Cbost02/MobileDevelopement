package homework.q4;
// complete
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Timer;

public class MainActivity extends AppCompatActivity
{
    private Game game;
    private GameView view;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        game = new Game();
        view = new GameView(this, game);
        setContentView(view);

        // Send a schedule to the program
        Timer timer = new Timer();
        GameTimerTask task = new GameTimerTask(game, view);
        timer.schedule(task, 0, 20);
    }

}