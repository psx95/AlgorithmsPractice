import java.util.ArrayList;
import java.util.List;

public class GreaterTree {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        List<Integer> a = sortedArray(root, new ArrayList<>());
        int[] b = sumArray(a);
        convertToGreaterTree(root, a, b);
        return root;
    }
    
    private void convertToGreaterTree (TreeNode root, List<Integer> sortedArray, int[] sum) {
        if (root == null){
            return;
        }
        int pos = binarySearch(sortedArray, 0, sortedArray.size() - 1, root.val);
        root.val += sum[pos];
        convertToGreaterTree(root.left, sortedArray, sum);
        convertToGreaterTree(root.right, sortedArray, sum);
    }
    
    private int binarySearch(List<Integer> a, int start, int end, int num) {        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a.get(mid) == num) {
                return mid;
            } else if (a.get(mid) > num) {
                return binarySearch(a, start, mid-1, num);
            } else {
                // a.get(mid) < num
                return binarySearch(a, mid+1, end, num);
            }
        }
        return -1;
    }
    
    private List<Integer> sortedArray(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return arr;
        } else {
            sortedArray(root.left, arr);
            arr.add(root.val);
            sortedArray(root.right, arr);
            return arr;
        }
    }
    
    private int[] sumArray(List<Integer> arr) {
        int[] result = new int[arr.size()];
        int sum = 0;
        for (int i = arr.size() - 1; i >= 0; i--) {
            if (i != arr.size() - 1) {
                result[i] = sum;            
                sum += arr.get(i);
            } else {
                result[i] = sum;
                sum += arr.get(i);
            }
        }
        return result;
    }
}