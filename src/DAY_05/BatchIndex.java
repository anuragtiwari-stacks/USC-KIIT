package DAY_05;

/*
Problem Statement
Harsh is helping his professor track attendance during a workshop in college.
Students enter the seminar hall batch by batch.

You are given an array where:
arr[i] represents the number of students entering during batch i.

The seminar hall becomes full once the total number of students
inside becomes strictly greater than X.

Your task is to find the first batch index where the hall becomes full.

If the hall never becomes full, print -1.
*/

public class BatchIndex
{
    public static int findBatchIndex(int[] arr, int x)
    {
        int n = arr.length;

        int[] prefix = new int[n];

        prefix[0] = arr[0];

        for(int i = 1; i < n; i++)
        {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for(int i = 0; i < n; i++)
        {
            if(prefix[i] > x)
            {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args)
    {
        int[] arr1 = {10, 15, 20, 5};
        int x1 = 30;

        int ans1 = findBatchIndex(arr1, x1);

        System.out.println(ans1);

        int[] arr2 = {5, 5, 5, 5};
        int x2 = 25;

        int ans2 = findBatchIndex(arr2, x2);

        System.out.println(ans2);
    }
}