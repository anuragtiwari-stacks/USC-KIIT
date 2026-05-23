/*
Saptak is designing secure passwords for the participants of CodeSprint 3.0.

A password is considered STRONG if:

1. It contains at least one uppercase letter
2. It contains at least one lowercase letter
3. It contains at least one digit

Help Saptak determine whether the given password is strong or not.

Input Format:
A single string representing the password.

Output Format:
Print "STRONG" if the password satisfies all conditions.
Otherwise, print "WEAK".
*/

package DAY_6;

public class StrongPassword
{
    public static String checkPassword(String str)
    {
        boolean Upper = false;
        boolean Lower = false;
        boolean Digit = false;

        for (int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);

            if (ch >= 'A' && ch <= 'Z')
            {
                Upper = true;
            }

            if (ch >= 'a' && ch <= 'z')
            {
                Lower = true;
            }

            if (ch >= '0' && ch <= '9')
            {
                Digit = true;
            }
        }

        if (Upper && Lower && Digit)
        {
            return "STRONG";
        }

        return "WEAK";
    }

    public static void main(String[] args)
    {
        String str1 = "Code123";
        String str2 = "codesprint";

        System.out.println(checkPassword(str1));
        System.out.println(checkPassword(str2));
    }
}