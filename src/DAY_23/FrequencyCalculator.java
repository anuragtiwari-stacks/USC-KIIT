package DAY_23;

import java.util.HashMap;

/*
Problem Statement:
Ayush is participating in a cybersecurity competition.

For each query [L, R], find the Range Score:

Range Score = Σ (frequency of each number)^2

Example:
Array:
1 2 1 3 2

Queries:
[0,4]
[0,2]
[1,3]

Output:
9
5
3
*/

public class FrequencyCalculator
{
    public static int calculateRangeScore(int[] numbers, int left, int right)
    {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for(int index = left; index <= right; index++)
        {
            if(frequencyMap.containsKey(numbers[index]))
            {
                frequencyMap.put(numbers[index], frequencyMap.get(numbers[index]) + 1);
            }
            else
            {
                frequencyMap.put(numbers[index], 1);
            }
        }

        int rangeScore = 0;

        for(int frequency : frequencyMap.values())
        {
            rangeScore = rangeScore + frequency * frequency;
        }

        return rangeScore;
    }

    public static void processQueries(int[] numbers, int[][] queries)
    {
        for(int query = 0; query < queries.length; query++)
        {
            int left = queries[query][0];
            int right = queries[query][1];

            System.out.println(calculateRangeScore(numbers, left, right));
        }
    }

    public static void main(String[] args)
    {
        int[] numbers =
                {
                        1, 2, 1, 3, 2
                };

        int[][] queries =
                {
                        {0, 4},
                        {0, 2},
                        {1, 3}
                };

        processQueries(numbers, queries);
    }
}