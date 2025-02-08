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
    Generator generator;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generator = new Generator();
        initialize();
    }


    public void initialize()
    {
        generator.generate();

        Button submit = findViewById(R.id.submit);
        Button next = findViewById(R.id.next);

        String operator = generator.getOperator();
        int number_one = generator.getNumber1();
        int number_two = generator.getNumber2();
        int points = generator.getCorrect();
        int total_questions = generator.getTotal();

        TextView number1 = findViewById(R.id.view_one);
        TextView number2 = findViewById((R.id.view_two));
        TextView operator_box = findViewById(R.id.operator);
        TextView score = findViewById(R.id.score);

        number1.setText(number_one);
        number2.setText(number_two);
        operator_box.setText(operator);
        score.setText("Score: " + points + "/" + total_questions);
        submit.setEnabled(true);
        next.setEnabled(false);
    }


    public void next(View v)
    {
        generator.generate();

        Button submit = findViewById(R.id.submit);
        Button next = findViewById(R.id.next);

        String operator = generator.getOperator();
        int number_one = generator.getNumber1();
        int number_two = generator.getNumber2();
        int points = generator.getCorrect();
        int total_questions = generator.getTotal();

        TextView number1 = findViewById(R.id.view_one);
        TextView number2 = findViewById((R.id.view_two));
        TextView operator_box = findViewById(R.id.operator);
        TextView score = findViewById(R.id.score);

        number1.setText(number_one);
        number2.setText(number_two);
        operator_box.setText(operator);
        score.setText("Score: " + points + "/" + total_questions);
        submit.setEnabled(true);
        next.setEnabled(false);
    }


    public void submit(View v)
    {
        EditText input = findViewById(R.id.input);

        String input_String = input.getText().toString();

        int input_value = (int)Float.parseFloat(input_String);

        int answer = generator.getAnswer();

        if(input_value == answer)
        {
            generator.increaseCorrect();
        }
        else if(input_String.equals(""))
        {
            String message = "Please enter a value!";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(this,message,duration);
            toast.show();
        }

        generator.increaseTotal();

        int total = generator.getTotal();
        int correct = generator.getCorrect();

        TextView score = findViewById(R.id.score);

        score.setText("Score: " + correct + "/" + total);

        Button submit = findViewById(R.id.submit);
        Button next = findViewById(R.id.next);

        submit.setEnabled(false);
        next.setEnabled(true);



    }


}