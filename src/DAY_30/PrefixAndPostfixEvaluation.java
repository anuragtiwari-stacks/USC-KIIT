package DAY_30;

import java.util.*;

public class PrefixAndPostfixEvaluation
{
    public static int performOperation(int a, int b, char operator)
    {
        if(operator == '+')
        {
            return a + b;
        }

        if(operator == '-')
        {
            return a - b;
        }

        if(operator == '*')
        {
            return a * b;
        }

        if(operator == '/')
        {
            return a / b;
        }

        if(operator == '^')
        {
            return (int)Math.pow(a, b);
        }

        return 0;
    }

    public static int evaluatePostfix(String postfix)
    {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < postfix.length(); i++)
        {
            char ch = postfix.charAt(i);

            if(Character.isDigit(ch))
            {
                stack.push(ch - '0');
            }
            else
            {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                int result = performOperation(operand1, operand2, ch);

                stack.push(result);
            }
        }

        return stack.pop();
    }

    public static int evaluatePrefix(String prefix)
    {
        Stack<Integer> stack = new Stack<>();

        for(int i = prefix.length() - 1; i >= 0; i--)
        {
            char ch = prefix.charAt(i);

            if(Character.isDigit(ch))
            {
                stack.push(ch - '0');
            }
            else
            {
                int operand1 = stack.pop();
                int operand2 = stack.pop();

                int result = performOperation(operand1, operand2, ch);

                stack.push(result);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args)
    {
        String postfix = "23*54*+9-";
        String prefix = "-+*23*549";

        System.out.println("Postfix Expression : " + postfix);
        System.out.println("Postfix Evaluation : " + evaluatePostfix(postfix));

        System.out.println();

        System.out.println("Prefix Expression  : " + prefix);
        System.out.println("Prefix Evaluation  : " + evaluatePrefix(prefix));
    }
}