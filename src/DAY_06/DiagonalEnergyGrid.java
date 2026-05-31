/* Prateek discovered an ancient energy grid hidden beneath the CodeSprint 3.0 arena.
The grid contains magical power values arranged in a square matrix.
The grid is considered stable only if:
Sum of main diagonal == Sum of secondary diagonal Print "YES" if both diagonal sums are equal.
Otherwise print "NO".

Main Diagonal Condition: i == j
Secondary Diagonal Condition: i + j == n - 1 */

package DAY_06;

public class DiagonalEnergyGrid
{
    public static String checkGridStability(int[][] arr, int n)
    {
        int Primary = 0;
        int Secondary = 0;

        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n; j++)
            {
                if (i==j)
                {
                    Primary = Primary + arr[i][j];
                }

                if (i+j == n-1)
                {
                    Secondary = Secondary + arr[i][j];
                }
            }
        }

        if (Primary == Secondary)
        {
            return "YES";
        }

        return "NO";
    }

    public static void main(String[] args)
    {
        int[][] arr1 =
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 1}
                };

        int[][] arr2 =
                {
                        {2, 1, 2},
                        {4, 5, 4},
                        {2, 1, 2}
                };

        System.out.println(checkGridStability(arr1, 3));
        System.out.println(checkGridStability(arr2, 3));
    }
}