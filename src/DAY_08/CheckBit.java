package DAY_08;

public class CheckBit
{
    public static void checkAttendance(int roll)
    {
        String binary = Integer.toBinaryString(roll);

        int count = 0;

        // Count ON bits
        for (int i = 0; i < binary.length(); i++)
        {
            if (binary.charAt(i) == '1')
            {
                count++;
            }
        }

        if (count % 2 == 1)
        {
            System.out.println("ANSWER");
        }
        else
        {
            System.out.println("SAFE");
        }
    }

    public static void main(String[] args)
    {
        int[] rollNumbers = {5, 7, 8, 10, 13};

        for (int roll : rollNumbers)
        {
            checkAttendance(roll);
        }
    }
}

/*
- If the binary representation of a roll number contains an odd number of ON bits (1s),
  the student must answer questions in class today.
- Otherwise, the student is considered SAFE.

Sample Input
5 7 8 10 13

Sample Output
SAFE
ANSWER
ANSWER
SAFE
ANSWER
*/