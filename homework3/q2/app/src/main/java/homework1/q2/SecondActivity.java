package homework1.q2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity
{
    // Get object data from MainActivity
    final private University info = MainActivity.info;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Update the view here
        updateView();
    }

    public void updateView()
    {
        // Retrieves info from the object
        int credits = info.getCredits();

        // Assigns the credits to the edit text widget
        EditText credits_box = findViewById(R.id.credits_box);
        credits_box.setText("" + credits);
    }

    public void next(View v)
    {
        // Get the input from the EditText Widget
        EditText credit_box = findViewById(R.id.credits_box);

        // Convert to integer
        int credits = Integer.parseInt(credit_box.getText().toString());

        // Pass data to object
        info.setCredits(credits);

        // Create & run the third activity
        Intent thirdActivity = new Intent(this, ThirdActivity.class);
        startActivity(thirdActivity);

    }

    public void back(View v)
    {
        // Get the input from the EditText Widget
        EditText credit_box = findViewById(R.id.credits_box);

        // Convert to integer & send info to the object
        int credits = Integer.parseInt(credit_box.getText().toString());
        info.setCredits(credits);

        // Terminate the second activity
        finish();
    }


}
