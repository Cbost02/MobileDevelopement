package homework1.q2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
{
    private DecimalFormat format;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        format = new DecimalFormat("#.##"); // This is formatting the output!
        ButtonHandler handler = new ButtonHandler(); // Create Button Handler
        Button button = findViewById(R.id.calculate_button); // Call the button from the layout
        button.setOnClickListener(handler); // Attach the handler to the button
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
            String shipping_string = (String)shipping_spinner.getSelectedItem();

            // Actual shipping value
            String shipping = "";


            // Check to see which of the spinner choice were selected
            if(shipping_string.equalsIgnoreCase("Next Day"))
            {
                shipping = "Next Day";
            }
            else if(shipping_string.equalsIgnoreCase("Second Day"))
            {
                shipping = "Second Day";
            }
            else if(shipping_string.equalsIgnoreCase("Normal Day"))
            {
                shipping = "Normal Day";
            }

            // Calculate the total price
            Calculator calculator = new Calculator(price, warranty, insurance, shipping);
            double total_price = calculator.getTotal();

            // Call the output widget then store the total price
            TextView output_box = findViewById(R.id.output_box);
            output_box.setText("$" + format.format(total_price));



        }
    }

}
