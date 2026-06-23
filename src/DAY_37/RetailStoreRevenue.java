package DAY_37;

import java.util.HashMap;

public class RetailStoreRevenue
{
    public static int countSubarraysWithSumK(int[] arr, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for(int num : arr)
        {
            prefixSum += num;

            if(map.containsKey(prefixSum - k))
            {
                count += map.get(prefixSum - k);
            }

            if(map.containsKey(prefixSum))
            {
                map.put(prefixSum, map.get(prefixSum) + 1);
            }
            else
            {
                map.put(prefixSum, 1);
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        int[] revenue = {1, -1, 5, -2, 3};
        int k = 3;

        System.out.println(countSubarraysWithSumK(revenue, k));
    }
}