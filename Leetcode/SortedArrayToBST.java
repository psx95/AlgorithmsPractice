public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return getRootNode(nums, 0, nums.length - 1);
    }

    private TreeNode getRootNode(int[]nums, int first, int last) {    
        if (last < first) {
            return null;
        }
         else {
            int midPos = first + (last - first) / 2;
            TreeNode root = new TreeNode(nums[midPos]);
            root.left = getRootNode(nums, first, midPos);
            root.right = getRootNode(nums, midPos, last);
            return root;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}