/*
Ansuman recently joined as a volunteer at his college tech fest.
At the main entrance, a digital security system checks a sequence of alarm codes before allowing entry.

The system follows one important rule:
No two consecutive alarm codes should be identical.

If the same code appears back-to-back, the system raises an alert.

Help Ansuman determine:
- If no adjacent elements are the same → print "VALID"
- Otherwise → print "INVALID" along with the first index where repetition occurs.
*/

package DAY_03;

public class AlarmCodeValidator
{
    public static String checkCodes(int[] arr)
    {
        for(int i=1; i<arr.length; i++)
        {
            if(arr[i] == arr[i - 1])
            {
                return "INVALID " + i;
            }
        }

        return "VALID";
    }

    public static void main(String[] args)
    {
        int[] arr1 = {1, 2, 2, 3, 4};
        System.out.println(checkCodes(arr1));

        int[] arr2 = {5, 6, 7, 8};
        System.out.println(checkCodes(arr2));
    }
}