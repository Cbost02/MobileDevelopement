package homework.q3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity
{
    TextView red_view;
    TextView blue_view;
    TextView green_view;
    TextView display;
    Calculator calculator;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creating seek bars & Change Handler
        SeekBar red_bar = findViewById(R.id.red_bar);
        SeekBar blue_bar = findViewById(R.id.blue_bar);
        SeekBar green_bar = findViewById(R.id.green_bar);
        ChangeHandler handler = new ChangeHandler();

        // Assigning handler to each bar
        red_bar.setOnSeekBarChangeListener(handler);
        green_bar.setOnSeekBarChangeListener(handler);
        blue_bar.setOnSeekBarChangeListener(handler);

        // initializing the calculator
        calculator = new Calculator();


    }


    private class ChangeHandler implements SeekBar.OnSeekBarChangeListener
    {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean b)
        {
            // Retrieving the Seek Bar ID
            int id = seekBar.getId();



            if(id == R.id.red_bar) // Checks for Red Seek Bar
            {
                red_view = findViewById(R.id.red_view);
                red_view.setText("" + progress);
                calculator.setRed(progress);

            }
            else if(id == R.id.green_bar) // Checks for Green Seek Bar
            {
                green_view = findViewById(R.id.green_view);
                green_view.setText("" + progress);
                calculator.setGreen(progress);
            }
            else if(id == R.id.blue_bar) // Checks for Blue Seek Bar
            {
                blue_view = findViewById(R.id.blue_view);
                blue_view.setText("" + progress);
                calculator.setBlue(progress);
            }

            // Retrieves color information from the calculator object
            int red = calculator.getRed();
            int green = calculator.getGreen();
            int blue = calculator.getBlue();

            // Combining the colors into one
            int combined_color = Color.rgb(red,green,blue);

            // Displays color onto the square-like widget
            display = findViewById(R.id.color_box);
            display.setBackgroundColor(combined_color);


        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar)
        {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }
}