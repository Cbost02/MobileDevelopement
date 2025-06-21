package homework.q3;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.NumberFormat;

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
        EditText input_one_box = findViewById(R.id.principal);
        EditText input_two_box = findViewById(R.id.a_addition);
        EditText input_three_box = findViewById(R.id.years);
        EditText input_four_box = findViewById(R.id.investment);


        String principal_string = input_one_box.getText().toString();
        String annual_addition_string = input_two_box.getText().toString();
        String number_of_years_string = input_three_box.getText().toString();
        String investment_rate_string = input_four_box.getText().toString();


        float principal = Float.parseFloat(principal_string);
        float annual_addition = Float.parseFloat(annual_addition_string);
        float number_of_years = Float.parseFloat(number_of_years_string);
        float investment_rate = Float.parseFloat(investment_rate_string);

        Calculator calculator = new Calculator(principal, annual_addition, investment_rate, number_of_years);

        int total = calculator.getAmount();


        String total_string = "$";
        total_string += total;

        TextView final_amount_box = findViewById(R.id.output);

        final_amount_box.setText(total_string);
    }
}