package homework1.q2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class FourActivity extends AppCompatActivity
{
    // Get object data from MainActivity
    final private University info = MainActivity.info;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        // Update the view here
        updateView();
    }

    public void updateView()
    {
        // Grab widget information
        CheckBox dining_box = findViewById(R.id.dinning_box);
        CheckBox dorm_box = findViewById(R.id.dorm_box);


        // Retrieves info from the object
        boolean dining = info.isDining();
        boolean dorm = info.isDorm();

        // Check the buttons based on object information
        if(dorm)
        {
            dorm_box.setChecked(true);
        }
        if(dining)
        {
            dining_box.setChecked(true);
        }

    }

    public void next(View v)
    {
        // Grab widget information
        CheckBox dining_box = findViewById(R.id.dinning_box);
        CheckBox dorm_box = findViewById(R.id.dorm_box);

        // Check if the student has dinning
        if(dining_box.isChecked())
        {
            info.setDining(true); // Send info back to the object
        }
        // Check if the student has a dorm
        if(dorm_box.isChecked())
        {
            info.setDorm(true); // Send info back to the object
        }

        // Create & run the fifth activity
        Intent FifthActivity = new Intent(this, FifthActivity.class);
        startActivity(FifthActivity);

    }

    public void back(View v)
    {
        // Grab widget information
        CheckBox dining_box = findViewById(R.id.dinning_box);
        CheckBox dorm_box = findViewById(R.id.dorm_box);

        // Check if the student has dinning
        if(dining_box.isChecked())
        {
            info.setDining(true); // Send info back to the object
        }
        // Check if the student has a dorm
        if(dorm_box.isChecked())
        {
            info.setDorm(true); // Send info back to the object
        }


        // Terminate the fourth activity
        finish();
    }
}
