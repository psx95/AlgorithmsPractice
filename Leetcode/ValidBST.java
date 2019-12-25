public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return isRootValid(root);
    }

    private boolean isRootValid(TreeNode root, int maxLimit, int minLimit) {
        if (root == null) {
            return true;
        } else {
            if (root.left != null && root.left.val > root.val && root.left) {
                return false;
            }
            if (root.right != null && root.right.val < root.val) {
                return false;
            }
            boolean leftValid = isRootValid(root.left);
            boolean rightValid = isRootValid(root.right);
            return leftValid && rightValid;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}