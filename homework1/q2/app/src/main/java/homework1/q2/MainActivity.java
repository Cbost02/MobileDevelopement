package homework1.q2;

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

    public void generate(View v)
    {
        EditText firstNameBox = findViewById(R.id.input_one);
        EditText lastNameBox = findViewById(R.id.input_two);
        EditText birthdateBox = findViewById(R.id.input_three);

        String firstName = firstNameBox.getText().toString();
        String lastName = lastNameBox.getText().toString();
        String birthdate = birthdateBox.getText().toString();

        Generator generator = new Generator(firstName,lastName,birthdate);

        String userId = generator.getId();
        String password = generator.getPassword();

        TextView userIdBox = findViewById(R.id.output_one);
        TextView passwordBox = findViewById(R.id.output_two);

        userIdBox.setText(userId);
        passwordBox.setText(password);
    }


}


class Generator
{
    private String firstName;
    private String lastName;
    private String birthdate;


    public Generator(String firstName, String lastName, String birthdate)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
    }


    public String getId()
    {
        String finalId = "";

        // first letter of first name
        finalId += firstName.charAt(0);

        // entire last name
        finalId += lastName;

        // month date
        finalId += birthdate.substring(3,5);

        // lowercase everything
        finalId = finalId.toLowerCase();

        return finalId;
    }


    public String getPassword()
    {
        String finalPassword = "";

        // first letter of first name
        finalPassword += firstName.charAt(0);

        // last letter of first name
        finalPassword += firstName.charAt(firstName.length()-1);

        // month
        finalPassword += birthdate.substring(0,2);

        // last two digits of year
        finalPassword += birthdate.substring(8,10);

        // first three letters of last name
        finalPassword += lastName.substring(0,3);

        // first name & last name length
        finalPassword += firstName.length();
        finalPassword += lastName.length();


        // lowercase everything
        finalPassword = finalPassword.toLowerCase();

        return finalPassword;
    }
}
