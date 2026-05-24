package DAY_7;
import java.util.*;

public class Anagram
{
    public static String checkAnagram(String s1,String s2)
    {
        if(s1.length()!=s2.length())
        {
            return "NO";
        }

        char[] arr1=s1.toCharArray();
        char[] arr2=s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int[] freq=new int[26];

        for(int i=0;i<arr1.length;i++)
        {
            freq[arr1[i]-'a']++;
            freq[arr2[i]-'a']--;
        }

        for(int i=0;i<26;i++)
        {
            if(freq[i]!=0)
            {
                return "NO";
            }
        }

        return "YES";
    }

    public static void main(String[] args)
    {
        String s1="listen";
        String s2="silent";

        System.out.println(checkAnagram(s1,s2));
    }
}

/* HASHMAP
public class Anagram
{
    public static String checkAnagram(String s1,String s2)
    {
        if(s1.length()!=s2.length())
        {
            return "NO";
        }

        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0;i<s1.length();i++)
        {
            char ch=s1.charAt(i);

            if(map.containsKey(ch))
            {
                map.put(ch,map.get(ch)+1);
            }
            else
            {
                map.put(ch,1);
            }
        }

        for(int i=0;i<s2.length();i++)
        {
            char ch=s2.charAt(i);

            if(!map.containsKey(ch))
            {
                return "NO";
            }

            else
            {
                map.put(ch,map.get(ch)-1);

                if(map.get(ch)<0)
                {
                    return "NO";
                }
            }
        }

        return "YES";
    }

    public static void main(String[] args)
    {
        String s1="listen";
        String s2="silent";

        System.out.println(checkAnagram(s1,s2));
    }
}
*/

/* TWO POINTER
public class Anagram
{
    public static String checkAnagram(String s1,String s2)
    {
        if(s1.length()!=s2.length())
        {
            return "NO";
        }

        char[] arr1=s1.toCharArray();
        char[] arr2=s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i=0;
        int j=0;

        while(i<arr1.length && j<arr2.length)
        {
            if(arr1[i]!=arr2[j])
            {
                return "NO";
            }

            i++;
            j++;
        }

        return "YES";
    }

    public static void main(String[] args)
    {
        String s1="listen";
        String s2="silent";

        System.out.println(checkAnagram(s1,s2));
    }
}
*/