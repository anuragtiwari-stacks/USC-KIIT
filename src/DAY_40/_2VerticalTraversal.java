package DAY_40;

import java.util.*;

public class _2VerticalTraversal
{
    public static void verticalTraversal(Node root)
    {
        if (root == null)
        {
            return;
        }

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty())
        {
            Pair current = queue.poll();

            Node node = current.node;
            int hd = current.hd;

            if (!map.containsKey(hd))
            {
                map.put(hd, new ArrayList<Integer>());
            }

            map.get(hd).add(node.data);

            if (node.left != null)
            {
                queue.offer(new Pair(node.left, hd - 1));
            }

            if (node.right != null)
            {
                queue.offer(new Pair(node.right, hd + 1));
            }
        }

        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet())
        {
            for (int value : entry.getValue())
            {
                System.out.print(value + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Vertical Traversal:");

        verticalTraversal(root);
    }
}