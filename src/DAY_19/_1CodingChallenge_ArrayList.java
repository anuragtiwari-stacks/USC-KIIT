package DAY_19;
/*
Saptarshi is organizing a coding challenge where participants stand in a circle.
Each participant is assigned a unique ID, and the participants are arranged
in the form of a circular linked list.

Starting from the first participant, every K-th participant is eliminated
from the circle. After each elimination, counting resumes from the next
participant still in the game.

The process continues until only one participant remains.

Your task is to determine the ID of the participant who survives till the end.
*/

import java.util.ArrayList;

public class _1CodingChallenge_ArrayList
{
    public static int findSurvivor(int[] ids, int k)
    {
        ArrayList<Integer> participants = new ArrayList<>();

        for (int id : ids)
        {
            participants.add(id);
        }

        int index = 0;

        while (participants.size() > 1)
        {
            index = (index + k - 1) % participants.size();
            participants.remove(index);
        }

        return participants.get(0);
    }

    public static void main(String[] args)
    {
        int[] ids = {10, 20, 30, 40, 50, 60, 70};

        int k = 3;

        System.out.println(findSurvivor(ids, k));
    }
}