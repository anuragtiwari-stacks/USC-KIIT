package DAY_38;

import java.util.ArrayList;
import java.util.List;

public class Combination
{
    public static void generateCombinations(int start, int n, int k, List<Integer> current, List<List<Integer>> result)
    {
        if (current.size() == k)
        {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++)
        {
            current.add(i);

            generateCombinations(i + 1, n, k, current, result);

            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args)
    {
        int n = 4;
        int k = 2;

        List<List<Integer>> result = new ArrayList<>();

        generateCombinations(1, n, k, new ArrayList<>(), result);

        System.out.println(result);
    }
}