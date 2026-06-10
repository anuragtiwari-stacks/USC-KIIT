package DAY_24;

public class MaxSumInSubArray
{
    public static int longestSubarray(int[] arr, int W)
    {
        int left = 0;
        int sum = 0;
        int maxLength = 0;

        for(int right = 0; right < arr.length; right++)
        {
            sum = sum + arr[right];

            while(sum > W)
            {
                sum = sum - arr[left];
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args)
    {
        int[] arr = {3, 1, 2, 4, 5, 1};
        int W = 10;

        System.out.println(longestSubarray(arr, W));
    }
}