package DAY_11;

public class Sort012
{
    public static void sortArray(int[] arr)
    {

        // Time complexity required is O(N) {linear}
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==0) count0++;
            else if(arr[i]==1) count1++;
            else count2++;
        }

        int index = 0;

        while(count0>0)
        {
            arr[index]=0;
            index++;
            count0--;
        }

        while(count1>0)
        {
            arr[index]=1;
            index++;
            count1--;
        }

        while(count2>0)
        {
            arr[index]=2;
            index++;
            count2--;
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {2, 0, 2, 1, 1, 0};

        sortArray(arr);

        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}
/*
Question

During the annual fest at Sitanshu’s college,
students from different clubs were gathering
for the opening ceremony.

Each student belonged to one of these clubs:

0 → Music Club
1 → Dance Club
2 → Photography Club

Unfortunately, the students were standing in a random order.
The event coordinator asked Sitanshu to arrange the lineup properly so that:

1. all Music Club students stand first
2. followed by Dance Club students
3. and finally Photography Club students

Help Sitanshu sort the club lineup in linear time.

Input
2 0 2 1 1 0

Output
0 0 1 1 2 2
*/