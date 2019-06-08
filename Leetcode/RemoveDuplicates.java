import java.util.*;
public class RemoveDuplicates
{
    public static boolean arrayShifted = false;
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
        System.out.println ("New Size " + removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] nums)
    {
        int duplicates = 0;
        int duplicateStartPos = -1;
        int duplicateEndPos = -1;
        int l = nums.length;
        for (int i = 0; i < l - 1; i++)
        {
            int currElement = nums[i];
            int nextElement = nums[i + 1];
            if (currElement == nextElement)
            {
                duplicateStartPos = i;
                while (currElement == nextElement)
                {
                    duplicates++;
                    i++;
                    if (i < l - 1)
                    {
                        currElement = nums[i];
                        nextElement = nums[i + 1];
                    }
                    else
                    {
                        i--;
                        break;
                    }
                }
                duplicateEndPos = i;
                shiftArray(nums, duplicateStartPos + 1, duplicateEndPos + 1, l);
                System.out.println ("Duplicates " + duplicates);
                l = l - duplicates;
                duplicates = 0;
                i = duplicateStartPos;
            }
        }
        System.out.println (Arrays.toString(nums) + "Duplicates " + duplicates);
        return l;
    }

    private static void shiftArray (int[] nums, int startIndex, int startFrom, int length)
    {
        System.out.println ("******SHIFTING ARRAY*******");
        System.out.println (Arrays.toString(nums) + "Start Index " + startIndex + "  Start FROM " + startFrom + "length " + length);
        for (int i = startIndex; startFrom < length; i++)
        {
            nums[i] = nums[startFrom++];
        }
        System.out.println ("******SHIFTING DONE*******");
    }
}