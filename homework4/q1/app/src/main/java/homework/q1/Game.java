package homework.q1;

public class Game
{
    private char[][] current_board;
    private Generator generator;


    public Game()
    {
        generator = new Generator();
        current_board = generator.generateBoard();
    }

    public void swap(int u, int v, int x, int y)
    {
        // Only swap if check returns true (i.e., the swap is valid)
        if (check(u, v, x, y))
        {
            // Swap the values at (u, v) and (x, y)
            char temp = current_board[u][v];
            current_board[u][v] = current_board[x][y];
            current_board[x][y] = temp;
        }
    }


    // Check whether two spots on the board are valid for swapping
    public boolean check(int u, int v, int x, int y)
    {
        // Check if the positions (u, v) and (x, y) are valid and inside the grid
        if (u < 0 || u >= 3 || v < 0 || v >= 3 || x < 0 || x >= 3 || y < 0 || y >= 3)
        {
            return false;  // Out of bounds
        }

        // Get the current board values at the given positions
        char first = current_board[u][v];
        char second = current_board[x][y];

        // If either of the two positions is blank (' '), check if they are adjacent
        if (first == ' ' && isAdjacent(u, v, x, y))
        {
            return true;  // Blank spot and its neighbor, valid swap
        }
        if (second == ' ' && isAdjacent(u, v, x, y))
        {
            return true;  // Blank spot and its neighbor, valid swap
        }

        return false;  // No valid swap, either not adjacent or not involving the blank spot
    }

    // Helper method to check if two positions are adjacent (left, right, up, down)
    private boolean isAdjacent(int u, int v, int x, int y)
    {
        // Check if the two positions are adjacent in any of the four directions (up, down, left, right)
        return (Math.abs(u - x) == 1 && v == y) || (Math.abs(v - y) == 1 && u == x);
    }

    public char[][] getCurrentBoard()
    {
        return current_board;
    }

    public boolean gameOver()
    {
        // Check if the board is sorted
        char[][] sortedBoard = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', ' '}};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (current_board[i][j] != sortedBoard[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }


}
