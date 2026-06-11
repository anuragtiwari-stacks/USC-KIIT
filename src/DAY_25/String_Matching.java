package DAY_25;

import java.util.HashMap;

public class String_Matching
{
    public static String smallestGroup(String s, String t)
    {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for(char ch : t.toCharArray())
        {
            if(need.containsKey(ch))
            {
                need.put(ch, need.get(ch) + 1);
            }
            else
            {
                need.put(ch, 1);
            }
        }

        int left = 0;

        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        for(int right = 0; right < s.length(); right++)
        {
            char ch = s.charAt(right);

            if(need.containsKey(ch))
            {
                if(window.containsKey(ch))
                {
                    window.put(ch, window.get(ch) + 1);
                }
                else
                {
                    window.put(ch, 1);
                }
            }

            while(isValid(need, window))
            {
                int currentLength = right - left + 1;

                if(currentLength < minLength)
                {
                    minLength = currentLength;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);

                if(window.containsKey(leftChar))
                {
                    window.put(leftChar, window.get(leftChar) - 1);
                }

                left++;
            }
        }

        if(minLength == Integer.MAX_VALUE)
        {
            return "-1";
        }

        return s.substring(startIndex, startIndex + minLength);
    }

    public static boolean isValid(HashMap<Character, Integer> need, HashMap<Character, Integer> window)
    {
        for(char ch : need.keySet())
        {
            if(!window.containsKey(ch))
            {
                return false;
            }

            if(window.get(ch) < need.get(ch))
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args)
    {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(smallestGroup(s, t));
    }
}