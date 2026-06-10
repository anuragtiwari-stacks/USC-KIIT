package DAY_24;

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

public class Middle_LL
{
    public static Node middleNode(Node head)
    {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5, 6};

        Node head = new Node(arr[0]);
        Node temp = head;

        for(int i = 1; i < arr.length; i++)
        {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }

        Node ans = middleNode(head);

        System.out.println(ans.data);
    }
}