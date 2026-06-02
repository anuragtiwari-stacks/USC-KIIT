/*
Problem Statement

During his college fest, Aditya collected badges from
various events held across the campus. Some of these
badges belonged to premium events organized by the
college committee.

Each premium badge type is represented by a unique
character in a string called jewels.

The complete collection of badges gathered by Aditya
is represented by another string called stones.

Your task is to determine how many badges in the
collection are premium badges.

Note:
Characters are case-sensitive, which means
'a' and 'A' are considered different badge types.

--------------------------------------------------------
Example
--------------------------------------------------------
jewels = "aA"
stones = "aAAbbbb"

Output:
3

Explanation:
Premium badges are:
a and A

In stones:
a -> 1 time
A -> 2 times
Total premium badges = 3
*/

package DAY_16;

import java.util.*;

public class JewelsAndStones
{
    public static int numJewelsInStones(String jewels, String stones)
    {
        Map<Character,Integer> jewelmap = new HashMap<>();

        for(int i=0;i<jewels.length();i++)
        {
            char ch = jewels.charAt(i);
            if(!jewelmap.containsKey(ch))
            {
                jewelmap.put(ch,1);
            }
            else
            {
                jewelmap.put(ch,jewelmap.get(ch)+1);
            }
        }

        Map<Character,Integer> stonemap = new HashMap<>();

        int count = 0;
        for(int i=0;i<stones.length();i++)
        {
            char ch = stones.charAt(i);

            if(jewelmap.containsKey(ch))
            {
                if(!stonemap.containsKey(ch))
                {
                    jewelmap.put(ch,1);
                    count++;
                }
                else
                {
                    jewelmap.put(ch,jewelmap.get(ch)+1);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        String jewels = "aA";
        String stones = "aAAbbbb";

        int ans = numJewelsInStones(jewels, stones);

        System.out.println("Total Premium Badges : " + ans);
    }
}