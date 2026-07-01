package DAY_42;

import java.util.*;

public class CoinChange
{
    public static void coinChange(int[] coins, int amount)
    {
        Arrays.sort(coins);

        ArrayList<Integer> result = new ArrayList<>();

        int count = 0;

        for (int i = coins.length - 1; i >= 0; i--)
        {
            while (amount >= coins[i])
            {
                amount = amount - coins[i];
                result.add(coins[i]);
                count++;
            }
        }

        System.out.println("Coins Used:");

        for (int coin : result)
        {
            System.out.print(coin + " ");
        }

        System.out.println();

        System.out.println("Minimum Coins = " + count);
    }

    public static void main(String[] args)
    {
        int[] coins =
                {
                        1, 2, 5, 10, 20, 50, 100, 500
                };

        int amount = 289;

        coinChange(coins, amount);
    }
}