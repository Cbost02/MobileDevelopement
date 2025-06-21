package homework1.q2;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AppInterface extends RelativeLayout
{
    private TextView[] numbers;
    private TextView message_box;
    private final int SIZE = 10;

    public AppInterface(Context context)
    {
        super(context);
        final int DP = (int)(getResources().getDisplayMetrics().density);


        // Create the array and the message box
        numbers = new TextView[SIZE];
        message_box = new TextView(context);

        // The GUI will be displayed in LinearLayout
        LinearLayout array_layout = new LinearLayout(context);
        array_layout.setOrientation(LinearLayout.VERTICAL); // Array will be display vertically
        array_layout.setPadding(10,10,10,10);

        // Create some parameters for the array layout
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.topMargin = 100*DP;
        params.leftMargin = 220*DP;
        array_layout.setLayoutParams(params);

        // Create the textview(s) for the array
        for(int i = 0; i < SIZE; i++)
        {
            // Widgets MUST be initialized before usage, otherwise, the app will crash
            numbers[i] = new TextView(context);

            // Designing the widgets
            numbers[i].setBackgroundColor(Color.parseColor("#00FF00")); // Green
            numbers[i].setGravity(Gravity.CENTER);
            numbers[i].setTextColor(Color.parseColor("#000000")); // Black
            numbers[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
            numbers[i].setPadding(8,8,8,8);
            numbers[i].setWidth(100*DP);
            numbers[i].setHeight(60*DP);
            numbers[i].setText("1");
            array_layout.addView(numbers[i]);
        }


        // Add the array GUI to the screen
        addView(array_layout);

        // Designing the message_box
        message_box = new TextView(context);
        message_box.setBackgroundColor(Color.parseColor("#0000CC"));
        message_box.setTextColor(Color.parseColor("#FFFFFF"));
        message_box.setText("Swaps left: 45");
        message_box.setTextSize(15*DP);
        message_box.setPadding(15,15,15,15);


        // parameters for the message_box
        RelativeLayout.LayoutParams params_box = new RelativeLayout.LayoutParams(0,0);
        params_box.width = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params_box.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params_box.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params_box.topMargin = 800 * DP;


        // Add the params
        message_box.setLayoutParams(params_box);
        addView(message_box);




    }

    public void showCurrent(int[] arr, int window_location, String message)
    {
        // Read the info from the array then sort it into the text view
        for(int i = 0; i < arr.length; i++)
        {
            numbers[i].setText("" + arr[i]);
        }

        // Change the background color of the TextView inside the window
        // checks the window location
        switch (window_location)
        {
            case 0:
                numbers[0].setBackgroundColor(Color.parseColor("#FF0000"));
                numbers[1].setBackgroundColor(Color.parseColor("#FF0000"));
                highlightWindow(numbers, 0,1);
                break;
            case 1:
                numbers[1].setBackgroundColor(Color.parseColor("#FF0000"));
                numbers[2].setBackgroundColor(Color.parseColor("#FF0000"));
                highlightWindow(numbers, 1,2);
                break;
            case 2:
                numbers[2].setBackgroundColor(Color.parseColor("#FF0000"));
                numbers[3].setBackgroundColor(Color.parseColor("#FF0000"));
                highlightWindow(numbers, 2,3);
                break;
            case 3:
                numbers[3].setBackgroundColor(Color.parseColor("#FF0000"));
                numbers[4].setBackgroundColor(Color.parseColor("#FF0000"));
                highlightWindow(numbers, 3,4);
                break;
            case 4:
                numbers[4].setBackgroundColor(Color.parseColor("#FF0000"));
                numbers[5].setBackgroundColor(Color.parseColor("#FF0000"));
                highlightWindow(numbers, 4,5);
                break;
            case 5:
                numbers[5].setBackgroundColor(Color.parseColor("#FF0000"));
                numbers[6].setBackgroundColor(Color.parseColor("#FF0000"));
                highlightWindow(numbers, 5,6);
                break;
            case 6:
                numbers[6].setBackgroundColor(Color.parseColor("#FF0000"));
                numbers[7].setBackgroundColor(Color.parseColor("#FF0000"));
                highlightWindow(numbers, 6,7);
                break;
            case 7:
                numbers[7].setBackgroundColor(Color.parseColor("#FF0000"));
                numbers[8].setBackgroundColor(Color.parseColor("#FF0000"));
                highlightWindow(numbers, 7,8);
                break;
            case 8:
                numbers[8].setBackgroundColor(Color.parseColor("#FF0000"));
                numbers[9].setBackgroundColor(Color.parseColor("#FF0000"));
                highlightWindow(numbers, 8,9);
                break;
        }


        // Set the current text
        message_box.setText(message);
    }

    public void highlightWindow(TextView[] views, int index1, int index2)
    {
        for (int i = 0; i < views.length; i++)
        {
            if (i == index1 || i == index2)
            {

            }
            else
            {
                // Reset others to default (green in your interface)
                views[i].setBackgroundColor(Color.parseColor("#00CC00"));
            }
        }
    }
}




