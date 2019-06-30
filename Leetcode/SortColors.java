package Leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class SortColors {

    public static void main(String Args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n = scanner.nextInt();
        System.out.println("Enter the elements");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        sortColors(arr);
        scanner.close();
    }

    private static void sortColors(int[] nums) {
        int min_0 = -1, max_0 = -1;
        int min_1 = -1, max_1 = -1;
        int min_2 = -1, max_2 = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int curr_pos = i;
            switch (num) {
                case 0:
                    if (min_0 == -1) {
                        min_0 = curr_pos;
                        max_0 = curr_pos;
                    }
                    if (min_2 != -1 && curr_pos > min_2) {
                        int t = nums[curr_pos];
                        nums[curr_pos] = nums[min_2];
                        nums[min_2] = t;

                        curr_pos = min_2;
                        System.out.println("Outer 0 " + curr_pos);
                        if (min_2 == max_2) {
                            min_2 = i;
                            max_2 = i;
                        } else {
                            max_2 = i;
                            min_2 += 1;
                        }
                    }

                    System.out.println("Check curr pos " + curr_pos + " vs min_1 " + min_1);
                    if (min_1 != -1 && curr_pos > min_1) {
                        System.out.println("Inner 0 " + curr_pos);
                        int t = nums[curr_pos];
                        nums[curr_pos] = nums[min_1];
                        nums[min_1] = t;

                        curr_pos = min_1;
                        if (min_1 == max_1) {
                            min_1 = i;
                            max_1 = i;
                            System.out.println("Setting new min max 1 values with i = " + i + "Min 1 " + min_1 + " Max 1 " + max_1);
                        } else {
                            max_1 = i;
                            min_1 += 1;
                            System.out.println("Setting new min max 1 values with i = " + i + "Min 1 " + min_1 + " Max 1 " + max_1);
                        }
                    }
                    if (curr_pos > max_0)
                        max_0 = curr_pos;
                    if (curr_pos < min_0) {
                        if (min_0 == max_0)
                            max_0 = curr_pos;
                        min_0 = curr_pos;
                    }
                    break;
                case 1:
                    if (min_1 == -1) {
                        min_1 = curr_pos;
                        max_1 = curr_pos;
                    }
                    if (min_2 != -1 && curr_pos > min_2) {
                        int t = nums[curr_pos];
                        nums[curr_pos] = nums[min_2];
                        nums[min_2] = t;

                        curr_pos = min_2;

                        if (min_2 == max_2) {
                            min_2 = i;
                            max_2 = i;
                        } else {
                            max_2 = i;
                            min_2 += 1;
                        }
                    }
                    if (curr_pos > max_1) {
                        max_1 = curr_pos;
                    }
                    if (curr_pos < min_1) {
                        if (min_1 == max_1)
                            max_1 = curr_pos;
                        min_1 = curr_pos;
                    }
                    break;
                case 2:
                    if (min_2 == -1) {
                        min_2 = curr_pos;
                        max_2 = curr_pos;
                    }
                    if (curr_pos > max_2)
                        max_2 = curr_pos;
                    break;
            }
            System.out.println(Arrays.toString(nums));
        }
    }

    private void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
}
