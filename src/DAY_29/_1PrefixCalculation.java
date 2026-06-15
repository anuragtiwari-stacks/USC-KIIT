package DAY_29;

import java.util.Stack;

public class _1PrefixCalculation
{
    public static int evaluate(String s)
    {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();

        int n = s.length();

        for (int i = 0; i < n; i++)
        {
            char ch = s.charAt(i);

            if (ch == ' ')
            {
                continue;
            }

            if (Character.isDigit(ch))
            {
                int num = 0;

                while (i < n && Character.isDigit(s.charAt(i)))
                {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }

                numStack.push(num);
                i--;
            }
            else
            {
                while (!opStack.isEmpty() &&
                        precedence(opStack.peek()) >= precedence(ch))
                {
                    solve(numStack, opStack);
                }

                opStack.push(ch);
            }
        }

        while (!opStack.isEmpty())
        {
            solve(numStack, opStack);
        }

        return numStack.peek();
    }

    private static void solve(Stack<Integer> nums,
                              Stack<Character> ops)
    {
        int v2 = nums.pop();
        int v1 = nums.pop();
        char op = ops.pop();

        if (op == '+')
        {
            nums.push(v1 + v2);
        }
        else if (op == '-')
        {
            nums.push(v1 - v2);
        }
        else if (op == '*')
        {
            nums.push(v1 * v2);
        }
        else if (op == '/')
        {
            nums.push(v1 / v2);
        }
    }

    private static int precedence(char op)
    {
        if (op == '+' || op == '-')
        {
            return 1;
        }

        if (op == '*' || op == '/')
        {
            return 2;
        }

        return 0;
    }

    public static void main(String[] args)
    {
        String expr = "12+3*4-20/5";

        System.out.println(evaluate(expr));
    }
}