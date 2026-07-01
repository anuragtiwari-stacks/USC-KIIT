package DAY_41;

import java.util.*;

public class BSTLeafNodes
{
    public static int countLeafNodes(Node root)
    {
        if (root == null)
        {
            return 0;
        }

        if (root.left == null && root.right == null)
        {
            return 1;
        }

        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

    public static void main(String[] args)
    {
        Node root = new Node(50);

        root.left = new Node(30);
        root.right = new Node(70);

        root.left.left = new Node(20);
        root.left.right = new Node(40);

        root.right.left = new Node(60);
        root.right.right = new Node(80);

        System.out.println("Leaf Nodes = " + countLeafNodes(root));
    }
}