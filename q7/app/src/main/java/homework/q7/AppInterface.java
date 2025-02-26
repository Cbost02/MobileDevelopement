package homework.q7;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
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

        // Parameters for the initial board
        RelativeLayout.LayoutParams myParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        myParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        myParams.setMargins(0,200,0,0);

        // Initializing the GridLayout
        GridLayout boardLayout = new GridLayout(context);
        boardLayout.setRowCount(3);
        boardLayout.setColumnCount(3);
        boardLayout.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        // Creating board in GridLayout
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board.length; j++)
            {
                // Creating a spot on the board & styling it
                board[i][j] = new TextView(context);
                board[i][j].setBackgroundColor(Color.parseColor("#e5be1a"));
                board[i][j].setTextColor(Color.parseColor("#000000"));
                board[i][j].setTextSize(10);
                board[i][j].setGravity(Gravity.CENTER);
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.width = 200;  // Adjust width
                params.height = 200; // Adjust height
                params.rowSpec = GridLayout.spec(i, 1);
                params.columnSpec = GridLayout.spec(j, 1);
                params.setMargins(10, 10, 10, 10); // Set margins

                board[i][j].setLayoutParams(params);
                boardLayout.addView(board[i][j]);

            }
        }
        boardLayout.setLayoutParams(myParams);

        // Adding the layout to the parent layout
        addView(boardLayout);





        // Parameters for the goal board
        RelativeLayout.LayoutParams myParamsGoal = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        myParamsGoal.addRule(RelativeLayout.CENTER_HORIZONTAL);
        myParamsGoal.setMargins(0,1000,0,0);

        // Initializing the GridLayout
        GridLayout goalBoardLayout = new GridLayout(context);
        goalBoardLayout.setRowCount(3);
        goalBoardLayout.setColumnCount(3);
        goalBoardLayout.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        // Creating the goal board in GridLayout
        for(int i = 0; i < goal_board.length; i++)
        {
            for(int j = 0; j < goal_board.length; j++)
            {
                // Creating a spot on the board & styling it
                goal_board[i][j] = new TextView(context);
                goal_board[i][j].setBackgroundColor(Color.parseColor("#e5be1a"));
                goal_board[i][j].setTextColor(Color.parseColor("#000000"));
                goal_board[i][j].setTextSize(10);
                goal_board[i][j].setGravity(Gravity.CENTER);
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.width = 200;  // Adjust width
                params.height = 200; // Adjust height
                params.rowSpec = GridLayout.spec(i, 1);
                params.columnSpec = GridLayout.spec(j, 1);
                params.setMargins(10, 10, 10, 10); // Set margins
                goal_board[i][j].setLayoutParams(params);
                goalBoardLayout.addView(goal_board[i][j]);
            }
        }
        goalBoardLayout.setLayoutParams(myParamsGoal);

        // Adding the goal grid to the parent layout
        addView(goalBoardLayout);

        // Creating 'up' button
        up = new Button(context);
        up.setText("Up");
        up.setOnClickListener(handler);


        // Creating 'down' button
        down = new Button(context);
        down.setText("Down");
        down.setOnClickListener(handler);

        // Creating 'left' button
        left = new Button(context);
        left.setText("Left");
        left.setOnClickListener(handler);

        // Creating 'right' button
        right = new Button(context);
        right.setText("Right");
        right.setOnClickListener(handler);

        RelativeLayout.LayoutParams buttonPara = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        buttonPara.setMargins(0,1700,0,0);


        // Initialing LinearLayout
        LinearLayout layout_linear = new LinearLayout(context);
        layout_linear.setOrientation(LinearLayout.HORIZONTAL); // Horizontal arrangement
        layout_linear.setPadding(20, 20, 20, 20);


        // Parameters for LinearLayout
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(10, 10, 10, 10); // Set margins

        // Assign the parameters to the buttons
        up.setLayoutParams(params);
        down.setLayoutParams(params);
        left.setLayoutParams(params);
        right.setLayoutParams(params);

        // Adding the buttons to the LinearLayout
        layout_linear.addView(up);
        layout_linear.addView(down);
        layout_linear.addView(left);
        layout_linear.addView(right);

        // Assigning parameters to the LinearLayout
       layout_linear.setLayoutParams(buttonPara);

        // Send layout to the parent view
        addView(layout_linear);
    }


    // Rewriting the current board to the app
    public void drawCurrent(char[][] current)
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                board[i][j].setText(String.valueOf(current[i][j])); // Convert char to String
            }
        }
    }

    // Displaying the goal board to the app
    public void drawGoal(char[][] goal)
    {
        for (int i = 0; i < goal_board.length; i++)
        {
            for (int j = 0; j < goal_board[i].length; j++)
            {
                goal_board[i][j].setText(String.valueOf(goal[i][j])); // Convert char to String
            }
        }
    }

    // Finding one of the 4 buttons
    public char findButton(Button button)
    {
        if (button == up)
        {
            return '1';
        }
        else if (button == down)
        {
            return '2';
        }
        else if (button == left)
        {
            return '3';
        }
        else
        {
            return '4';
        }


    }

    // Disables all buttons
    public void disableButtons()
    {
        up.setEnabled(false);
        down.setEnabled(false);
        left.setEnabled(false);
        right.setEnabled(false);
    }



}
