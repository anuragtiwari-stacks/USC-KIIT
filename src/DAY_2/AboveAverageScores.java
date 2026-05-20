/*
Nitin is a huge cricket fan and never misses a match.
During the IPL season, his professor assigns him n batting scores from different matches.

Nitin notices that some players scored more than the team's average.
He wants to find out exactly how many players beat the team average
so he can argue with his friends about who the real MVP is.

Your task is to help Nitin determine how many players scored
strictly above the average of all n scores.
*/

package DAY_2;

public class AboveAverageScores
{
    public static int countAboveAverage(int[] arr)
    {
        int sum = 0;

        for(int i=0; i<arr.length; i++)
        {
            sum = sum+arr[i];
        }

        double avg = (double) sum/arr.length;

        int count = 0;

        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]>avg)
            {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        int[] arr1 = {50, 60, 70, 80, 90};
        System.out.println(countAboveAverage(arr1));

        int[] arr2 = {100, 100, 100};
        System.out.println(countAboveAverage(arr2));
    }
}