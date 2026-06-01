package DAY_15;

/*
    🔗 Leaderboard Username Sorting Problem

    Shalini is developing a leaderboard system for CodeSprint 3.0.

    The platform stores thousands of usernames submitted
    by participants.

    Usernames must be sorted using these rules:

    1. Usernames having more vowels should come first.

    2. If two usernames have the same number of vowels,
       then the shorter username should come first.

    3. If there is still a tie,
       then lexicographically smaller username should come first.

    ------------------------------------------------

    Example:

    Input:
    [alex, asish, aaron, john, elena]

    Output:
    [aaron, elena, alex, asish, john]

    ------------------------------------------------

    Explanation:

    aaron and elena both have 3 vowels.

    Their lengths are equal,
    so lexicographical order is used.

    aaron comes before elena.

    alex and asish both have 2 vowels.

    alex is shorter,
    so it comes first.
*/

import java.util.*;

public class _1LeaderboardSystem
{
    public static int countVowels(String str)
    {
        int count = 0;

        for (int i = 0; i < str.length(); i++)
        {
            char ch = Character.toLowerCase(str.charAt(i));

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        String[] usernames = {"alex", "asish", "aaron", "john", "elena"};

        ArrayList<String> list = new ArrayList<>();

        for (String str : usernames)
        {
            list.add(str);
        }

        Collections.sort(list, new Comparator<String>()
        {
            /*
                Comparator internally asks:

                Should a come first?
                Should b come first?
                Or are both equal?

                We answer using integer return values.

                -----------------------------------------------
                Return negative value:
                -> a comes first

                Return positive value:
                -> b comes first

                Return 0:
                -> both are equal
            */
            @Override
            public int compare(String a, String b)
            {

                int vowelsA = countVowels(a);
                int vowelsB = countVowels(b);

                // Rule 1 -> More vowels first
                if (vowelsA != vowelsB)
                {
                    return vowelsB - vowelsA;
                }

                // Rule 2 -> Smaller length first
                if (a.length() != b.length())
                {
                    return a.length() - b.length();
                }

                // Rule 3 -> Lexicographical order
                return a.compareTo(b);
            }
        });

        System.out.println(list);
    }
}