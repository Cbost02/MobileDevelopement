package homework.q3;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity
{
    private int KEY = 0;
    private final String PREFERENCE_NAME = "KEY";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create text handler
        TextChangeHandler temp = new TextChangeHandler();

        // Apply the handler to the widget
        EditText subject = findViewById(R.id.subject);
        EditText body = findViewById(R.id.email_body);

        subject.addTextChangedListener(temp);
        body.addTextChangedListener(temp);
    }

    public void encrypt(View v)
    {
        // Access the email body only & retrieve text from it
        EditText body_box = findViewById(R.id.email_body);
        String body_string = body_box.getText().toString();

        // Retrieve the key from preference data
        SharedPreferences prefer = getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        int key = prefer.getInt("KEY",0);

        // Create the encrypted variable
        String encrypted_string = "";

        StringBuilder encrypted = new StringBuilder();
        for (char c : body_string.toCharArray())
        {
            if (Character.isLetter(c))
            {
                int index;
                if (Character.isLowerCase(c))
                    index = c - 'a';               // index 0–25 for a–z
                else
                    index = 26 + (c - 'A');        // index 26–51 for A–Z

                // apply the shift using modulo 52
                int newIndex = (index + key) % 52;

                // map back to character
                if (newIndex < 26)
                    encrypted.append((char) ('a' + newIndex));
                else
                    encrypted.append((char) ('A' + (newIndex - 26)));
            }
            else
            {
                // preserve non-letter characters
                encrypted.append(c);
            }
        }

        encrypted_string = encrypted.toString();

        body_box.setText(encrypted_string);
    }

    public void decrypt(View v)
    {
        // Access the email body only & retrieve text from it
        EditText body_box = findViewById(R.id.email_body);
        String body_string = body_box.getText().toString();

        // Retrieve the key from preference data
        SharedPreferences prefer = getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        int key = prefer.getInt("KEY", 0);

        // Create the encrypted variable
        String encrypted_string = "";

        StringBuilder decrypted = new StringBuilder();
        for (char c : body_string.toCharArray())
        {
            if (Character.isLetter(c))
            {
                int index;
                if (Character.isLowerCase(c))
                    index = c - 'a';               // index 0–25 for a–z
                else
                    index = 26 + (c - 'A');        // index 26–51 for A–Z

                // apply reverse shift and wrap around
                int newIndex = (index - key) % 52;
                if (newIndex < 0)
                    newIndex += 52;

                // map back to character
                if (newIndex < 26)
                    decrypted.append((char) ('a' + newIndex));
                else
                    decrypted.append((char) ('A' + (newIndex - 26)));
            }
            else
            {
                // preserve non-letter characters
                decrypted.append(c);
            }
        }

        encrypted_string = decrypted.toString();

        body_box.setText(encrypted_string);
    }

    public void send(View v)
    {
        // Read the email address
        EditText address_box = findViewById(R.id.address);
        String address = address_box.getText().toString();

        // Read the subject
        EditText subject_box = findViewById(R.id.subject);
        String subject = subject_box.getText().toString();


        // Read of the email body
        EditText body_box = findViewById(R.id.email_body);
        String body = body_box.getText().toString();

        // Creating an Intent for the email activity
        Intent email_intent = new Intent(Intent.ACTION_SEND);
        email_intent.setType("text/plain");

        // Set the recipients of the email
        String[] recipient = new String[]{address};
        email_intent.putExtra(Intent.EXTRA_EMAIL, recipient);

        // Set the email subject and text
        email_intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        email_intent.putExtra(Intent.EXTRA_TEXT, body);

        // Start activity
        startActivity(email_intent);
    }

    public void change(View v)
    {
        // Create & start an Intent for the next activity
        Intent second = new Intent(this, SecondActivity.class);
        startActivity(second);
    }


    private class TextChangeHandler implements TextWatcher
    {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {

        }

        @Override
        public void afterTextChanged(Editable s)
        {
            // Access the subject box
            EditText subject_box = findViewById(R.id.subject);
            String subject = subject_box.getText().toString();

            // Access the body box
            EditText body_box = findViewById(R.id.email_body);
            String body = body_box.getText().toString();

            if(subject.length() > 20) // Check if the subject is more than 20 characters
            {
                // Do not allow any more characters
                subject = subject.substring(0, subject.length() - 1);
                subject_box.setText(subject);
                Toast.makeText(MainActivity.this,"Too many characters!", Toast.LENGTH_SHORT).show();
            }

            if(body.length() > 200)
            {
                body = body.substring(0, body.length() - 1);
                body_box.setText(body);
                Toast.makeText(MainActivity.this,"Too many characters!", Toast.LENGTH_SHORT).show();
            }



        }
    }



}