package DAY_26;

class Node
{
    int data;
    Node next;

    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

public class CopyLinkedList
{
    public static Node copyList(Node head)
    {
        if (head == null)
        {
            return null;
        }

        Node newHead = new Node(head.data);

        Node currOld = head.next;
        Node currNew = newHead;

        while (currOld != null)
        {
            currNew.next = new Node(currOld.data);

            currNew = currNew.next;
            currOld = currOld.next;
        }

        return newHead;
    }

    public static void printList(Node head)
    {
        Node temp = head;

        while (temp != null)
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args)
    {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.println("Original Linked List:");
        printList(head);

        Node copiedHead = copyList(head);

        System.out.println("Copied Linked List:");
        printList(copiedHead);
    }
}