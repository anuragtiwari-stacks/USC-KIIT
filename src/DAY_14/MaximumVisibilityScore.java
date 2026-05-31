package DAY_14;

public class MaximumVisibilityScore
{

    /*
        🔗 Problem: Maximum Visibility Score

        A grand music concert is taking place in the city, and thousands
        of fans are standing in a long queue.

        Each person in the queue has a different height.

        A VIP camera captures two people at a time:
        - one from the left side
        - one from the right side

        Visibility Score = minimum height of the two people × distance between them

        Find the maximum visibility score possible.

        ---------------------------------------------------

        Input:
        1 8 6 2 5 4 8 3

        Output:
        40

        Explanation:
        Choose heights 8 and 8
        Distance = 5

        Score = min(8, 8) × 5
              = 8 × 5
              = 40
    */

    public static void main(String[] args)
    {

        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3};

        int left = 0;
        int right = arr.length - 1;

        int maxScore = 0;

        while (left < right)
        {

            int height = Math.min(arr[left], arr[right]);

            int width = right - left;

            int score = height * width;

            maxScore = Math.max(maxScore, score);

            // Move the smaller height pointer
            if (arr[left] < arr[right])
            {
                left++;
            }
            else
            {
                right--;
            }
        }

        System.out.println("Maximum Visibility Score = " + maxScore);
    }
}