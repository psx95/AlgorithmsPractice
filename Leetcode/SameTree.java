package Leetcode;

public class SameTree {

  private boolean ans = true;

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if ((p == null && q == null) || !ans) {
      return ans;
    } else {
      ans = checkNode(p, q);
      if (!ans)
        return ans;
      isSameTree(p.left, q.left);
      isSameTree(p.right, q.right);
    }
    return ans;
  }

  private boolean checkNode(TreeNode p, TreeNode q) {
    if ((p != null && q == null) || (q != null && p == null)) {
      return false;
    } else if (p != null) {
      if (p.val != q.val) {
        return false;
      } else if (p.right != null && q.right != null) {
        return p.right.val == q.right.val;
      } else if (p.left != null && q.left != null) {
        return p.left.val == q.left.val;
      } else if ((p.right == null && q.right != null) || (p.right != null && q.right == null)) {
        return false;
      } else if ((p.left == null && q.left != null) || (p.left != null && q.left == null)) {
        return false;
      }
    }
    return true;
  }

  public static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
