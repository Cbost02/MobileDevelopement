package homework.q4;

import android.os.Bundle;
import android.view.View;
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

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View v)
    {
        try
        {
            EditText credits_box = findViewById(R.id.credits);
            String credits_string = credits_box.getText().toString();

            float credits = Float.parseFloat(credits_string);


            RadioGroup degree_group = findViewById(R.id.degree);
            RadioGroup state_group = findViewById(R.id.state_parent);

            int degree_id = degree_group.getCheckedRadioButtonId();
            int state_id = state_group.getCheckedRadioButtonId();

            // Check degree
            String class_level = "";

            if(degree_id == R.id.graduate)
            {
                class_level += "Graduate";
            }
            else if(degree_id == R.id.undergraduate)
            {
                class_level += "Undergraduate";
            }
            else
            {
                class_level += "Non-Degree";
            }


            // Check state
            String state_status = "";

            if(state_id == R.id.in_state)
            {
                state_status += "In State";
            }
            else
            {
                state_status += "Out of state";
            }



            CheckBox dorm = findViewById(R.id.dorm);
            CheckBox dining = findViewById(R.id.dining);
            CheckBox parking = findViewById(R.id.parking);


            // Check optional charges
            Boolean hasDorm = false;
            Boolean hasDining = false;
            Boolean hasParking = false;

            if(dorm.isChecked())
                hasDorm = true;

            if(dining.isChecked())
                hasDining = true;

            if(parking.isChecked())
                hasParking = true;



            Calculator calculator = new Calculator(credits,class_level,state_status,
                    hasDorm,hasDining,hasParking);

            float total_cost = calculator.getTotal();

            TextView output_box = findViewById(R.id.total);

            output_box.setText("$" + total_cost);

        }
        catch(Exception e)
        {
            EditText credits_box = findViewById(R.id.credits);
            credits_box.setText("" + 0);
        }
    }

}