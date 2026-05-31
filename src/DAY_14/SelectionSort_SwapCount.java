package DAY_14;

public class SelectionSort_SwapCount
{

    /*
        🔗 Problem: Selection Sort with Minimum Swaps

        Sanchita is sorting a list of encrypted server IDs.

        Swapping two elements is very expensive, so she wants
        a sorting method that uses as few swaps as possible.

        Use Selection Sort:
        - In every iteration, select the minimum element
          from the unsorted part of the array
        - Place it at its correct position

        Count swaps only when two different positions
        exchange their values.

        ---------------------------------------------------
        Input:
        64 25 12 22 11

        Output:
        11 12 22 25 64
        3

        Explanation:
        Total 3 swaps are required to sort the array.
    */

    public static void main(String[] args)
    {

        int[] arr = {64, 25, 12, 22, 11};

        int n = arr.length;

        int swapCount = 0;

        for (int i = 0; i < n - 1; i++)
        {

            int minIndex = i;

            // Find minimum element
            for (int j = i + 1; j < n; j++)
            {
                if (arr[j] < arr[minIndex])
                {
                    minIndex = j;
                }
            }

            // Swap only if needed
            if (minIndex != i)
            {

                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;

                swapCount++;
            }
        }

        for (int num : arr)
        {
            System.out.print(num + " ");
        }

        System.out.println();

        System.out.println(swapCount);
    }
}