/*
Question

While exploring an ancient temple, Poulam discovered a mysterious treasure chest
protected by a magical number lock.

The lock opens only when:
Three numbers from the given list add up exactly to the target value K.

If such a triplet exists,
the treasure chest unlocks successfully.

Help Poulam determine whether the treasure can be opened.
Input Format
- The first line contains an integer N
  representing the number of values.
- The second line contains N space-separated integers.
- The third line contains an integer K
  representing the target value.

Output Format
- Print "YES" if any triplet sum equals K.
- Otherwise print "NO".

Input
6
1 4 6 8 10 45
22

Output
YES
*/

package DAY_10;

import java.util.Arrays;

public class TreasureLock
{
    public static boolean findTriplet(int[] arr, int k)
    {
        Arrays.sort(arr);

        int n = arr.length;

        for (int i = 0; i < n - 2; i++)
        {
            int left = i + 1;
            int right = n - 1;

            while (left < right)
            {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == k)
                {
                    return true;
                }

                else if (sum < k)
                {
                    left++;
                }

                else
                {
                    right--;
                }
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 4, 6, 8, 10, 45};

        int k = 22;

        boolean ans = findTriplet(arr, k);

        if (ans)
        {
            System.out.println("YES");
        }

        else
        {
            System.out.println("NO");
        }
    }
}