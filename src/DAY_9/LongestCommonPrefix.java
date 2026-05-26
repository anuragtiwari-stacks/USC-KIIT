package DAY_9;

import java.util.Arrays;

public class LongestCommonPrefix
{
    public static String findPrefix(String[] arr)
    {
        Arrays.sort(arr);

        String first = arr[0];
        String last = arr[arr.length - 1];

        int i = 0;

        while (i < first.length() && i < last.length())
        {
            if (first.charAt(i) != last.charAt(i))
            {
                break;
            }

            i++;
        }

        return first.substring(0, i);
    }

    public static void main(String[] args)
    {
        String[] arr = {"flower", "flow", "flight"};

        String ans = findPrefix(arr);

        System.out.println(ans);
    }
}

/*
Input
flower
flow
flight

Output
fl
*/