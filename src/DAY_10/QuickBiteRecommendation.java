/*
Question

QuickBite is a rapidly growing food delivery company operating across multiple cities.

The platform stores thousands of restaurant names in its database.

Whenever a customer types a few letters into the search bar,
the app should instantly display all matching restaurant names
so users can quickly place their orders.

The company wants the suggestions to appear in lexicographical order to improve the user experience.

Help the QuickBite engineering team and Nishita build this auto-suggestion feature.

Input Format
- First line contains integer N representing the number of restaurants.
- Next N lines contain restaurant names.
- Last line contains the search prefix.

Output Format
- Print all restaurant names matching the given prefix in lexicographical order.

Input
7

pizzapalace
pizzahub
pizzaworld
burgervilla
pizzacity
pastahouse
pizzaverse

pizza

Output
pizzacity
pizzahub
pizzapalace
pizzaverse
pizzaworld
*/

package DAY_10;

import java.util.Arrays;

public class QuickBiteRecommendation
{
    public static void main(String[] args)
    {
        String[] restaurants =
                {
                        "pizzapalace",
                        "pizzahub",
                        "pizzaworld",
                        "burgervilla",
                        "pizzacity",
                        "pastahouse",
                        "pizzaverse"
                };

        String prefix = "pizza";

        Arrays.sort(restaurants);

        for (String name : restaurants)
        {
            if (name.startsWith(prefix))
            {
                System.out.println(name);
            }
        }
    }
}