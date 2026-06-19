package DAY_31;

import java.util.*;

public class ValidParentheses
{
    public static boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            if(ch == '(' || ch == '{' || ch == '[')
            {
                stack.push(ch);
            }

            else if(ch == ']')
            {
                if(stack.isEmpty())
                {
                    return false;
                }

                char top = stack.pop();

                if(top != '[')
                {
                    return false;
                }
            }

            else if(ch == ')')
            {
                if(stack.isEmpty())
                {
                    return false;
                }

                char top = stack.pop();

                if(top != '(')
                {
                    return false;
                }
            }

            else if(ch == '}')
            {
                if(stack.isEmpty())
                {
                    return false;
                }

                char top = stack.pop();

                if(top != '{')
                {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args)
    {
        String s = "{[()]}";

        boolean result = isValid(s);

        System.out.println("Is Valid Parentheses : " + result);
    }
}