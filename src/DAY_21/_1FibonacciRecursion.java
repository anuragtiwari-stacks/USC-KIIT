package DAY_21;

public class _1FibonacciRecursion
{
    public static int fib(int n)
    {
        if(n == 0 || n == 1)
        {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args)
    {
        int n = 6;

        System.out.println("Fibonacci Number = " + fib(n));
    }
}
