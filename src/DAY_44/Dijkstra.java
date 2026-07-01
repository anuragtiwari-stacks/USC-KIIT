package DAY_44;

import java.util.*;

class Pair
{
    int vertex;
    int weight;

    Pair(int vertex, int weight)
    {
        this.vertex = vertex;
        this.weight = weight;
    }
}

public class Dijkstra
{
    public static void dijkstra(ArrayList<ArrayList<Pair>> graph, int source)
    {
        int vertices = graph.size();

        int[] distance = new int[vertices];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[source] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        pq.offer(new Pair(source, 0));

        while (!pq.isEmpty())
        {
            Pair current = pq.poll();

            int u = current.vertex;

            for (Pair neighbour : graph.get(u))
            {
                int v = neighbour.vertex;
                int weight = neighbour.weight;

                if (distance[u] + weight < distance[v])
                {
                    distance[v] = distance[u] + weight;

                    pq.offer(new Pair(v, distance[v]));
                }
            }
        }

        System.out.println("Shortest Distance from Source:");

        for (int i = 0; i < vertices; i++)
        {
            System.out.println(source + " -> " + i + " = " + distance[i]);
        }
    }

    public static void main(String[] args)
    {
        int vertices = 5;

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++)
        {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Pair(1, 10));
        graph.get(0).add(new Pair(4, 5));

        graph.get(1).add(new Pair(2, 1));
        graph.get(1).add(new Pair(4, 2));

        graph.get(2).add(new Pair(3, 4));

        graph.get(3).add(new Pair(0, 7));
        graph.get(3).add(new Pair(2, 6));

        graph.get(4).add(new Pair(1, 3));
        graph.get(4).add(new Pair(2, 9));
        graph.get(4).add(new Pair(3, 2));

        dijkstra(graph, 0);
    }
}