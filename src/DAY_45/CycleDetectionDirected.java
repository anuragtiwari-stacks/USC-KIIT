package DAY_45;

import java.util.*;

public class CycleDetectionDirected
{
    public static boolean dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] recursionStack, int current)
    {
        visited[current] = true;
        recursionStack[current] = true;

        for (int neighbour : graph.get(current))
        {
            if (!visited[neighbour])
            {
                if (dfs(graph, visited, recursionStack, neighbour))
                {
                    return true;
                }
            }
            else if (recursionStack[neighbour])
            {
                return true;
            }
        }

        recursionStack[current] = false;

        return false;
    }

    public static boolean hasCycle(ArrayList<ArrayList<Integer>> graph)
    {
        boolean[] visited = new boolean[graph.size()];
        boolean[] recursionStack = new boolean[graph.size()];

        for (int i = 0; i < graph.size(); i++)
        {
            if (!visited[i])
            {
                if (dfs(graph, visited, recursionStack, i))
                {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        int vertices = 4;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++)
        {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(3);
        graph.get(3).add(1);

        if (hasCycle(graph))
        {
            System.out.println("Cycle Detected");
        }
        else
        {
            System.out.println("No Cycle");
        }
    }
}