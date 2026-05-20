package DAY_1;

import java.util.HashSet;

public class DuplicateMarks
{
    public static String checkDuplicate(int[] arr)
    {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < arr.length; i++)
        {
            if(set.contains(arr[i]))
            {
                return "YES";
            }
            set.add(arr[i]);
        }
        return "NO";
    }

    public static void main(String[] args)
    {
        int[] arr1 = {85, 90, 75, 90};
        System.out.println(checkDuplicate(arr1));

        int[] arr2 = {60, 70, 80, 90};
        System.out.println(checkDuplicate(arr2));
    }
}