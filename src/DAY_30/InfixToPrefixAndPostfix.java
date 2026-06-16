package DAY_30;

import java.util.*;

public class InfixToPrefixAndPostfix
{
    public static int precedence(char ch)
    {
        if(ch == '^')
        {
            return 3;
        }

        if(ch == '*' || ch == '/')
        {
            return 2;
        }

        if(ch == '+' || ch == '-')
        {
            return 1;
        }

        return -1;
    }

    public static String infixToPostfix(String infix)
    {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for(int i = 0; i < infix.length(); i++)
        {
            char ch = infix.charAt(i);

            if(Character.isLetterOrDigit(ch))
            {
                postfix.append(ch);
            }
            else if(ch == '(')
            {
                stack.push(ch);
            }
            else if(ch == ')')
            {
                while(!stack.isEmpty() && stack.peek() != '(')
                {
                    postfix.append(stack.pop());
                }

                stack.pop();
            }
            else
            {
                while(!stack.isEmpty() &&
                        precedence(stack.peek()) >= precedence(ch))
                {
                    postfix.append(stack.pop());
                }

                stack.push(ch);
            }
        }

        while(!stack.isEmpty())
        {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static String infixToPrefix(String infix)
    {
        String reversed = new StringBuilder(infix).reverse().toString();

        char[] arr = reversed.toCharArray();

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == '(')
            {
                arr[i] = ')';
            }
            else if(arr[i] == ')')
            {
                arr[i] = '(';
            }
        }

        String modified = new String(arr);

        String postfix = infixToPostfix(modified);

        return new StringBuilder(postfix).reverse().toString();
    }

    public static void main(String[] args)
    {
        String infix = "(A-B/C)*(A/K-L)";

        System.out.println("Infix Expression   : " + infix);

        String prefix = infixToPrefix(infix);
        System.out.println("Prefix Expression  : " + prefix);

        String postfix = infixToPostfix(infix);
        System.out.println("Postfix Expression : " + postfix);
    }
}