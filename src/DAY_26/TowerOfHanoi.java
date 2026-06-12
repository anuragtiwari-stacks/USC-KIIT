package DAY_26;

public class TowerOfHanoi
{
    public static void towerOfHanoi(int n, char source, char helper, char destination)
    {
        // Base Case
        if (n == 1)
        {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        // Move n-1 disks from source to helper
        towerOfHanoi(n - 1, source, destination, helper);

        // Move largest disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        // Move n-1 disks from helper to destination
        towerOfHanoi(n - 1, helper, source, destination);
    }

    public static void main(String[] args)
    {
        int n = 3; // Number of disks

        System.out.println("Steps to solve Tower of Hanoi:");
        towerOfHanoi(n, 'A', 'B', 'C');
    }
}