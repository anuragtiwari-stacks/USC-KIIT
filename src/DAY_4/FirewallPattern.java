package DAY_4;

public class FirewallPattern
{
    public static void printPattern(int n)
    {
        for (int i = 1; i <= n; i++)
        {
            // Left increasing numbers
            for (int j = 1; j <= i; j++)
            {
                System.out.print(j);
            }

            // Middle @ symbols
            int atCount = 2 * (n - i);

            for (int j = 1; j <= atCount; j++)
            {
                System.out.print("@");
            }

            // Right decreasing numbers
            for (int j = i; j >= 1; j--)
            {
                System.out.print(j);
            }

            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        int n = 5;

        printPattern(n);
    }
}