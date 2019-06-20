package Leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Permutations {

    private static List<List<Integer>> ans;
    private static TreeSet<List<Integer>> sortedAns;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        ans = permute(arr);
        System.out.println(Arrays.toString(ans.toArray()));
        sc.close();
    }


    private static List<List<Integer>> permute(int[] nums) {
        sortedAns = new TreeSet<>((o1, o2) -> {
            for (int i = 0; i < o1.size(); i++) {
                int a = o1.get(i);
                int b = o2.get(i);
                if (a != b) {
                    if (a > b) {
                        return -1;
                    } else return 1;
                }
            }
            return 0;
        });
        generatePermutatuions(nums, 0);
        ans = new ArrayList<List<Integer>>(sortedAns);
        return ans;
    }

    private static void generatePermutatuions(int[] nums, int fixed) {
        if (fixed == nums.length) {
            List<Integer> permutation = Arrays.stream(nums).boxed().collect(Collectors.toList());
            System.out.println(Arrays.toString(permutation.toArray()));
            sortedAns.add(permutation);
            return;
        } else {
            for (int i = fixed; i < nums.length; i++) {
                nums = swap(nums, fixed, i);
                generatePermutatuions(nums, fixed + 1);
                nums = swap(nums, fixed, i);
            }
        }
    }

    private static int[] swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
        return arr;
    }
}
