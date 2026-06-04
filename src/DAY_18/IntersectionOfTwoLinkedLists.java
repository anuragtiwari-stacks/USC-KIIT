package DAY_18;

public class IntersectionOfTwoLinkedLists
{
    public static int getLength(Node head)
    {
        int length = 0;

        while (head != null)
        {
            length++;
            head = head.next;
        }

        return length;
    }

    public static Node getIntersectionNode(Node headA, Node headB)
    {
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        int diff = Math.abs(lenA - lenB);

        if (lenA > lenB)
        {
            while (diff > 0)
            {
                headA = headA.next;
                diff--;
            }
        }
        else
        {
            while (diff > 0)
            {
                headB = headB.next;
                diff--;
            }
        }

        while (headA != null && headB != null)
        {
            if (headA == headB)
            {
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    public static void main(String[] args)
    {
        // Common part
        Node common = new Node(8);
        common.next = new Node(10);
        common.next.next = new Node(12);

        // List A: 3 -> 6 -> 8 -> 10 -> 12
        Node headA = new Node(3);
        headA.next = new Node(6);
        headA.next.next = common;

        // List B: 1 -> 2 -> 4 -> 8 -> 10 -> 12
        Node headB = new Node(1);
        headB.next = new Node(2);
        headB.next.next = new Node(4);
        headB.next.next.next = common;

        Node intersection = getIntersectionNode(headA, headB);

        if (intersection != null)
        {
            System.out.println("Intersection Node = " + intersection.data);
        }
        else
        {
            System.out.println("No Intersection");
        }
    }
}