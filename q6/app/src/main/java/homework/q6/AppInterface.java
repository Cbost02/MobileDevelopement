package homework.q6;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class AppInterface extends RelativeLayout
{
    private TextView prompt_box;
    private EditText input_box;
    private TextView result_box;
    private Button submit_button;
    public AppInterface(Context context, View.OnClickListener buttonHandler)
    {
        super(context);

        // Initial DP Units
        final int DP = (int) (getResources().getDisplayMetrics().density);

        // Create & design the prompt box
        prompt_box = new TextView(context);
        prompt_box.setId(TextView.generateViewId());
        prompt_box.setTextColor(Color.parseColor("#FFFFFF"));
        prompt_box.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        prompt_box.setPadding(5, 5, 5, 5);
        prompt_box.setBackgroundColor(Color.parseColor("#00a20a"));
        prompt_box.setText("Enter a number");

        // Create & design the input box
        input_box = new EditText(context);
        input_box.setId(TextView.generateViewId());
        input_box.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        input_box.setHint("Enter here");
        input_box.setGravity(Gravity.CENTER);
        input_box.setPadding(5, 5, 5, 5);
        // You might want to set inputType to "number" here

        // Create & design the result box
        result_box = new TextView(context);
        result_box.setId(TextView.generateViewId());
        result_box.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        result_box.setBackgroundColor(Color.parseColor("#8c9a8e"));
        result_box.setPadding(5, 5, 5, 5);
        result_box.setHint("Result will be displayed here");

        // Create the button
        submit_button = new Button(context);
        submit_button.setId(TextView.generateViewId());
        submit_button.setBackgroundColor(Color.parseColor("#ac00ff"));
        submit_button.setTextColor(Color.parseColor("#FFFFFF"));
        submit_button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        submit_button.setPadding(20,20,20,20);
        submit_button.setText("Calculate"); // Set button text

        // LayoutParams for prompt_box
        RelativeLayout.LayoutParams promptParams = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        promptParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        promptParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        promptParams.topMargin = 250 * DP;

        // LayoutParams for input_box
        RelativeLayout.LayoutParams inputParams = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        inputParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        inputParams.addRule(RelativeLayout.BELOW, prompt_box.getId());
        inputParams.setMargins(50,200,50,50);

        // LayoutParams for the button
        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.addRule(RelativeLayout.BELOW, input_box.getId());
        buttonParams.setMargins(50,200,50,50);

        // LayoutParams for result_box
        RelativeLayout.LayoutParams resultParams = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        resultParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        resultParams.addRule(RelativeLayout.BELOW, submit_button.getId()); // Position below the button

        // Add views with layout params
        addView(prompt_box, promptParams);
        addView(input_box, inputParams);
        addView(submit_button, buttonParams); // Add the button
        addView(result_box, resultParams);
    }

}
