package DAY_11;

class Participant
{
    String name;
    int score;

    Participant(String name, int score)
    {
        this.name = name;
        this.score = score;
    }
}

public class StableLeaderboard
{
    public static void bubbleSort(Participant[] arr)
    {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n - i - 1; j++)
            {
                if (arr[j].score > arr[j + 1].score)
                {
                    Participant temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Participant[] arr =
                {
                        new Participant("Aman", 50),
                        new Participant("Riya", 30),
                        new Participant("Kabir", 50),
                        new Participant("Neha", 20),
                        new Participant("Aryan", 30)
                };

        bubbleSort(arr);

        for (Participant p : arr)
        {
            System.out.println(p.name + " " + p.score);
        }
    }
}

/*
Question

Namita is managing the leaderboard for her college coding contest,
where participants are ranked based on their scores.

Each participant has:
1. a name
2. a score

The leaderboard must be sorted in increasing order of scores.

However, there is one important rule:
If two participants have the same score,
their original relative order in the input must remain unchanged.

To maintain fairness, Namita uses a sorting method that repeatedly
compares adjacent participants and swaps them only when the left
participant has a higher score.

Help Namita generate the final stable leaderboard.

Input
Aman 50
Riya 30
Kabir 50
Neha 20
Aryan 30

Output
Neha 20
Riya 30
Aryan 30
Aman 50
Kabir 50
*/