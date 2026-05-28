package DAY_11;

import java.util.Arrays;

class Participants
{
    String name;
    int score;

    Participants(String name, int score)
    {
        this.name = name;
        this.score = score;
    }
}

public class StableLeaderboard_Comparator
{
    public static void main(String[] args)
    {
        Participants[] arr =
                {
                        new Participants("Aman", 50),
                        new Participants("Riya", 30),
                        new Participants("Kabir", 50),
                        new Participants("Neha", 20),
                        new Participants("Aryan", 30)
                };

        Arrays.sort(arr, (a, b) -> a.score - b.score);

        for (Participants p : arr)
        {
            System.out.println(p.name + " " + p.score);
        }
    }
}