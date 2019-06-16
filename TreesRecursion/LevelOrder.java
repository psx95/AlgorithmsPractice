package TreesRecursion;

import java.lang.reflect.Array;
import java.util.*;

public class LevelOrder {


    private List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<String, Boolean> markedNodes = new HashMap<>();
        HashMap<String, Integer> treeNodeToLevelMapping = new HashMap<>();
        markedNodes.put(root.toString(), true);
        q.add(root);
        int currentLevel;
        int prevLevel = 0;
        treeNodeToLevelMapping.put(root.toString(), 0);
        ArrayList<Integer> row = null;
        while (!q.isEmpty()) {
            TreeNode r = q.remove();
            if (r != null) {
                currentLevel = treeNodeToLevelMapping.get(r.toString());

                if (prevLevel != currentLevel) {
                    ans.add(row);
                    if (row != null)
                        System.out.println(Arrays.toString(row.toArray()));
                    else {
                        System.out.println("[null]");
                    }
                    row = new ArrayList<Integer>();
                    prevLevel = currentLevel;
                }

                if (row == null)
                    row = new ArrayList<>();
                row.add(r.val);
            }
            if (r != null) {
                if (r.left != null && (!markedNodes.containsKey(r.left.toString()) || !markedNodes.get(r.left.toString()))) {
                    markedNodes.put(r.left.toString(), true);
                    q.add(r.left);
                    treeNodeToLevelMapping.put(r.left.toString(), treeNodeToLevelMapping.get(r.toString()) + 1);
                }
                if (r.right != null && (!markedNodes.containsKey(r.right.toString()) || !markedNodes.get(r.right.toString()))) {
                    markedNodes.put(r.right.toString(), true);
                    q.add(r.right);
                    treeNodeToLevelMapping.put(r.right.toString(), treeNodeToLevelMapping.get(r.toString()) + 1);
                }
            }
        }
        if (row != null && row.size() > 0)
            ans.add(row);
        return ans;
    }

    private HashMap<Integer, ArrayList<TreeNode>> addNodeToMap(TreeNode treeNode, int level, HashMap<Integer, ArrayList<TreeNode>> map) {
        if (map.containsKey(level)) {
            ArrayList<TreeNode> n = map.get(level);
            n.add(treeNode);
            map.put(level, n);
        } else {
            ArrayList<TreeNode> n = new ArrayList<>();
            n.add(treeNode);
            map.put(level, n);
        }
        return map;
    }

    private List<Integer> addQueueElementsToArray(Queue<TreeNode> q) {
        List<Integer> arr = new ArrayList<>();
        for (TreeNode t : q) {
            arr.add(t.val);
        }
        return arr;
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
