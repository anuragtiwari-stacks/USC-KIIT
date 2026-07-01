package DAY_42;

import java.util.*;

class Activity
{
    int start;
    int end;

    Activity(int start, int end)
    {
        this.start = start;
        this.end = end;
    }
}

public class ActivitySelection
{
    public static void activitySelection(Activity[] activities)
    {
        Arrays.sort(activities, (a, b) -> a.end - b.end);

        System.out.println("Selected Activities:");

        int lastEnd = activities[0].end;

        System.out.println("(" + activities[0].start + ", " + activities[0].end + ")");

        for (int i = 1; i < activities.length; i++)
        {
            if (activities[i].start >= lastEnd)
            {
                System.out.println("(" + activities[i].start + ", " + activities[i].end + ")");
                lastEnd = activities[i].end;
            }
        }
    }

    public static void main(String[] args)
    {
        Activity[] activities =
                {
                        new Activity(1, 2),
                        new Activity(3, 4),
                        new Activity(0, 6),
                        new Activity(5, 7),
                        new Activity(8, 9),
                        new Activity(5, 9)
                };

        activitySelection(activities);
    }
}