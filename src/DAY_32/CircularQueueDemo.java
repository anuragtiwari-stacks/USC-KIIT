package DAY_32;

public class CircularQueueDemo
{
    static class CircularQueue
    {
        int[] queue;

        int front;
        int rear;
        int size;
        int capacity;

        CircularQueue(int capacity)
        {
            this.capacity = capacity;

            queue = new int[capacity];

            front = 0;
            rear = -1;
            size = 0;
        }

        public void enqueue(int value)
        {
            if(size == capacity)
            {
                System.out.println("FULL");
                return;
            }

            rear = (rear + 1) % capacity;

            queue[rear] = value;

            size++;
        }

        public void dequeue()
        {
            if(size == 0)
            {
                System.out.println("EMPTY");
                return;
            }

            front = (front + 1) % capacity;

            size--;
        }

        public void front()
        {
            if(size == 0)
            {
                System.out.println(-1);
                return;
            }

            System.out.println(queue[front]);
        }
    }

    public static void main(String[] args)
    {
        int K = 3;

        String[] operations =
                {
                        "ENQUEUE 10",
                        "ENQUEUE 20",
                        "ENQUEUE 30",
                        "FRONT",
                        "DEQUEUE",
                        "FRONT",
                        "DEQUEUE"
                };

        CircularQueue cq =
                new CircularQueue(K);

        System.out.println("Output:");

        for(String operation : operations)
        {
            String[] parts =
                    operation.split(" ");

            if(parts[0].equals("ENQUEUE"))
            {
                int value =
                        Integer.parseInt(parts[1]);

                cq.enqueue(value);
            }
            else if(parts[0].equals("DEQUEUE"))
            {
                cq.dequeue();
            }
            else if(parts[0].equals("FRONT"))
            {
                cq.front();
            }
        }
    }
}