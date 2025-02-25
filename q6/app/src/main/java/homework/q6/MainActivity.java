package homework.q6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{
    private AppInterface appInterface;
    private Prime prime_calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButtonHandler handler = new ButtonHandler();
        appInterface = new AppInterface(this, handler);
        prime_calculator = new Prime();

        setContentView(appInterface);
    }





    private class ButtonHandler implements View.OnClickListener
    {

        @Override
        public void onClick(View v)
        {
            try
            {

            }
            catch(Exception e)
            {

            }
        }
    }
}