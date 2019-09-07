import java.util.Scanner;
public class WaterContainer {
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println ("Enter number of elements");
		int n = sc.nextInt();
		System.out.println ("Enter the elements");
		int height[] = new int[n];  
		for (int i = 0; i < n; i++) {
			height[i] = sc.nextInt();
		}
		System.out.println("Max Area is " + maxArea(height));
	}

	private static int maxArea(int[] height) {
        int startPointer = 0;
        int endPointer = height.length - 1;
        int maxArea = 0;       
        while (startPointer <= endPointer) {
        	int area = 0;
        	if (height[startPointer] > height[endPointer]) {
        		area = height[endPointer] * (endPointer - startPointer);        		
        		endPointer--;
        	} else {
        		area = height[startPointer] * (endPointer - startPointer);
        		startPointer++;
        	}
        	if (area > maxArea) 
        		maxArea = area;
        }
        return maxArea;
    }	
}