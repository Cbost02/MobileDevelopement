package homework.q8;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Grid;

import java.util.Random;


class  AppInterface extends GridLayout
{
    private EditText[][] board;

    public AppInterface(Context context)
    {
        super(context);
        board = new EditText[9][9];
        setRowCount(9);
        setColumnCount(9);

        // Correct LayoutParams for the GridLayout itself (using ViewGroup.LayoutParams)
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        // Create the board in GridLayout
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = new EditText(context);
                board[i][j].setInputType(InputType.TYPE_CLASS_NUMBER);
                board[i][j].setGravity(Gravity.CENTER);
                board[i][j].setTextSize(20);

                // Correct LayoutParams for EACH EditText (using GridLayout.LayoutParams)
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.width = 0;  // 0 width with weight
                params.height = GridLayout.LayoutParams.WRAP_CONTENT; // Wrap content
                params.rowSpec = GridLayout.spec(i, 1, 1f); // row, rowspan, weight.  Use float for weight
                params.columnSpec = GridLayout.spec(j, 1, 1f); // col, colspan, weight. Use float
                params.setMargins(4, 4, 4, 4);  // Add margins
                board[i][j].setLayoutParams(params);


                addView(board[i][j]);
            }
        }
    }
    public void drawInitialBoard(int[][] initialBoard) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (initialBoard[i][j] == 0) {
                    board[i][j].setText("");
                    board[i][j].setBackgroundColor(Color.WHITE); // Simple white background

                } else {
                    board[i][j].setText(String.valueOf(initialBoard[i][j]));
                    board[i][j].setBackgroundColor(Color.LTGRAY); // Light gray for prefilled
                    board[i][j].setEnabled(false); // Disable editing
                }
            }
        }
    }


    public String getInput(int x, int y) {
        return board[x][y].getText().toString();
    }

    public void clear(int x, int y) {
        board[x][y].setText("");
    }

    public void setTextChangeHandler(TextWatcher textChangeHandler, int x, int y) {
        board[x][y].addTextChangedListener(textChangeHandler);
    }
}
