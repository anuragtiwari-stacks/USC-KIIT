package DAY_33;

/*
Problem Name:
Maximum Noise Level In Every Window

Problem Statement:
Abhinab is operating the digital scoreboard during a cricket tournament.

Every minute, the scoreboard records the crowd noise level.

For every group of K consecutive minutes,
Abhinab wants to display the highest recorded noise level.

Help him compute the maximum value for every window.

Input:
N = 8
K = 3

750 820 900 780 910 860 880 790

Output:
900 900 910 910 910 880

Explanation:

Window 1:
750 820 900
Maximum = 900

Window 2:
820 900 780
Maximum = 900

Window 3:
900 780 910
Maximum = 910

Window 4:
780 910 860
Maximum = 910

Window 5:
910 860 880
Maximum = 910

Window 6:
860 880 790
Maximum = 880

Approach:
1. Find the maximum element in the first window.
2. Print the maximum.
3. Slide the window by one position.
4. Find the maximum in the new window.
5. Repeat until all windows are processed.

Time Complexity:
O(N * K)

Space Complexity:
O(1)
*/

public class SlidingWindowMaximum
{
    public static void findMaximumInWindow(int[] arr, int k)
    {
        int n = arr.length;

        int i = 0;
        int j = k - 1;

        // First Window
        int maximum = arr[i];

        for(int x = i; x <= j; x++)
        {
            if(arr[x] > maximum)
            {
                maximum = arr[x];
            }
        }

        System.out.print(maximum + " ");

        i++;
        j++;

        // Remaining Windows
        while(j < n)
        {
            maximum = arr[i];

            for(int x = i; x <= j; x++)
            {
                if(arr[x] > maximum)
                {
                    maximum = arr[x];
                }
            }

            System.out.print(maximum + " ");

            i++;
            j++;
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {750, 820, 900, 780, 910, 860, 880, 790};

        int k = 3;

        System.out.println("Maximum Value In Every Window:");

        findMaximumInWindow(arr, k);
    }
}