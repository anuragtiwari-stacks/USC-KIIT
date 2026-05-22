package DAY_5;/*
Problem Statement
During exam week, Sneha is trying to find the quietest seats in the college library.

The library is represented as an N × N matrix where:

1 represents an occupied seat

0 represents an empty seat

Sneha believes students sitting next to each other will start gossiping instead of studying.

So, an empty seat becomes disturbed if at least one of its neighboring seats
(top, bottom, left, or right) is occupied.

Help Sneha mark the library seats using:

O → Occupied seat

X → Disturbed seat

S → Safe empty seat
*/

public class LibrarySeats
{
    public static void markLibrarySeats(int[][] arr, int n)
    {
        char[][] result = new char[n][n];

        // First mark all seats
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(arr[i][j] == 1)
                {
                    result[i][j] = 'O';
                }
                else
                {
                    result[i][j] = 'S';
                }
            }
        }

        // Traverse occupied seats and mark neighbors
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(arr[i][j] == 1)
                {
                    // Bottom
                    if(i + 1 < n && arr[i + 1][j] == 0)
                    {
                        result[i + 1][j] = 'X';
                    }

                    // Top
                    if(i - 1 >= 0 && arr[i - 1][j] == 0)
                    {
                        result[i - 1][j] = 'X';
                    }

                    // Right
                    if(j + 1 < n && arr[i][j + 1] == 0)
                    {
                        result[i][j + 1] = 'X';
                    }

                    // Left
                    if(j - 1 >= 0 && arr[i][j - 1] == 0)
                    {
                        result[i][j - 1] = 'X';
                    }
                }
            }
        }

        // Print final matrix
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.print(result[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        int[][] arr =
                {
                        {1, 0, 0},
                        {0, 0, 1},
                        {0, 0, 0}
                };

        int n = arr.length;

        markLibrarySeats(arr, n);
    }
}