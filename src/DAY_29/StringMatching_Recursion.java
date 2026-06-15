package DAY_29;

public class StringMatching_Recursion
{
    public static String cleanCaption(String s)
    {
        StringBuilder sb = new StringBuilder();

        int i = 0;

        while (i < s.length())
        {
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1))
            {
                i += 2; // remove adjacent pair
            }
            else
            {
                sb.append(s.charAt(i));
                i++;
            }
        }

        String newString = sb.toString();

        if (newString.equals(s))
        {
            if (newString.length() == 0)
            {
                return "EMPTY";
            }

            return newString;
        }

        return cleanCaption(newString);
    }

    public static void main(String[] args)
    {
        String s = "abbaca";

        System.out.println(cleanCaption(s));
    }
}