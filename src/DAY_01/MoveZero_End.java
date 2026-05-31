/*
Given an integer array,
move all the zeroes to the end of the array while maintaining the relative order of the non-zero elements.

Your task is to create a new array where:
all non-zero elements appear first in the same order,
followed by all zeroes at the end.
*/
package DAY_01;

public class MoveZero_End
{
    public static int[] moveZeroes(int[] arr)
    {
        int n = arr.length;
        int[] brr = new int[n];
        int index = 0;
        int count = 0;

        for(int i = 0; i < n; i++)
        {
            if(arr[i] != 0)
            {
                brr[index] = arr[i];
                index++;
            }

            if(arr[i] == 0)
            {
                count++;
            }
        }

        for(int i = 1; i <= count; i++)
        {
            brr[index] = 0;
            index++;
        }

        return brr;
    }

    public static void printArray(int[] arr)
    {
        for(int num : arr)
        {
            System.out.print(num + " ");
        }

        System.out.println();
    }

    public static void main(String[] args)
    {

        int[] arr1 = {0, 1, 0, 3, 12};
        printArray(moveZeroes(arr1));

        int[] arr2 = {4, 0, 5, 0, 0, 7};
        printArray(moveZeroes(arr2));
    }
}

/*
package DAY_1;

import java.util.ArrayList;

public class MoveZero_End
{

    public static ArrayList<Integer> moveZeroes(ArrayList<Integer> arr)
    {

        ArrayList<Integer> result = new ArrayList<>();

        int count = 0;

        // Add non-zero elements
        for (int i = 0; i < arr.size(); i++)
        {
            if (arr.get(i) != 0)
            {
                result.add(arr.get(i));
            }
            else
            {
                count++;
            }
        }

        // Add zeroes at the end
        for (int i = 1; i <= count; i++)
        {
            result.add(0);
        }

        return result;
    }

    public static void printArrayList(ArrayList<Integer> list)
    {

        for (int num : list)
        {
            System.out.print(num + " ");
        }

        System.out.println();
    }

    public static void main(String[] args)
    {

        // Example 1
        ArrayList<Integer> arr1 = new ArrayList<>();

        arr1.add(0);
        arr1.add(1);
        arr1.add(0);
        arr1.add(3);
        arr1.add(12);

        System.out.print("Before: ");
        printArrayList(arr1);

        ArrayList<Integer> result1 = moveZeroes(arr1);

        System.out.print("After : ");
        printArrayList(result1);


        // Example 2
        ArrayList<Integer> arr2 = new ArrayList<>();

        arr2.add(4);
        arr2.add(0);
        arr2.add(5);
        arr2.add(0);
        arr2.add(0);
        arr2.add(7);

        System.out.print("Before: ");
        printArrayList(arr2);

        ArrayList<Integer> result2 = moveZeroes(arr2);

        System.out.print("After : ");
        printArrayList(result2);
    }
}
*/