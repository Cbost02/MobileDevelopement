package homework.q1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add(View v)
    {
        EditText inputOne = findViewById(R.id.firstNum);
        EditText inputTwo = findViewById(R.id.secondNum);

        String stringOne = inputOne.getText().toString();
        String stringTwo = inputTwo.getText().toString();

        float numberOne = Float.parseFloat(stringOne);
        float numberTwo = Float.parseFloat(stringTwo);

        float result = numberOne + numberTwo;

        TextView outputBox = findViewById(R.id.output);


        // If the result is a integer, convert to int
        if(result % 1 == 0)
        {
            int resultInt = (int)result;
            String outgoingString = "" + resultInt;
            outputBox.setText(outgoingString);
            return;
        }

        String outgoingString = "" + result;
        outputBox.setText(outgoingString);


    }

    public void sub(View v)
    {
        EditText inputOne = findViewById(R.id.firstNum);
        EditText inputTwo = findViewById(R.id.secondNum);

        String stringOne = inputOne.getText().toString();
        String stringTwo = inputTwo.getText().toString();

        float numberOne = Float.parseFloat(stringOne);
        float numberTwo = Float.parseFloat(stringTwo);

        float result = numberOne - numberTwo;

        TextView outputBox = findViewById(R.id.output);


        // If the result is a integer, convert to int
        if(result % 1 == 0)
        {
            int resultInt = (int)result;
            String outgoingString = "" + resultInt;
            outputBox.setText(outgoingString);
            return;
        }

        String outgoingString = "" + result;
        outputBox.setText(outgoingString);
    }

    public void mul(View v)
    {
        EditText inputOne = findViewById(R.id.firstNum);
        EditText inputTwo = findViewById(R.id.secondNum);

        String stringOne = inputOne.getText().toString();
        String stringTwo = inputTwo.getText().toString();


        float numberOne = Float.parseFloat(stringOne);
        float numberTwo = Float.parseFloat(stringTwo);

        float result = numberOne * numberTwo;

        TextView outputBox = findViewById(R.id.output);

        // If the result is a integer, convert to int
        if(result % 1 == 0)
        {
            int resultInt = (int)result;
            String outgoingString = "" + resultInt;
            outputBox.setText(outgoingString);
            return;
        }


        String outgoingString = "" + result;
        outputBox.setText(outgoingString);
    }

    public void div(View v)
    {
        EditText inputOne = findViewById(R.id.firstNum);
        EditText inputTwo = findViewById(R.id.secondNum);

        String stringOne = inputOne.getText().toString();
        String stringTwo = inputTwo.getText().toString();

        float numberOne = Float.parseFloat(stringOne);
        float numberTwo = Float.parseFloat(stringTwo);

        TextView outputBox = findViewById(R.id.output);

        float result = numberOne / numberTwo;

        // If the result is a integer, convert to int
        if(result % 1 == 0)
        {
            int resultInt = (int)result;
            String outgoingString = "" + resultInt;
            outputBox.setText(outgoingString);
            return;
        }

        String outgoingString = "" + result;
        outputBox.setText(outgoingString);
    }

    /**
     * if (numberOne % numberTwo == 0)
     * {
     *     int result = (int)(numberOne / numberTwo);
     *
     * }
     */



}