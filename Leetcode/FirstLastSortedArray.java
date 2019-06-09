import java.util.Scanner;
import java.util.Arrays;

/**
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].*/
public class FirstLastSortedArray
{
    public static void main (String Args[])
    {
        System.out.println ("Enter the number of elements");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println ("Enter the elements");
        int arr[] = new int[n];
        for (int i = 0 ; i < n ; i ++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println ("Enter target");
        int target = sc.nextInt();
        System.out.println ("Search Range - " + Arrays.toString(searchRange(arr, target)));
        sc.close();
    }

    public static int[] searchRange(int[] nums, int target)
    {
        int low = 0;
        int high = nums.length - 1;
        int ans[] = new int[2];
        int result = binarySearch(nums, target);
        if (result == -1)
        {
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        else
        {
            int nextPos = result;
            for (int i = result + 1; i < nums.length; i++)
            {
                if (nums[i] != target)
                {
                    break;
                }
                else
                {
                    nextPos = i;
                }
            }
            ans[0] = result;
            ans[1] = nextPos;
            return ans;
        }
    }

    public static int binarySearch (int[] nums, int target)
    {
        int result = -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high)
        {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
            {
                result = mid;
                high = mid - 1;
            }
            else if (target > nums[mid])
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return result;
    }
}