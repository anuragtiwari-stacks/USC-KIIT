package DAY_15;

import java.util.Arrays;

public class _2RescueBoatPairing
{

    /*
        🔗 Tannu and the Rescue Boat Pairing

        Tannu is evacuating people from an island using rescue boats.
        Each boat can carry exactly 2 people.

        The load of a boat is:
        sum of weights of the two assigned people.

        Goal:
        Pair people in such a way that
        the maximum boat load becomes minimum.

        ------------------------------------------------
        Input:
        [70, 50, 80, 60, 40, 90]

        Output:
        130
        ------------------------------------------------

        Explanation:

        Sorted:
        [40, 50, 60, 70, 80, 90]

        Pair lightest with heaviest:

        40 + 90 = 130
        50 + 80 = 130
        60 + 70 = 130

        Maximum load = 130
    */

    public static void main(String[] args)
    {

        int[] weights = {70, 50, 80, 60, 40, 90};

        Arrays.sort(weights);

        int left = 0;
        int right = weights.length - 1;

        int maxLoad = 0;

        while (left < right)
        {
            int currentLoad = weights[left] + weights[right];

            maxLoad = Math.max(maxLoad, currentLoad);

            left++;
            right--;
        }
        System.out.println(maxLoad);
    }
}