package homework.q1;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AppInterface extends RelativeLayout
{
    private TextView[][] current_board;
    private Generator generator;
    private char[][] list_of_numbers;

    public AppInterface(Context context)
    {
        super(context);
        final int DP = (int)(getResources().getDisplayMetrics().density);

        // Design RelativeLayout
        setBackgroundColor(Color.parseColor("#a300f1")); // Background will be purple

        // The board will be created in GridLayout
        GridLayout board_layout = new GridLayout(context);
        board_layout.setRowCount(3);
        board_layout.setColumnCount(3);

        // Generate a new board
        generator = new Generator();
        list_of_numbers = generator.generateBoard();

        // Initialize the TextView array with 3x3 dimensions
        current_board = new TextView[3][3];

        // Create the layout parameters (GridLayout)
        GridLayout.LayoutParams params_grid = new GridLayout.LayoutParams();
        params_grid.width = GridLayout.LayoutParams.WRAP_CONTENT;
        params_grid.height = GridLayout.LayoutParams.WRAP_CONTENT;
        params_grid.topMargin = 150*DP;
        params_grid.leftMargin = 50*DP;

        // Assign the layout parameters to the GridLayout
        board_layout.setLayoutParams(params_grid);

        // Assign each number from char list to TextView Array
        for(int i = 0; i < current_board.length; i++)
        {
            for(int j = 0; j < current_board.length; j++)
            {
                // Design the TextView for each part of the grid
                current_board[i][j] = new TextView(context);
                current_board[i][j].setBackgroundColor(Color.parseColor("#FFFFFF")); // Background of the widgets will be white
                current_board[i][j].setTextColor(Color.parseColor("#a300f1")); // Text will be purple
                current_board[i][j].setGravity(Gravity.CENTER);
                current_board[i][j].setWidth(150*DP);
                current_board[i][j].setHeight(150*DP);
                current_board[i][j].setPadding(10,10,10,10);

                current_board[i][j].setText("" + list_of_numbers[i][j]);
                current_board[i][j].setTextSize(25*DP);
                board_layout.addView(current_board[i][j]);
            }
        }

        // Add the GridView to the parent layout
        addView(board_layout);
    }

    // Method to update the grid when board changes
    public void drawCurrent(char[][] updatedBoard)
    {
        // Update current board array with the new board state
        this.list_of_numbers = updatedBoard;

        // Re-draw the grid with updated board
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++) {

                current_board[i][j].setText("" + list_of_numbers[i][j]);
            }
        }
    }

}
