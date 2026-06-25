package DAY_39;

public class WordSearch
{
    public static void main(String[] args)
    {
        char[][] board =
                {
                        {'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}
                };

        String word = "ABCCED";

        if(exist(board, word))
        {
            System.out.println("Word Found");
        }
        else
        {
            System.out.println("Word Not Found");
        }
    }

    public static boolean exist(char[][] board, String word)
    {
        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(search(board, word, i, j, 0))
                {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean search(char[][] board, String word, int row, int col, int index)
    {
        if(index == word.length())
        {
            return true;
        }

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length)
        {
            return false;
        }

        if(board[row][col] != word.charAt(index))
        {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        boolean found =
                search(board, word, row + 1, col, index + 1) ||
                        search(board, word, row - 1, col, index + 1) ||
                        search(board, word, row, col + 1, index + 1) ||
                        search(board, word, row, col - 1, index + 1);

        board[row][col] = temp;

        return found;
    }
}