package DAY_28;

import java.util.*;

public class Queue_FIFO
{
    public static void processOperations(String[] operations)
    {
        Queue<Integer> queue = new LinkedList<>();

        for(String operation : operations)
        {
            String[] parts = operation.split(" ");

            if(parts[0].equals("REGISTER"))
            {
                registerStudent(queue, Integer.parseInt(parts[1]));
            }
            else if(parts[0].equals("WITHDRAW"))
            {
                withdrawStudent(queue);
            }
            else if(parts[0].equals("NEXT"))
            {
                callNextStudent(queue);
            }
        }
    }

    public static void registerStudent(Queue<Integer> queue, int studentId)
    {
        queue.add(studentId);
    }

    public static void withdrawStudent(Queue<Integer> queue)
    {
        if(queue.isEmpty())
        {
            System.out.println(-1);
        }
        else
        {
            queue.remove();
        }
    }

    public static void callNextStudent(Queue<Integer> queue)
    {
        if(queue.isEmpty())
        {
            System.out.println(-1);
        }
        else
        {
            System.out.println(queue.remove());
        }
    }

    public static void main(String[] args)
    {
        String[] operations =
                {
                        "REGISTER 101",
                        "REGISTER 102",
                        "NEXT",
                        "REGISTER 103",
                        "WITHDRAW",
                        "NEXT",
                        "NEXT"
                };

        processOperations(operations);
    }
}