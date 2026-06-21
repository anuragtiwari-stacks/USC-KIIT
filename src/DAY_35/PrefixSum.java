package DAY_35;

import java.util.Arrays;

public class PrefixSum
{
    public static int countEligibleStudents(int[] scores, int k)
    {
        Arrays.sort(scores);

        int n = scores.length;

        int[] prefix = new int[n];
        prefix[0] = scores[0];

        for (int i = 1; i < n; i++)
        {
            prefix[i] = prefix[i - 1] + scores[i];
        }

        int count = 0;

        for (int i = 1; i < n; i++)
        {
            if (prefix[i - 1] >= k)
            {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        int[] scores = {10, 20, 30, 40, 50};
        int k = 60;

        System.out.println(countEligibleStudents(scores, k));
    }
}