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
            try
            {
                // Retrieves the input from the user then converts it to a String
                EditText program_box = findViewById(R.id.assignment_input);
                String program_string = program_box.getText().toString().trim();

                // Checks if the programming assignment text field is empty
                if (program_string.isEmpty())
                {
                    Toast.makeText(v.getContext(), "There's no grade for the programming assignment!", Toast.LENGTH_LONG).show();
                    return;
                }

                // If it's not empty, process normally
                float program_info = Float.parseFloat(program_string);

                // Retrieves info from the midterm text field
                EditText midterm_box = findViewById(R.id.midterm_input);
                String midterm_string = midterm_box.getText().toString().trim();

                // Checks if the midterm text field is empty
                if (midterm_string.isEmpty())
                {
                    Toast.makeText(v.getContext(), "There's no grade for the midterm!", Toast.LENGTH_LONG).show();
                    return;
                }

                // If it's not empty, process normally
                float midterm_info = Float.parseFloat(midterm_string);

                // Retrieves info from the final exam text field
                EditText final_box = findViewById(R.id.final_input);
                String final_string = final_box.getText().toString().trim();

                // Checks if the final exam text field is empty
                if (final_string.isEmpty())
                {
                    Toast.makeText(v.getContext(), "There's no grade for the final exam!", Toast.LENGTH_LONG).show();
                    return;
                }
                // If it's not empty, process normally
                float final_info = Float.parseFloat(final_string);

                // Validate score ranges
                if (program_info < 0 || program_info > 200)
                {
                    Toast.makeText(v.getContext(), "Programming Assignment entry is invalid!", Toast.LENGTH_LONG).show();
                    program_box.setText("0");
                }

                if (midterm_info < 0 || midterm_info > 100)
                {
                    Toast.makeText(v.getContext(), "Midterm entry is invalid!", Toast.LENGTH_LONG).show();
                    midterm_box.setText("0");
                }

                if (final_info < 0 || final_info > 100)
                {
                    Toast.makeText(v.getContext(), "Final Exam entry is invalid!", Toast.LENGTH_LONG).show();
                    final_box.setText("0"); // Fixed: Now setting final_box instead of midterm_box
                    return;
                }

                // Initialize the calculator
                calculator = new Calculator(program_info, midterm_info, final_info);

                // Get results
                char letter_grade = calculator.getGrade();
                int score = (int) Math.round(calculator.getScore());

                // Update UI
                TextView output_score = findViewById(R.id.score_output);
                TextView output_grade = findViewById(R.id.letter_output);

                output_score.setText(String.valueOf(score));
                output_grade.setText(String.valueOf(letter_grade));
            }
            catch (Exception e)
            {
                // Any default error will occur in here
                Toast.makeText(v.getContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }
}