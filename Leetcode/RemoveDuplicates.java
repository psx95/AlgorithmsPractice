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
        int overallDuplicates = 0;
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
                    if (i < nums.length - 2)
                    {
                        i++;
                        currElement = nums[i];
                        nextElement = nums[i + 1];
                        duplicateEndPos = i + 1;
                    }
                    else
                    {                    
                        duplicateEndPos = i + 1;
                        break;
                    }
                }
                if (arrayShifted) {
                	duplicateStartPos -= duplicates;                	
                }                
                shiftArray(nums, duplicateStartPos + 1, duplicateEndPos);
                System.out.println ("Duplicates " + duplicates);
                overallDuplicates += duplicates;
                l = l - duplicates;
                duplicates = 0;
                i = duplicateEndPos - 1;
            }
        }
        System.out.println (Arrays.toString(nums) + "Duplicates " + duplicates);
        return l;
    }

    private static void shiftArray (int[] nums, int startIndex, int startFrom)
    {
        System.out.println ("******SHIFTING ARRAY*******");
        System.out.println (Arrays.toString(nums) + "Start Index " + startIndex + "  Start FROM " + startFrom);
        for (int i = startIndex; startFrom < nums.length; i++)
        {
            nums[i] = nums[startFrom++];
        }
        System.out.println ("******SHIFTING DONE*******");
        if (!arrayShifted)
            arrayShifted = true;
    }
}