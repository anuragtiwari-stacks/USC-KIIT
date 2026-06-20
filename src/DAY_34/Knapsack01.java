package DAY_34;

public class Knapsack01
{
    public static int knapsack(int[] weight, int[] value, int capacity)
    {
        int n = weight.length;

        int[][] dp = new int[n + 1][capacity + 1];

        for(int i = 1; i <= n; i++)
        {
            for(int w = 1; w <= capacity; w++)
            {
                if(weight[i - 1] <= w)
                {
                    int take = value[i - 1] + dp[i - 1][w - weight[i - 1]];

                    int notTake = dp[i - 1][w];

                    dp[i][w] = Math.max(take, notTake);
                }
                else
                {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args)
    {
        int[] weight = {1, 3, 4, 5};
        int[] value = {1, 4, 5, 7};

        int capacity = 7;

        System.out.println("Maximum Profit = " + knapsack(weight, value, capacity));
    }
}