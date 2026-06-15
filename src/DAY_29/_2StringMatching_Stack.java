package DAY_29;

import java.util.Stack;

public class _2StringMatching_Stack
{
    public static String cleanCaption(String s)
    {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            if (!st.isEmpty() && st.peek() == ch)
            {
                st.pop();
            }
            else
            {
                st.push(ch);
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty())
        {
            ans.append(st.pop());
        }

        ans.reverse();

        if (ans.length() == 0)
        {
            return "EMPTY";
        }

        return ans.toString();
    }

    public static void main(String[] args)
    {
        String s = "abbaca";   // predefined input

        System.out.println(cleanCaption(s));
    }
}