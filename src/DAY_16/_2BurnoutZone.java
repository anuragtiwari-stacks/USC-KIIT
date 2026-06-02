package DAY_16;/*
========================================================
Problem Statement

Aroosa is preparing for placements and tracks the
number of hours she spends studying every day.

She believes she is entering a burnout zone if there
exists a continuous streak of exactly K consecutive
days such that:

1. The total study hours during those K days is
   at least X.

2. She studied on every day of that streak
   (no day has 0 hours).

Help Aroosa determine whether such a streak exists.

--------------------------------------------------------
Example
--------------------------------------------------------

Input:
7 3 15

4 5 7 2 8 1 9

Output:
YES

Explanation:

First window of size 3:
4 5 7

Sum = 16

Since:
16 >= 15
and all values are non-zero

Answer = YES
========================================================
*/


public class _2BurnoutZone
{
    public static String burnoutZone(int[] arr, int k, int x)
    {
        int n = arr.length;
        int i = 0;
        int j = k - 1;

        int windowSum = 0;
        boolean valid = true;

        for(int idx = i; idx <= j; idx++)
        {
            if(arr[idx] == 0)
            {
                valid = false;
            }

            windowSum = windowSum + arr[idx];
        }

        if(windowSum >= x && valid)
        {
            return "YES";
        }

        i++;
        j++;


        while(j < n)
        {
            valid = true;
            for(int idx = i; idx <= j; idx++)
            {
                if(arr[idx] == 0)
                {
                    valid = false;
                }
            }

            windowSum = windowSum + arr[j] - arr[i - 1];

            if(windowSum >= x && valid)
            {
                return "YES";
            }

            i++;
            j++;
        }

        return "NO";
    }

    public static void main(String[] args)
    {
        int[] arr = {4, 5, 7, 2, 8, 1, 9};
        int k = 3;
        int x = 15;

        String ans = burnoutZone(arr, k, x);
        System.out.println(ans);
    }
}