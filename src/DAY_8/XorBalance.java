package DAY_8;

public class XorBalance
{
    public static void checkBalance(int[] arr)
    {
        int xor = 0;

        for (int num : arr)
        {
            xor = xor ^ num;
        }

        if (xor == 0)
        {
            System.out.println("BALANCED");
        }
        else
        {
            System.out.println("UNBALANCED");
        }
    }

    public static void main(String[] args)
    {
        int[] braceletIDs = {4, 1, 1, 7, 7, 4};

        checkBalance(braceletIDs);
    }
}

/*
During the annual college fest, every student entering the concert arena
receives a digital bracelet with a unique numeric code.

The scanner continuously combines all bracelet IDs using XOR.

Rules:
- If final XOR value becomes 0 -> BALANCED
- Otherwise -> UNBALANCED

Important XOR Property:
a ^ a = 0

So duplicate bracelet IDs cancel each other.

Sample Input
4 1 1 7 7 4

Sample Output
BALANCED

Explanation
4 ^ 1 ^ 1 ^ 7 ^ 7 ^ 4 = 0
*/