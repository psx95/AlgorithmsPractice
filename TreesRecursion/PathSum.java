package TreesRecursion;

import java.util.HashMap;

public class PathSum {

    private int s = 0;
    private boolean ans = false;
    private HashMap<String, Boolean> visited = new HashMap<>();

    public boolean hasPathSum(TreeNode root, int sum) {
        if (ans || root == null)
            return ans;
        if (isLeafNode(root)) {
            s += root.val;
            ans = s == sum;
            System.out.println("Matching "+s+" with "+sum);
            return ans;
        } else {
            s+=root.val;
        }
        if (root.left != null && nodeNotVisted(root.left)) {
            visited.put(root.left.toString(), true);
            if (!hasPathSum(root.left, sum)) {
                s -= root.left.val;
                System.out.println("Reduced to left" + s);
            }
        }
        if (root.right != null && nodeNotVisted(root.right)) {
            visited.put(root.right.toString(), true);
            if (!hasPathSum(root.right, sum)) {
                s -= root.right.val;
                System.out.println("Reduced to right" + s);
            }
        }
        return ans;
    }

    private boolean nodeNotVisted(TreeNode node) {
        return (!visited.containsKey(node.toString()) || !visited.get(node.toString()));
    }

    private boolean isLeafNode (TreeNode root) {
        return root!=null && root.left == null && root.right == null;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
