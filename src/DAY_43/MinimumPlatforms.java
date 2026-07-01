package DAY_43;

import java.util.*;

public class MinimumPlatforms
{
    public static int minimumPlatforms(int[] arrival, int[] departure)
    {
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int i = 0;
        int j = 0;

        int platforms = 0;
        int maxPlatforms = 0;

        while (i < arrival.length && j < departure.length)
        {
            if (arrival[i] <= departure[j])
            {
                platforms++;

                if (platforms > maxPlatforms)
                {
                    maxPlatforms = platforms;
                }

                i++;
            }
            else
            {
                platforms--;
                j++;
            }
        }

        return maxPlatforms;
    }

    public static void main(String[] args)
    {
        int[] arrival =
                {
                        900, 940, 950, 1100, 1500, 1800
                };

        int[] departure =
                {
                        910, 1200, 1120, 1130, 1900, 2000
                };

        System.out.println("Minimum Platforms Required = " + minimumPlatforms(arrival, departure));
    }
}