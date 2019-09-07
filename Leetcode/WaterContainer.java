import java.util.Scanner;
/**
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container,
such that the container contains the most water.
Note: You may not slant the container and n is at least 2.
*/
public class WaterContainer
{
    public static void main (String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println ("Enter number of elements");
        int n = sc.nextInt();
        System.out.println ("Enter the elements");
        int height[] = new int[n];
        for (int i = 0; i < n; i++)
        {
            height[i] = sc.nextInt();
        }
        System.out.println("Max Area is " + maxArea(height));
    }

    private static int maxArea(int[] height)
    {
        int startPointer = 0;
        int endPointer = height.length - 1;
        int maxArea = 0;
        while (startPointer <= endPointer)
        {
            int area = 0;
            if (height[startPointer] > height[endPointer])
            {
                area = height[endPointer] * (endPointer - startPointer);
                endPointer--;
            }
            else
            {
                area = height[startPointer] * (endPointer - startPointer);
                startPointer++;
            }
            if (area > maxArea)
                maxArea = area;
        }
        return maxArea;
    }
}