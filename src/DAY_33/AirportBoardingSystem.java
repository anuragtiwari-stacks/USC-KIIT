package DAY_33;

import java.util.*;

/*
Problem Name:
Airport Boarding System

Problem Statement:
Satyam is helping manage boarding at a busy airport.

Every passenger is assigned a boarding priority.
Passengers with a higher priority board first.

If two passengers have the same priority,
the passenger who checked in earlier boards first.

Input:
101 2
102 5
103 3
104 5

Output:
102
104
103
101

Explanation:
Passenger 102 and 104 have the highest priority (5).

Since 102 checked in earlier than 104,
102 boards first.

Then passenger 103 (priority 3).

Finally passenger 101 (priority 2).

Approach:
1. Store Passenger ID, Priority, and Arrival Order.
2. Use a Priority Queue (Max Heap).
3. Sort by:
   - Higher Priority First
   - Earlier Arrival First (if priorities are same)
4. Remove passengers one by one and print boarding order.

Time Complexity:
O(N log N)

Space Complexity:
O(N)
*/

public class AirportBoardingSystem
{
    static class Passenger
    {
        int passengerId;
        int priority;
        int arrivalOrder;

        Passenger(int passengerId, int priority, int arrivalOrder)
        {
            this.passengerId = passengerId;
            this.priority = priority;
            this.arrivalOrder = arrivalOrder;
        }
    }

    public static void main(String[] args)
    {
        int[][] input = {{101, 2}, {102, 5}, {103, 3}, {104, 5}};

        PriorityQueue<Passenger> pq = new PriorityQueue<>((a, b) -> {
                                    if(a.priority != b.priority)
                                    {
                                        return b.priority - a.priority;
                                    }
                                    return a.arrivalOrder - b.arrivalOrder;});

        for(int i = 0; i < input.length; i++)
        {
            pq.offer(new Passenger(input[i][0], input[i][1], i));
        }

        System.out.println("Boarding Order:");

        while(!pq.isEmpty())
        {
            Passenger passenger = pq.poll();
            System.out.println(passenger.passengerId);
        }
    }
}