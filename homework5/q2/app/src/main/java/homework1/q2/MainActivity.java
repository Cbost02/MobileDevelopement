package homework1.q2;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    final private int ACTIVITY_TALK = 1;
    private Random rand;
    private String[] operators;
    private Calculator calculator;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize number generator & operator array
        Random rand = new Random();
        operators = initializeOperators();


        // initialize the question & calculator object
        int first = rand.nextInt(100 - 1 + 1) + 1; // Bound: 1 - 100
        int second = rand.nextInt(100 - 1 + 1) + 1; // Bound: 1 - 100
        int operator_index = rand.nextInt(3 + 1); // Bound: 0 - 3
        calculator = new Calculator(first, operators[operator_index], second);

        // Display the question
        askQuestion();

        // Check to see if the activity is available
        if(!checkSpeechRecognition())
        {
            Toast.makeText(this,"No speech recognition", Toast.LENGTH_LONG).show();
        }
    }

    private boolean checkSpeechRecognition()
    {
        // Creating package manager manager
        PackageManager manager = getPackageManager();

        // Find an available activity
        List<ResolveInfo> list = manager.queryIntentActivities(
                new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);


        return list.size() > 0;
    }

    private String[] initializeOperators()
    {
        return new String[]{"Addition", "Subtraction", "Multiplication", "Division"};
    }


    // Method runs once the button is clicked
    public void answer(View v)
    {
        Intent listen = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        listen.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        // Initialing the prompt here
        listen.putExtra(RecognizerIntent.EXTRA_PROMPT, "What is the answer?");


        // Checks for only one word to ensure clear speech
        listen.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 5);

        // Start the activity
        startActivityForResult(listen, ACTIVITY_TALK);
    }

    public void askQuestion()
    {
        // Gain access to the TextViews
        TextView first_number_box = findViewById(R.id.first_number);
        TextView operator_box = findViewById(R.id.operator);
        TextView second_number_box = findViewById(R.id.second_number);

        // Return the question attributes to the layout file
        first_number_box.setText("" + calculator.getFirst_number());
        operator_box.setText(" " + calculator.getOperator() + " ");
        second_number_box.setText("" + calculator.getSecond_number());

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        // Calls the parent function
        super.onActivityResult(requestCode, resultCode, data);

        // A try-catch block is needed to take care of the application crashing
        try
        {
            if(requestCode == ACTIVITY_TALK)
            {
                // Retrieve the list of the words recognized
                ArrayList<String> words = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                // Retrieve the answer box
                TextView answer_box = findViewById(R.id.answer);

                // Searches to see if the word said could've been the correct answer
                if (words.contains(calculator.getAnswer()))
                {
                    answer_box.setText("Correct!");
                }
                else
                {
                    answer_box.setText("Incorrect!");
                }
            }
        }
        catch(Exception e)
        {
            Toast.makeText(this,"Try speaking louder!!!", Toast.LENGTH_LONG).show();
        }
    }


}
