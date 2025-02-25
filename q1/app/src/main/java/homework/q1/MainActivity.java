package homework.q1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// Testing changes for branch "homework2
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{

    private Calculator calculator;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        ButtonHandler handler = new ButtonHandler();
        button.setOnClickListener(handler);


    }

    private class ButtonHandler implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            // Setting up the Toast messages for missing scores
            String message_PA = "There's no grade for the programming assignment!";
            String message_midterm = "There's no grade for the midterm!";
            String message_final = "There's no grade for the final exam!";

            //  Setting up duration of the Toast message
            int duration = Toast.LENGTH_LONG;

            // Setting up the Toast messages for valid scores
            String message_invalid_PA = "Programming Assignment entry is invalid!";
            String message_invalid_midterm = "Midterm entry is invalid!";
            String message_invalid_final = "Programming Assignment entry is invalid!";

            // Declare Toast object
            Toast toast;
            try
            {
                // Getting information from the Programming Assignment Text Entry
                EditText program_box = findViewById(R.id.assignment_input);
                String program_string = program_box.getText().toString();

                // Check to see if the Assignment input was empty before parsing
                if(program_string.trim().isEmpty())
                {
                    toast = Toast.makeText(MainActivity.this, message_PA,duration);
                    toast.show();
                    return; // Ends the method
                }
                float program_info = Float.parseFloat(program_string);

                // Getting information from the Midterm Text Entry
                EditText midterm_box = findViewById(R.id.midterm_input);
                String midterm_string = midterm_box.getText().toString();

                // Check to see if the Midterm input was empty before parsing
                if(midterm_string.trim().isEmpty())
                {
                    toast = Toast.makeText(MainActivity.this, message_midterm,duration);
                    toast.show();
                    return; // Ends the method
                }
                float midterm_info = Float.parseFloat(midterm_string);

                // Getting information from the Final Exam Text Entry
                EditText final_box = findViewById(R.id.final_input);
                String final_string = final_box.getText().toString();

                // Check to see if the Final Exam input was empty before parsing
                if(final_string.trim().isEmpty())
                {
                    toast = Toast.makeText(MainActivity.this, message_final,duration);
                    toast.show();
                    return; // Ends the method
                }

                float final_info = Float.parseFloat(final_string);


                // Before calculating, we must check to see if the scores are valid

                if(program_info < 0 || program_info > 200)
                {
                    toast = Toast.makeText(MainActivity.this, message_invalid_PA,duration);
                    toast.show();
                    program_box.setText("" + 0);
                }

                if(midterm_info < 0 || midterm_info > 100)
                {
                    toast = Toast.makeText(MainActivity.this, message_invalid_midterm,duration);
                    toast.show();
                    midterm_box.setText("" + 0);
                }

                if (final_info < 0 || final_info > 100)
                {
                    toast = Toast.makeText(MainActivity.this, message_invalid_final,duration);
                    toast.show();
                    midterm_box.setText("" + 0);
                    return;
                }

                // Initialize the calculator object
                calculator = new Calculator(program_info, midterm_info,final_info);

                // Retrieves the final score & grade from the model
                char letter_grade = calculator.getGrade();
                int score = (int)Math.round(calculator.getScore());

                // Calls the score & letter grade widgets
                TextView output_score = findViewById(R.id.score_output);
                TextView output_grade = findViewById(R.id.letter_output);

                output_score.setText("" + score);
                output_grade.setText("" + letter_grade);
            }
            catch(Exception e) // If any other error happens, this catch block will handle it
            {
                String error_message = e.getMessage();
                toast = Toast.makeText(MainActivity.this,error_message,duration);
                toast.show();
            }

        }
    }
}