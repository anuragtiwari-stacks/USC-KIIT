package DAY_32;

import java.util.*;

public class QueueUsingTwoStacks
{
    static Stack<Integer> stack1 =
            new Stack<>();

    static Stack<Integer> stack2 =
            new Stack<>();

    public static void register(int token)
    {
        stack1.push(token);
    }

    public static int next()
    {
        if(stack1.isEmpty() &&
                stack2.isEmpty())
        {
            return -1;
        }

        if(stack2.isEmpty())
        {
            while(!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public static void main(String[] args)
    {
        String[] operations =
                {
                        "REGISTER 101",
                        "REGISTER 205",
                        "NEXT",
                        "REGISTER 309",
                        "NEXT",
                        "NEXT"
                };

        System.out.println("Operations:");

        for(String operation : operations)
        {
            System.out.println(operation);
        }

        System.out.println("\nOutput:");

        for(String operation : operations)
        {
            String[] parts =
                    operation.split(" ");

            if(parts[0].equals("REGISTER"))
            {
                int token =
                        Integer.parseInt(parts[1]);

                register(token);
            }
            else if(parts[0].equals("NEXT"))
            {
                System.out.println(next());
            }
        }
    }
}