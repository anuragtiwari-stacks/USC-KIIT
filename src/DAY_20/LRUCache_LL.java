package DAY_20;

import java.util.HashMap;

public class LRUCache_LL
{
    int capacity;
    HashMap<Integer, Node> map;

    Node head;
    Node tail;

    LRUCache_LL(int capacity)
    {
        this.capacity = capacity;

        map = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    void remove(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void insert(Node node)
    {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    int get(int key)
    {
        if (!map.containsKey(key))
        {
            return -1;
        }

        Node node = map.get(key);

        remove(node);
        insert(node);

        return node.value;
    }

    void put(int key, int value)
    {
        if (map.containsKey(key))
        {
            Node node = map.get(key);

            node.value = value;

            remove(node);
            insert(node);
        }
        else
        {
            if (map.size() == capacity)
            {
                Node lru = tail.prev;

                remove(lru);
                map.remove(lru.key);
            }

            Node newNode = new Node(key, value);

            insert(newNode);
            map.put(key, newNode);
        }
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