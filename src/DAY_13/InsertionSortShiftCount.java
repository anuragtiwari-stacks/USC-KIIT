package DAY_13;

import java.util.*;

// Insertion Sort - Count Total Shifts

public class InsertionSortShiftCount
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 4, 5, 3, 6};

        int shifts = 0;

        // Insertion Sort
        for (int i = 1; i < arr.length; i++)
        {
            int current = arr[i];

            int j = i - 1;

            while (j >= 0 && arr[j] > current)
            {
                arr[j + 1] = arr[j];

                shifts++;

                j--;
            }

            arr[j + 1] = current;
        }

        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }

        System.out.println(shifts);
    }
}