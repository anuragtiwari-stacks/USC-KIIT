package DAY_31;

import java.util.*;

public class VisiblePeopleInQueue
{
    public static int[] visiblePeople(int[] heights)
    {
        int n = heights.length;

        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i = n - 1; i >= 0; i--)
        {
            int count = 0;

            while(!stack.isEmpty() && heights[i] > stack.peek())
            {
                stack.pop();
                count++;
            }

            if(!stack.isEmpty())
            {
                count++;
            }

            result[i] = count;

            stack.push(heights[i]);
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] heights = {10, 6, 8, 5, 11, 9};

        int[] result = visiblePeople(heights);

        System.out.println("Visible People Count : " + Arrays.toString(result));
    }
}