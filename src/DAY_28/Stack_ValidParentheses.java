package DAY_28;/*
LeetCode 20 - Valid Parentheses

Given a string s containing just the characters:
'(', ')', '{', '}', '[' and ']',

Determine if the input string is valid.

A string is valid if:
1. Open brackets are closed by the same type of brackets.
2. Open brackets are closed in the correct order.
3. Every closing bracket has a corresponding opening bracket.

Time Complexity  : O(n)
Space Complexity : O(n)
*/

import java.util.*;

public class Stack_ValidParentheses
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

            if(ch == ']')
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

            if(ch == ')')
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

            if(ch == '}')
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
        String[] testCases =
                {
                        "()[]{}",   // true
                        "(]",       // false
                        "([)]",     // false
                        "{[]}",     // true
                        "(((",      // false
                        "]"         // false
                };

        for(String s : testCases)
        {
            System.out.println("Input  : " + s);
            System.out.println("Output : " + isValid(s));
            System.out.println();
        }
    }
}