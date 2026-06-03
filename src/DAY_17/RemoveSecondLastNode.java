package DAY_17;

public class RemoveSecondLastNode
{
    static Node head;

    // Insert at end
    static void insert(int data)
    {
        Node newNode = new Node(data);

        if(head == null)
        {
            head = newNode;
            return;
        }

        Node temp = head;

        while(temp.next != null)
        {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Remove 2nd node from end
    static void removeSecondLast()
    {
        Node temp = head;

        // move till 3rd last node
        while(temp.next.next.next != null)
        {
            temp = temp.next;
        }

        // delete 2nd last node
        temp.next = temp.next.next;
    }

    // Display linked list
    static void display()
    {
        Node temp = head;

        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args)
    {
        insert(101);
        insert(102);
        insert(103);
        insert(104);
        insert(105);

        removeSecondLast();

        display();
    }
}