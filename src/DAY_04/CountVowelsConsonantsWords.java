package DAY_04;

public class CountVowelsConsonantsWords
{
    public static void analyzeText(String str)
    {
        int vowels = 0;
        int consonants = 0;
        int words = 0;

        str = str.toLowerCase();
        str = str.trim();

        if (!str.isEmpty())
        {
            words = str.split("\\s+").length;
        }

        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);

            if (Character.isLetter(ch))
            {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                {
                    vowels++;
                }
                else
                {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Words: " + words);
    }

    public static void main(String[] args)
    {
        String str = "Welcome to KIIT Fest 2026!";

        analyzeText(str);
    }
}