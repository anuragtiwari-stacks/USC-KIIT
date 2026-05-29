package DAY_12;

// Problem Statement
// Given a string, find the longest palindromic substring using Recursion.

public class LongestPalindromicSubstring_Recursive
{
    public static void main(String[] args)
    {
        String str = "babad";

        String ans = solve(str, 0, str.length() - 1);

        System.out.println("Longest Palindromic Substring:");
        System.out.println(ans);
    }

    public static String solve(String str, int i, int j)
    {
        // Base Case
        if (i > j)
        {
            return "";
        }

        // Single Character
        if (i == j)
        {
            return str.charAt(i) + "";
        }

        // Current Substring
        String current = str.substring(i, j + 1);

        // If current substring itself is palindrome
        if (isPalindrome(current))
        {
            return current;
        }

        // Recursive Calls
        String left = solve(str, i + 1, j);

        String right = solve(str, i, j - 1);

        // Return Longer One
        if (left.length() > right.length())
        {
            return left;
        }
        else
        {
            return right;
        }
    }

    public static boolean isPalindrome(String str)
    {
        int left = 0;
        int right = str.length() - 1;

        while (left < right)
        {
            if (str.charAt(left) != str.charAt(right))
            {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}