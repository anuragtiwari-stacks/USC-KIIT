package DAY_22;

/*
Question:
Deep beneath the KIIT campus lies a mysterious underground maze filled with hidden passages and dead ends.

The maze is represented as a binary matrix where:
1 -> Open Path
0 -> Blocked Path

A rat starts from the top-left cell (0,0) and needs to reach the bottom-right cell (N-1,N-1).

Rules:
1. The rat can move in all four directions:
   - Up
   - Down
   - Left
   - Right

2. A cell can be visited at most once in a single path.

Task:
Find the total number of valid paths from the source to the destination using
Recursion and Backtracking.

Example Maze:

1 0 0 0
1 1 0 1
1 1 0 0
0 1 1 1

Output:
1

Explanation:
Only one valid path exists from source to destination.
*/

public class RatInMaze
{
    static int count = 0;
    static void solve(int[][] maze, int r, int c, boolean[][] vis)
    {

        int n = maze.length;

        if (r == n - 1 && c == n - 1)
        {
            count++;
            return;
        }

        vis[r][c] = true;

        // UP
        if (r - 1 >= 0 && maze[r - 1][c] == 1 && !vis[r - 1][c]) {

            solve(maze, r - 1, c, vis);
        }

        // DOWN
        if (r + 1 < n && maze[r + 1][c] == 1 && !vis[r + 1][c])
        {
            solve(maze, r + 1, c, vis);
        }

        // LEFT
        if (c - 1 >= 0 && maze[r][c - 1] == 1 && !vis[r][c - 1])
        {
            solve(maze, r, c - 1, vis);
        }

        // RIGHT
        if (c + 1 < n && maze[r][c + 1] == 1 && !vis[r][c + 1])
        {
            solve(maze, r, c + 1, vis);
        }

        vis[r][c] = false; // Backtracking
    }

    public static void main(String[] args)
    {

        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        int n = maze.length;

        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0)
        {
            System.out.println(0);
            return;
        }

        boolean[][] vis = new boolean[n][n];

        solve(maze, 0, 0, vis);

        System.out.println("Total Paths = " + count);
    }
}