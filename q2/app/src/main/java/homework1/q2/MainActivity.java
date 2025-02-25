package homework1.q2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

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
        ButtonHandler handler = new ButtonHandler(); // Create Button Handler
        Button button = findViewById(R.id.calculate_button); // Call the button from the layout
        button.setOnClickListener(handler); // Attach the handler to the button
        setContentView(R.layout.activity_main);
    }

    private class ButtonHandler implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            // Calling and reading the information from the Price widget
            EditText price_box = findViewById(R.id.price_input);
            String price_string = price_box.getText().toString();
            float price = Float.parseFloat(price_string);

            // Calling and reading the information from the Price widget
            ToggleButton warranty_toggle = findViewById(R.id.warranty_button);
            boolean warranty = false; // default value

            // Check to see if the toggle button is checked, if so, set warranty to 'true
            if(warranty_toggle.isChecked())
            {
                warranty = true;
            }

            // Calling and reading the information from the Insurance widget
            Switch insurance_switch = findViewById(R.id.insurance_switch);
            boolean insurance = false; // default value

            // Check to see if the switch is checked, if so, set insurance to 'true
            if(insurance_switch.isChecked())
            {
                insurance = true;
            }

            // Calling and reading the information from the Shipping widget
            Spinner shipping_spinner = findViewById(R.id.delivery_input);
            String shipping = ""; // default value

            // Make a list of all the spinner attributes





        }
    }

}
