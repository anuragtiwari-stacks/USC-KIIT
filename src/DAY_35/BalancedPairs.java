package DAY_35;

/*
Problem Statement

Sushree manages package deliveries between multiple cities. Each package has a weight associated with it.
A pair of packages is considered balanced if the sum of their weights is exactly X.
Help Sushree determine the number of unique balanced pairs that can be formed.
Two pairs are considered the same if they contain the same pair of weights,
regardless of their positions in the array.

Input:
N = 6, X = 10
Weights = {1, 4, 7, 5, 5, 9}

Output:
2

Explanation:
Unique pairs whose sum is 10:
(1, 9)
(5, 5)

Therefore, the answer is 2.
*/

import java.util.HashMap;
import java.util.HashSet;

public class BalancedPairs
{
    public static int countUniquePairs(int[] weights, int x)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<String> pairs = new HashSet<>();

        for (int weight : weights)
        {
            int need = x - weight;

            if (map.containsKey(need))
            {
                int first = Math.min(weight, need);
                int second = Math.max(weight, need);

                pairs.add(first + "," + second);
            }

            map.put(weight, 1);
        }

        return pairs.size();
    }

    public static void main(String[] args)
    {
        int[] weights = {1, 4, 7, 5, 5, 9};
        int x = 10;

        int result = countUniquePairs(weights, x);

        System.out.println(result);
    }
}