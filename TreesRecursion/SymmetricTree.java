package TreesRecursion;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    private boolean isNodeMirror(TreeNode a, TreeNode b) {
        if (a != null && b != null) {
            if (a.val == b.val) {
                if (a.left != null && b.right != null && a.left.val == b.right.val && a.right != null && b.left != null && a.right.val == b.left.val) {
                    return true;
                } else if ((a.left == null && a.right != null)) {
                    if (b.right == null && b.left != null && a.right.val == b.left.val) {
                        return true;
                    }
                } else if ((a.right == null && a.left != null)) {
                    if (b.left == null && b.right != null && b.right.val == a.left.val) {
                        return true;
                    }
                } else if (a.right == null) {
                    if (b.left == null && b.right == null) {
                        return true;
                    }
                }
            }
            return false;
        } else if (a == null && b != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Queue<SymmetricTree.TreeNode> q = new LinkedList<>();
        HashMap<String, Boolean> markedNodes = new HashMap<>();
        markedNodes.put(root.toString(), true);
        q.add(root);
        boolean rootDone = false;
        while (!q.isEmpty()) {
            if (!rootDone) {
                TreeNode r = q.remove();
                rootDone = true;
                if (r != null) {
                    if (r.left != null && (!markedNodes.containsKey(r.left.toString()) || !markedNodes.get(r.left.toString()))) {
                        markedNodes.put(r.left.toString(), true);
                        q.add(r.left);
                    }
                    if (r.right != null && (!markedNodes.containsKey(r.right.toString()) || !markedNodes.get(r.right.toString()))) {
                        markedNodes.put(r.right.toString(), true);
                        q.add(r.right);
                    }
                }
            } else {
                TreeNode a = q.remove();
                if (q.isEmpty())
                    return false;
                else {
                    TreeNode b = q.remove();
                    if (!isNodeMirror(a,b)) {
                        return false;
                    } else {
                        addNodeToQueue(a, markedNodes, q, true);
                        addNodeToQueue(b, markedNodes, q, false);
                        addNodeToQueue(a, markedNodes, q, false);
                        addNodeToQueue(b, markedNodes, q, true);
                    }
                }
            }
        }
        return true;
    }


    private void addNodeToQueue (TreeNode r, HashMap<String, Boolean> markedNodes, Queue<TreeNode> q, boolean left) {
        if (left) {
            if (r.left != null && (!markedNodes.containsKey(r.left.toString()) || !markedNodes.get(r.left.toString()))) {
                markedNodes.put(r.left.toString(), true);
                q.add(r.left);
            }
        } else {
            if (r.right != null && (!markedNodes.containsKey(r.right.toString()) || !markedNodes.get(r.right.toString()))) {
                markedNodes.put(r.right.toString(), true);
                q.add(r.right);
            }
        }
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
