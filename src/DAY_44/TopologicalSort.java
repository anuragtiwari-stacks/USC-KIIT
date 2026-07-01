package DAY_44;

import java.util.*;

public class TopologicalSort
{
    public static void topologicalSort(ArrayList<ArrayList<Integer>> graph)
    {
        int vertices = graph.size();

        int[] indegree = new int[vertices];

        for (int i = 0; i < vertices; i++)
        {
            for (int neighbour : graph.get(i))
            {
                indegree[neighbour]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < vertices; i++)
        {
            if (indegree[i] == 0)
            {
                queue.offer(i);
            }
        }

        System.out.println("Topological Order:");

        while (!queue.isEmpty())
        {
            int current = queue.poll();

            System.out.print(current + " ");

            for (int neighbour : graph.get(current))
            {
                indegree[neighbour]--;

                if (indegree[neighbour] == 0)
                {
                    queue.offer(neighbour);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int vertices = 6;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++)
        {
            graph.add(new ArrayList<>());
        }

        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);

        topologicalSort(graph);
    }
}