package homework.q7;

public class Game
{
    private char[][] current_board;
    private char[][] goal_board;
    private int x; // Row of the empty slot
    private int y; // Column of the empty slot

    public Game()
    {
        // Creating a generator & getting the initial board
        Generator generator = new Generator();
        current_board = generator.generateInitialBoard();
        goal_board = generator.generateGoalBoard();
        findEmptySlot(); // Find the initial position of the empty slot, *before* any moves

    }

    // finding an empty slot; needed when the game starts
    private void findEmptySlot()
    {
        for (int i = 0; i < current_board.length; i++)
        {
            for (int j = 0; j < current_board[i].length; j++)
            {
                if (current_board[i][j] == ' ') { // Assuming ' ' represents the empty slot
                    x = i;
                    y = j;
                    return; // Exit the loops once found
                }
            }
        }
    }


    // Move up on the board
    public void up()
    {
        if (x > 0)
        {
            char temp = current_board[x][y]; // Use a temporary variable for swapping
            current_board[x][y] = current_board[x - 1][y];
            current_board[x - 1][y] = temp;
            x--;
        }
    }

    // Move down on the board
    public void down()
    {
        if (x < current_board.length - 1)
        {
            char temp = current_board[x][y];
            current_board[x][y] = current_board[x + 1][y];
            current_board[x + 1][y] = temp;
            x++;
        }
    }


    // Move left on the board
    public void left()
    {
        if (y > 0)
        {
            char temp = current_board[x][y];
            current_board[x][y] = current_board[x][y - 1];
            current_board[x][y - 1] = temp;
            y--;
        }
    }

    // Move right on the board
    public void right()
    {
        if (y < current_board[0].length - 1)
        {
            char temp = current_board[x][y];
            current_board[x][y] = current_board[x][y + 1];
            current_board[x][y + 1] = temp;
            y++;
        }
    }


    // Getter methods
    public char[][] getCurrent_board()
    {
        return current_board;
    }

    public char[][] getGoal_board()
    {
        return goal_board;
    }


    // Checks to see if the board is solved
    public boolean isSolved()
    {
        for (int i = 0; i < current_board.length; i++)
        {
            for (int j = 0; j < current_board[i].length; j++)
            {
                if (current_board[i][j] != goal_board[i][j])
                {
                    return false; // If any element doesn't match, it's not solved
                }
            }
        }
        return true; // If all elements match, it's solved
    }
}
