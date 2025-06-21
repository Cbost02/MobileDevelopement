package homework1.q2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity
{
    // Get object data from MainActivity
    final private University info = MainActivity.info;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // Update the view here
        updateView();
    }

    public void updateView()
    {
        // Grab widget information
        RadioButton undergrad_button = findViewById(R.id.undergrad_button);
        RadioButton grad_button = findViewById(R.id.grad_button);


        // Retrieves info from the object
        String status = info.getStatus();

        // Check the buttons based on object information
        if(status.equalsIgnoreCase("Undergrad"))
        {
            undergrad_button.setChecked(true);
        }
        else
        {
            grad_button.setChecked(true);
        }


    }

    public void next(View v)
    {
        // Get the input from the Radio Buttons
        RadioButton undergrad_button = findViewById(R.id.undergrad_button);
        RadioButton grad_button = findViewById(R.id.grad_button);

        // Check to see if the undergrad button is checked
        if(undergrad_button.isChecked())
        {
            // Send the data to the object
            info.setStatus("Undergrad");
        }

        // Check to see if the grad button is checked
        if(grad_button.isChecked())
        {
            // Send the data to the object
            info.setStatus("Grad");
        }

        // Create & run the third activity
        Intent fourthActivity = new Intent(this, FourActivity.class);
        startActivity(fourthActivity);

    }

    public void back(View v)
    {
        // Get the input from the Radio Buttons
        RadioButton undergrad_button = findViewById(R.id.undergrad_button);
        RadioButton grad_button = findViewById(R.id.grad_button);

        // Check to see if the undergrad button is checked
        if(undergrad_button.isChecked())
        {
            // Send the data to the object
            info.setStatus("Undergrad");
        }

        // Check to see if the grad button is checked
        if(grad_button.isChecked())
        {
            // Send the data to the object
            info.setStatus("Grad");
        }

        // Terminate the third activity
        finish();
    }
}
