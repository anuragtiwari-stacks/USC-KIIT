package DAY_43;

import java.util.*;

class Job
{
    String id;
    int deadline;
    int profit;

    Job(String id, int deadline, int profit)
    {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing
{
    public static void jobSequencing(Job[] jobs)
    {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;

        for (Job job : jobs)
        {
            if (job.deadline > maxDeadline)
            {
                maxDeadline = job.deadline;
            }
        }

        String[] result = new String[maxDeadline];

        int totalProfit = 0;

        for (Job job : jobs)
        {
            for (int j = job.deadline - 1; j >= 0; j--)
            {
                if (result[j] == null)
                {
                    result[j] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        System.out.println("Selected Jobs:");

        for (String job : result)
        {
            if (job != null)
            {
                System.out.print(job + " ");
            }
        }

        System.out.println();

        System.out.println("Total Profit = " + totalProfit);
    }

    public static void main(String[] args)
    {
        Job[] jobs =
                {
                        new Job("J1", 2, 100),
                        new Job("J2", 1, 19),
                        new Job("J3", 2, 27),
                        new Job("J4", 1, 25),
                        new Job("J5", 3, 15)
                };

        jobSequencing(jobs);
    }
}