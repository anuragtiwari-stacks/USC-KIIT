package DAY_37;

import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;

public class CloudServerRequests
{
    public static ArrayList<Integer> getTopKRequests(int[] arr, int k)
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : arr)
        {
            minHeap.offer(num);

            if(minHeap.size() > k)
            {
                minHeap.poll();
            }
        }

        ArrayList<Integer> result = new ArrayList<>(minHeap);
        Collections.sort(result);

        return result;
    }

    public static void main(String[] args)
    {
        int[] priorities = {12, 5, 78, 100, 34, 90, 11, 67};
        int k = 3;

        ArrayList<Integer> answer = getTopKRequests(priorities, k);

        for(int num : answer)
        {
            System.out.print(num + " ");
        }
    }
}