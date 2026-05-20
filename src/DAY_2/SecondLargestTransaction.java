/*
Soumya is the treasurer of her college club and handles all reimbursements.
Every time a member spends money, they submit the amount,
and Soumya adds it to a running record of transactions — some are credits (+), and some are debits (-).

At the end of the month,
she needs to find the second largest transaction amount for the audit report
because the largest one is always the annual fest and already accounted for.

Soumya wonders:
What is the next biggest transaction she should be looking at?

Your task is to find the second largest distinct number in the list.
*/

package DAY_2;

public class SecondLargestTransaction
{
    public static int secondLargest(int[] arr)
    {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] > largest)
            {
                secondLargest = largest;
                largest = arr[i];
            }

            else if(arr[i]>secondLargest && arr[i]!=largest)
            {
                secondLargest = arr[i];
            }
        }

        if(secondLargest == Integer.MIN_VALUE)
        {
            return -1;
        }

        return secondLargest;
    }

    public static void main(String[] args)
    {
        int[] arr1 = {10, 20, 30, 40, 50};
        System.out.println(secondLargest(arr1));

        int[] arr2 = {5, 5, 5, 5};
        System.out.println(secondLargest(arr2));
    }
}