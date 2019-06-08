import java.util.Scanner;
import java.util.Arrays;
public class RemoveElement
{
    public static void main (String Args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println ("Enter the array number of elements");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println ("Enter the number you want to remove ");
        int num = sc.nextInt();
        System.out.println ("New Size " + removeElement(arr, num));
    }

    public static int removeElement(int[] nums, int val)
    {
        int length = nums.length;
        for (int i = 0; i < length; i++)
        {
            if (nums[i] == val)
            {
                // SHIFT ARRAY
                shifArray(nums, i, length);
                i--;
                length--;
            }
        }
        System.out.println (Arrays.toString(nums)  +" Final Array");
        return length;
    }

    private static void shifArray(int[] nums, int position, int length)
    {
        System.out.println ("******SHIFTING ARRAY*******");
        System.out.println (Arrays.toString(nums) + "Position " + position + "  length " + length);
        for (int i = position; i < nums.length - 1; i++)
        {
            nums[i] = nums[i + 1];
        }
        System.out.println ("******SHIFTING DONE*******");
    }
}