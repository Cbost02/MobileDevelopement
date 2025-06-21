package homework.q3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity
{
    private int key;
    private final String PREFERENCE_NAME = "KEY";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Update the view
        updateView();
    }


    public void updateView()
    {
        // Retrieve the preference data (key)
        SharedPreferences prefer = getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        key = prefer.getInt("KEY",0);

        // Gain access to the edit text on the second screen
        EditText key_box = findViewById(R.id.key_box);
        key_box.setText("" + key);
    }


    public void changeKey(View v)
    {
        // Retrieve the information from the TextView
        EditText key_box = findViewById(R.id.key_box);
        String key_string = key_box.getText().toString();

        // Set the key variable to the information
        key = Integer.parseInt(key_string);

        SharedPreferences prefer = getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefer.edit();
        editor.putInt("KEY", key);
        editor.apply();
        finish();
    }

}
