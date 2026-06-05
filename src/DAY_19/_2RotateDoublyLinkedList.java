package DAY_19;

/*
Question:
In the futuristic kingdom of Nexora, Zara discovered a magical memory chain
storing encrypted data blocks. Each block is connected to both its next and
previous blocks using a doubly linked structure.

During a system reboot, the chain must be rotated to the right by K positions.

A right rotation means:
1. The last node becomes the new head.
2. Remaining nodes shift one position ahead.
3. Both next and prev links must be maintained.

Print the list after rotation.
*/

public class _2RotateDoublyLinkedList
{
    static class Node
    {
        int data;
        Node next;
        Node prev;

        Node(int data)
        {
            this.data = data;
        }
    }

    public static Node createList(int[] arr)
    {
        Node head = new Node(arr[0]);
        Node tail = head;

        for (int i = 1; i < arr.length; i++)
        {
            Node newNode = new Node(arr[i]);

            tail.next = newNode;
            newNode.prev = tail;

            tail = newNode;
        }

        return head;
    }

    public static Node rotateRight(Node head, int k)
    {
        if (head == null || head.next == null || k == 0)
        {
            return head;
        }

        int length = 1;
        Node tail = head;

        while (tail.next != null)
        {
            tail = tail.next;
            length++;
        }

        k = k % length;

        if (k == 0)
        {
            return head;
        }

        Node newTail = head;

        for (int i = 1; i < length - k; i++)
        {
            newTail = newTail.next;
        }

        Node newHead = newTail.next;

        newTail.next = null;
        newHead.prev = null;

        tail.next = head;
        head.prev = tail;

        return newHead;
    }

    public static void printForward(Node head)
    {
        Node temp = head;

        while (temp != null)
        {
            System.out.print(temp.data + " ");

            if (temp.next == null)
            {
                break;
            }

            temp = temp.next;
        }

        System.out.println();
    }

    public static void printBackward(Node head)
    {
        Node tail = head;

        while (tail.next != null)
        {
            tail = tail.next;
        }

        while (tail != null)
        {
            System.out.print(tail.data + " ");
            tail = tail.prev;
        }

        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5};

        int k = 2;

        Node head = createList(arr);

        head = rotateRight(head, k);

        System.out.println("Forward Traversal:");
        printForward(head);

        System.out.println("Backward Traversal:");
        printBackward(head);
    }
}