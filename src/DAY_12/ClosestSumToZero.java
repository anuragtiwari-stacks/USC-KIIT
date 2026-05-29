package DAY_12;
// Hritika was working in her college science lab on a special temperature balancing machine.
//
// The machine recorded both:
// negative temperatures
// positive temperatures
//
// To stabilize the system, Hritika needed to find:
// Two temperature values whose sum is closest to zero.
//
// Help Hritika identify the required pair.

import java.util.Arrays;

public class ClosestSumToZero
{
    public static void main(String[] args)
    {
        int[] arr = {-8, -4, -1, 2, 10, 6};

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        int minSum = Integer.MAX_VALUE;

        int first = 0;
        int second = 0;

        while (left < right)
        {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < Math.abs(minSum))
            {
                minSum = sum;
                first = arr[left];
                second = arr[right];
            }

            if (sum < 0)
            {
                left++;
            }
            else
            {
                right--;
            }
        }

        System.out.println("Pair Closest To Zero:");
        System.out.println(first + " " + second);
    }
}