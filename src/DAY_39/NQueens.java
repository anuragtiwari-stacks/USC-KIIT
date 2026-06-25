package DAY_39;

public class NQueens
{
    public static void main(String[] args)
    {
        int n = 4;

        char[][] board = new char[n][n];

        initializeBoard(board);

        solve(board, 0);
    }

    public static void initializeBoard(char[][] board)
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board.length; j++)
            {
                board[i][j] = '.';
            }
        }
    }

    public static void solve(char[][] board, int row)
    {
        if(row == board.length)
        {
            printBoard(board);
            System.out.println();
            return;
        }

        for(int col = 0; col < board.length; col++)
        {
            if(isSafe(board, row, col))
            {
                board[row][col] = 'Q';

                solve(board, row + 1);

                board[row][col] = '.';
            }
        }
    }

    public static boolean isSafe(char[][] board, int row, int col)
    {
        for(int i = row - 1; i >= 0; i--)
        {
            if(board[i][col] == 'Q')
            {
                return false;
            }
        }

        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
        {
            if(board[i][j] == 'Q')
            {
                return false;
            }
        }

        for(int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
        {
            if(board[i][j] == 'Q')
            {
                return false;
            }
        }

        return true;
    }

    public static void printBoard(char[][] board)
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board.length; j++)
            {
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }
    }
}