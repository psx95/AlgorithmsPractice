package TreesRecursion;

import java.util.HashMap;

public class PathSum {

    private int s = 0;
    private boolean ans = false;
    private HashMap<String, Boolean> visited = new HashMap<>();

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            System.out.println("Sum check is " + s);
            if (s == sum && visited.size() > 0) {
                System.out.println("Sum matched is " + s);
                ans = true;
                return ans;
            } else {
                ans = false;
                return ans;
            }
        } else {
            if (ans)
                return ans;
            visited.put(root.toString(), true);
            s += root.val;
            if (root.left != null && (!visited.containsKey(root.left.toString()) || !visited.get(root.left.toString()))) {
                visited.put(root.left.toString(), true);
                if (!hasPathSum(root.left, sum)) {
                    s -= root.left.val;
                    System.out.println("Sum reduced to " + s);
                }
            } else if (root.left == null) {
                if (hasPathSum(root.left, sum)) {
                    ans = true;
                }
            }
            if (root.right != null && (!visited.containsKey(root.right.toString()) || !visited.get(root.right.toString()))) {
                visited.put(root.right.toString(), true);
                if (!hasPathSum(root.right, sum)) {
                    s -= root.right.val;
                    System.out.println("Right finished.Sum reduced to " + s);
                }
            } else if (root.right == null) {
                if (hasPathSum(root.right, sum)) {
                    ans = true;
                }
            }
        }
        return ans;
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
