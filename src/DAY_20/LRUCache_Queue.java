package DAY_20;

import java.util.*;

public class LRUCache_Queue
{
    int capacity;

    HashMap<Integer, Integer> map;
    Queue<Integer> queue;

    LRUCache_Queue(int capacity)
    {
        this.capacity = capacity;

        map = new HashMap<>();
        queue = new LinkedList<>();
    }

    int get(int key)
    {
        if (!map.containsKey(key))
        {
            return -1;
        }

        queue.remove(key); // O(n)
        queue.offer(key);

        return map.get(key);
    }

    void put(int key, int value)
    {
        if (map.containsKey(key))
        {
            queue.remove(key);
        }
        else if (map.size() == capacity)
        {
            int lru = queue.poll();

            map.remove(lru);
        }

        map.put(key, value);
        queue.offer(key);
    }

    public static void main(String[] args)
    {
        LRUCache_Queue cache = new LRUCache_Queue(2);

        cache.put(1, 10);
        cache.put(2, 20);

        System.out.println(cache.get(1));

        cache.put(3, 30);

        System.out.println(cache.get(2));

        cache.put(4, 40);

        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}