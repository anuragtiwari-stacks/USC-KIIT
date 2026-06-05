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

public class _1CodingChallenge_CircularLinkedList
{
    static class Node
    {
        int id;
        Node next;

        Node(int id)
        {
            this.id = id;
            this.next = null;
        }
    }
    public static int findSurvivor(int[] ids, int k)
    {
        Node head = new Node(ids[0]);
        Node tail = head;

        for (int i = 1; i < ids.length; i++)
        {
            tail.next = new Node(ids[i]);
            tail = tail.next;
        }

        tail.next = head;

        Node curr = head;
        Node prev = tail;

        while (curr.next != curr)
        {
            for (int i = 1; i < k; i++)
            {
                prev = curr;
                curr = curr.next;
            }

            prev.next = curr.next;
            curr = curr.next;
        }

        return curr.id;
    }

    public static void main(String[] args)
    {
        int[] ids = {10, 20, 30, 40, 50, 60, 70};

        int k = 3;

        System.out.println(findSurvivor(ids, k));
    }
}