package DAY_12;

public class LongestPalindromicSubstring
{
    public static void main(String[] args)
    {
        String str = "forgeeksskeegfor";

        String longest = "";

        for (int i = 0; i < str.length(); i++)
        {
            for (int j = i; j < str.length(); j++)
            {
                String sub = str.substring(i, j + 1);

                if (isPalindrome(sub))
                {
                    if (sub.length() > longest.length())
                    {
                        longest = sub;
                    }
                }
            }
        }

        System.out.println("Longest Palindromic Substring:");
        System.out.println(longest);
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