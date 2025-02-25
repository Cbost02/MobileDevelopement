package homework.q7;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AppInterface extends RelativeLayout
{
    private TextView[][] board;
    private TextView[][] goal_board;
    private Button up, down, left, right;

    public AppInterface(Context context, View.OnClickListener handler)
    {
        super(context);
        board = new TextView[3][3];
        goal_board = new TextView[3][3];

        // Creating 'up' button
        up = new Button(context);
        up.setOnClickListener(handler);

        // Creating 'down' button
        down = new Button(context);
        down.setOnClickListener(handler);

        // Creating 'left' button
        left = new Button(context);
        left.setOnClickListener(handler);

        // Creating 'right' button
        right = new Button(context);
        right.setOnClickListener(handler);
    }

    public void drawCurrent(TextView[][] board)
    {

    }

    public void drawGoal(TextView[][] goal_board)
    {

    }

    public void findButton(Button button)
    {

    }



}
