package homework1.q2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FifthActivity extends AppCompatActivity
{
    // Get object data from MainActivity
    final private University info = MainActivity.info;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);

        // Update the view here
        updateView();
    }

    public void updateView()
    {
        TextView output_box = findViewById(R.id.output_box);

        double total = info.getTotal();

        output_box.setText("$" + total);
    }

    public void back(View v)
    {
        // Terminate the Fifth activity
        finish();
    }


}
