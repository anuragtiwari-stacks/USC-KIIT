import java.util.*;

public class ThreeSum
{
    public static List<List<Integer>> threeSum(int[] nums)
    {
        int target = 0;

        HashSet<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n; i++)
        {
            int left = i + 1;
            int right = n - 1;

            while (left < right)
            {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target)
                {
                    List<Integer> arr =
                            Arrays.asList(nums[i], nums[left], nums[right]);

                    result.add(arr);

                    left++;
                    right--;
                }

                else if (sum < 0)
                {
                    left++;
                }

                else
                {
                    right--;
                }
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args)
    {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> ans = threeSum(nums);

        System.out.println(ans);
    }
}