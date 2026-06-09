package DAY_23;

/*
Problem Statement:
Anish is working on a weather monitoring system for his college research project.

Every day, temperature readings are recorded and stored in an array.
For each query [L, R], find:

    Highest Temperature - Lowest Temperature

within that range.

Input:
Temperatures:
15 20 10 25 18 30 12 22

Queries:
[1,4]
[2,6]
[0,7]

Output:
15
20
20
*/

public class WeatherMonitoringSystem
{
    public static int temperatureDifference(int[] temperatures, int left, int right)
    {
        int maximumTemperature = Integer.MIN_VALUE;
        int minimumTemperature = Integer.MAX_VALUE;

        for(int day = left; day <= right; day++)
        {
            maximumTemperature = Math.max(maximumTemperature, temperatures[day]);
            minimumTemperature = Math.min(minimumTemperature, temperatures[day]);
        }

        return maximumTemperature - minimumTemperature;
    }

    public static void processQueries(int[] temperatures, int[][] queries)
    {
        for(int query = 0; query < queries.length; query++)
        {
            int left = queries[query][0];
            int right = queries[query][1];

            System.out.println(temperatureDifference(temperatures, left, right));
        }
    }

    public static void main(String[] args)
    {
        int[] temperatures = {15, 20, 10, 25, 18, 30, 12, 22};

        int[][] queries =
                {
                        {1, 4},
                        {2, 6},
                        {0, 7}
                };

        processQueries(temperatures, queries);
    }
}