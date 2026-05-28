package DAY_10;/*

Question
You are given an array of strings products and a string searchWord.

Design a system that suggests at most three product names from products after each character of searchWord is typed.

Suggested products should have common prefix with searchWord.

If there are more than three products with a common prefix return the three lexicographically minimum products.

Return a list of lists of the suggested products after each character of searchWord is typed.

Example

Input
products = ["mobile","mouse","moneypot","monitor","mousepad"]
searchWord = "mouse"

Output
[
 [mobile,moneypot,monitor],
 [mobile,moneypot,monitor],
 [mouse,mousepad],
 [mouse,mousepad],
 [mouse,mousepad]
]
*/
import java.util.*;
public class LexicographicalSort
{
    public static List<List<String>> suggestedProducts(String[] products, String searchWord)
    {
        Arrays.sort(products);

        List<List<String>> result = new ArrayList<>();

        String prefix = "";

        for (int i = 0; i < searchWord.length(); i++)
        {
            prefix += searchWord.charAt(i);

            List<String> temp = new ArrayList<>();

            for (String product : products)
            {
                if (product.startsWith(prefix))
                {
                    temp.add(product);
                }

                if (temp.size() == 3)
                {
                    break;
                }
            }

            result.add(temp);
        }

        return result;
    }

    public static void main(String[] args)
    {
        String[] products =
                {
                        "mobile",
                        "mouse",
                        "moneypot",
                        "monitor",
                        "mousepad"
                };

        String searchWord = "mouse";

        List<List<String>> ans = suggestedProducts(products, searchWord);

        System.out.println(ans);
    }
}