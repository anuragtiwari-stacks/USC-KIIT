package DAY_21;

/*
Flatten Multiple Sorted Linked Lists
Approach: Merge Two Lists Repeatedly

Input Lists:
1 -> 4 -> 7
2 -> 5 -> 8
3 -> 6 -> 9

Output:
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
*/

public class Flattening_LL
{
    public static Node merge(Node a, Node b)
    {
        Node dummy = new Node(-1);
        Node tail = dummy;

        while(a != null && b != null)
        {
            if(a.data <= b.data)
            {
                tail.next = a;
                a = a.next;
            }
            else
            {
                tail.next = b;
                b = b.next;
            }

            tail = tail.next;
        }

        if(a != null)
        {
            tail.next = a;
        }

        if(b != null)
        {
            tail.next = b;
        }

        return dummy.next;
    }

    public static void print(Node head)
    {
        while(head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args)
    {
        // List 1: 1 -> 4 -> 7
        Node l1 = new Node(1);
        l1.next = new Node(4);
        l1.next.next = new Node(7);

        // List 2: 2 -> 5 -> 8
        Node l2 = new Node(2);
        l2.next = new Node(5);
        l2.next.next = new Node(8);

        // List 3: 3 -> 6 -> 9
        Node l3 = new Node(3);
        l3.next = new Node(6);
        l3.next.next = new Node(9);

        // Merge repeatedly
        Node result = merge(l1, l2);
        result = merge(result, l3);

        System.out.print("Flattened List: ");
        print(result);
    }
}

/*
Output:

Flattened List:
1 2 3 4 5 6 7 8 9

Time Complexity: O(kN)
Space Complexity: O(1)
*/