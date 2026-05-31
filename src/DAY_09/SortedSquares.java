package DAY_09;

import java.util.Arrays;

public class SortedSquares
{
    public static void printSortedSquares(int[] arr)
    {
        int n = arr.length;

        int[] result = new int[n];

        for (int i = 0; i < n; i++)
        {
            result[i] = arr[i] * arr[i];
        }

        Arrays.sort(result);

        for (int num : result)
        {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {-7, -3, -1, 4, 8, 12};

        printSortedSquares(arr);
    }
}

/*
Input
-7 -3 -1 4 8 12

Output
1 9 16 49 64 144
*/