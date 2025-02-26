package homework.q8;

// Game
public class Game
{
    private int[][] board;

    public Game()
    {
        Sudoku sudoku = new Sudoku();
        board = sudoku.generate();
    }

    public void set(int value, int x, int y)
    {
        board[x][y] = value;
    }

    public boolean check(int value, int x, int y)
    {
        //Check Row
        for(int j = 0; j < 9; j++)
        {
            if(board[x][j] == value)
            {
                return false;
            }
        }

        //Check Column
        for(int i = 0; i < 9; i++)
        {
            if(board[i][y] == value)
            {
                return false;
            }
        }

        //Check 3x3
        int boxRowStart = x - x % 3;
        int boxColStart = y - y % 3;

        for(int i = boxRowStart; i < boxRowStart + 3; i++)
        {
            for(int j = boxColStart; j < boxColStart + 3; j++)
            {
                if(board[i][j] == value)
                {
                    return false;
                }
            }
        }

        return true; // If no conflicts, it's valid
    }

    public int[][] getBoard()
    {
        return board;
    }
}