package DAY_34;

import java.util.*;

class Pair
{
    int row;
    int col;

    Pair(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
}

public class RottenOrange
{
    public static int orangesRotting(int[][] grid)
    {
        Queue<Pair> q = new LinkedList<>();

        int freshOrange = 0;

        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == 2)
                {
                    q.add(new Pair(i, j));
                }
                else if(grid[i][j] == 1)
                {
                    freshOrange++;
                }
            }
        }

        if(freshOrange == 0)
        {
            return 0;
        }

        int minute = 0;

        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i = 0; i < size; i++)
            {
                Pair current = q.remove();

                int row = current.row;
                int col = current.col;

                // Top
                if(row > 0 && grid[row - 1][col] == 1)
                {
                    grid[row - 1][col] = 2;
                    q.add(new Pair(row - 1, col));
                    freshOrange--;
                }

                // Bottom
                if(row + 1 < n && grid[row + 1][col] == 1)
                {
                    grid[row + 1][col] = 2;
                    q.add(new Pair(row + 1, col));
                    freshOrange--;
                }

                // Left
                if(col > 0 && grid[row][col - 1] == 1)
                {
                    grid[row][col - 1] = 2;
                    q.add(new Pair(row, col - 1));
                    freshOrange--;
                }

                // Right
                if(col + 1 < m && grid[row][col + 1] == 1)
                {
                    grid[row][col + 1] = 2;
                    q.add(new Pair(row, col + 1));
                    freshOrange--;
                }
            }

            if(!q.isEmpty())
            {
                minute++;
            }
        }

        return freshOrange == 0 ? minute : -1;
    }

    public static void main(String[] args)
    {
        int[][] grid =
                {
                        {2, 1, 1},
                        {1, 1, 0},
                        {0, 1, 1}
                };

        int result = orangesRotting(grid);

        System.out.println("Minutes Required = " + result);
    }
}