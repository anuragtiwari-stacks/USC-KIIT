package DAY_13;

import java.util.*;

// Reverse Words In A String

public class ReverseWordsInAString
{
    public static void main(String[] args)
    {
        String s = "  the   sky is   blue  ";

        s = s.trim();

        String[] arr = s.split("\\s+");

        int left = 0;
        int right = arr.length - 1;

        while (left < right)
        {
            String temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < arr.length; i++)
        {
            ans.append(arr[i]);

            if (i != arr.length - 1)
            {
                ans.append(" ");
            }
        }
        System.out.println(ans);
    }
}