package homework1.q2;

import android.content.Intent;
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
    public static University info;

    @Override
   protected void onCreate(Bundle savedInstanceState)
   {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       // Create new University object
       info = new University();
   }


    public void next(View v)
    {
        // Second Activity
        Intent secondActivity = new Intent(this, SecondActivity.class);

        // Launch the second activity
        startActivity(secondActivity);

    }

}
