package DAY_18;

public class CycleDetection
{
    public static boolean hasCycle(Node head)
    {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
            {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        // Creating linked list:
        // 1 -> 2 -> 3 -> 4 -> 5
        //           ^         |
        //           |_________|

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Creating cycle
        head.next.next.next.next.next = head.next.next;

        if (hasCycle(head))
        {
            System.out.println("Cycle Detected");
        }
        else
        {
            System.out.println("No Cycle Detected");
        }
    }
}