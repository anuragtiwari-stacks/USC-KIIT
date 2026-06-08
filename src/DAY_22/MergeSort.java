package DAY_22;

/*
Question:
Given an array of integers, sort the array using Merge Sort.

Merge Sort follows Divide and Conquer:

1. Divide the array into two halves.
2. Recursively sort both halves.
3. Merge the sorted halves.

Example:

Input:
[5, 2, 8, 1, 3]

Output:
[1, 2, 3, 5, 8]

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

import java.util.Arrays;

public class MergeSort
{

    static void mergeSort(int[] arr, int low, int high)
    {

        if (low >= high)
        {
            return;
        }

        int mid = low + (high - low) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    static void merge(int[] arr, int low, int mid, int high)
    {

        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int k = 0;

        while (left <= mid && right <= high)
        {

            if (arr[left] <= arr[right])
            {
                temp[k++] = arr[left++];
            }
            else
            {
                temp[k++] = arr[right++];
            }
        }

        while (left <= mid)
        {
            temp[k++] = arr[left++];
        }

        while (right <= high)
        {
            temp[k++] = arr[right++];
        }

        for (int i = 0; i < temp.length; i++)
        {
            arr[low + i] = temp[i];
        }
    }

    public static void main(String[] args)
    {

        int[] arr = {5, 2, 8, 1, 3};

        System.out.println("Before Sorting: " + Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("After Sorting : " + Arrays.toString(arr));
    }
}