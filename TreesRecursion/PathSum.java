package TreesRecursion;

import com.sun.istack.internal.NotNull;

import java.util.HashMap;

public class PathSum {

    private int s = 0;
    private boolean ans = false;
    private boolean rootDoneLeft = false;
    private boolean rootDoneRight = false;
    private boolean currentLeaf = false;
    private HashMap<String, Boolean> visited = new HashMap<>();

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            System.out.println("Sum check is " + s);
            if (s == sum && visited.size() > 0 && (currentLeaf || (!rootDoneRight && !rootDoneLeft))) {
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
            if (root.left != null
                    && (!visited.containsKey(root.left.toString()) || !visited.get(root.left.toString()))) {
                visited.put(root.left.toString(), true);
                if (!rootDoneLeft)
                    rootDoneLeft = true;
                currentLeaf = isLeafNode(root.left);
                if (!hasPathSum(root.left, sum)) {
                    s -= root.left.val;
                    System.out.println("Sum reduced to " + s);
                }
            } else if (root.left == null && rootDoneLeft) {
                if (hasPathSum(root.left, sum)) {
                    ans = true;
                }
            }
            if (root.right != null
                    && (!visited.containsKey(root.right.toString()) || !visited.get(root.right.toString()))) {
                visited.put(root.right.toString(), true);
                if (!rootDoneRight)
                    rootDoneRight = true;
                currentLeaf = isLeafNode(root.right);
                if (!hasPathSum(root.right, sum)) {
                    s -= root.right.val;
                    System.out.println("Right finished.Sum reduced to " + s);
                }
            } else if (root.right == null && rootDoneRight) {
                if (hasPathSum(root.right, sum)) {
                    ans = true;
                }
            }
            if (!rootDoneLeft && !rootDoneRight)
                return hasPathSum(null, sum);
        }
        return ans;
    }

    private boolean isLeafNode(@NotNull TreeNode node) {
        return node.left != null && node.right != null;
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
