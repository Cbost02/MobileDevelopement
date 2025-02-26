package homework.q6;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    private AppInterface appInterface;
    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // Creating the app
        super.onCreate(savedInstanceState);
        ButtonHandler handler = new ButtonHandler();
        appInterface = new AppInterface(this, handler);
        setContentView(appInterface);
    }





    private class ButtonHandler implements View.OnClickListener
    {

        @Override
        public void onClick(View v)
        {
            // Retrieves the user input from the interface
            int number = Integer.parseInt(appInterface.getInput());
            calculator = new Calculator(number);

            // Check if the user input is prime or not
            if(calculator.isPrime())
            {
                appInterface.sendTextToBox("It is not prime!");
            }
            else
            {
                appInterface.sendTextToBox("It is prime!");
            }
        }
    }
}