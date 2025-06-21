package homework.q4;
// complete
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
{
    private Calculator calculator;
    private DecimalFormat df = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View v)
    {
        // Reading the whole input as one String
        EditText input_box = findViewById(R.id.input_box);
        String input = input_box.getText().toString();

        // Creating a calculator & passing the input into it
        calculator = new Calculator();
        calculator.set(input);

        // Checking to see which button was clicked
        int id = v.getId();

        // Result will be stored in here
        float result = 0.0f;


        if(id == R.id.sum_button) // Checking for the sum button
        {
            result = calculator.getSum();
        }
        else if(id == R.id.mean_button) // Checking for the mean button
        {
            result = calculator.getMean();
        }
        else if(id == R.id.min_button) // Checking for the min button
        {
            result = calculator.getMin();
        }
        else if(id == R.id.median_button) // Checking for the median button
        {
            result = calculator.getMedian();
        }
        else if(id == R.id.standard_button) // Checking for the standard deviation button
        {
            result = calculator.getStandardDeviation();
        }
        else if(id == R.id.max_button)
        {
            result = calculator.getMax();
        }

        // Send the result to the output box
        TextView output = findViewById(R.id.output_box);
        output.setText(df.format(result));



    }

}