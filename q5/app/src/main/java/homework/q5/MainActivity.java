package homework.q5;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.*;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Blue box
        EditText input_blue = findViewById(R.id.blueBox);

        // Red box
        EditText input_red = findViewById(R.id.redBox);

        // Green box
        EditText input_green = findViewById(R.id.greenBox);
        TextChangeHandler temp = new TextChangeHandler();

        input_blue.addTextChangedListener(temp);
        input_green.addTextChangedListener(temp);
        input_red.addTextChangedListener(temp);

    }


    private class TextChangeHandler implements TextWatcher
    {
        public void afterTextChanged(Editable e)
        {
            EditText input_blue = findViewById(R.id.blueBox);
            EditText input_red = findViewById(R.id.redBox);
            EditText input_green = findViewById(R.id.greenBox);

            String blue_string = input_blue.getText().toString();
            String red_string = input_red.getText().toString();
            String green_string = input_green.getText().toString();

            int blue_value;
            int green_value;
            int red_value;

            // check blue
            if(blue_string.equalsIgnoreCase(""))
            {
                blue_value = 0;
            }
            else
            {
                blue_value = (int) Float.parseFloat(blue_string);

                if(blue_value > 255)
                    blue_value = 255;

            }

            // check green
            if(green_string.equalsIgnoreCase(""))
            {
                green_value = 0;
            }
            else
            {
                green_value = (int) Float.parseFloat(green_string);

                if(green_value > 255)
                    green_value = 255;

            }


            // check red
            if(red_string.equalsIgnoreCase(""))
            {
                red_value = 0;
            }
            else
            {
                red_value = (int) Float.parseFloat(red_string);

                if(red_value > 255)
                    red_value = 255;
            }

            TextView main_box = findViewById(R.id.colorBox);

            main_box.setBackgroundColor(Color.rgb(red_value,green_value,blue_value));
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {

        }

        public void onTextChanged(CharSequence s, int start, int before, int after)
        {

        }
    }
}