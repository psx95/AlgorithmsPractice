import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LevelOrderTraversal {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> finalResult = new ArrayList<>();
    Map<TreeNode, Integer> nodeToLevelMapping = new LinkedHashMap<>();
    Map<Integer, List<Integer>> levelToNodeMapping = new LinkedHashMap<>();
    Queue<TreeNode> nodeQueue = new LinkedList<>();
    if (root == null) {
      return finalResult;
    }
    nodeQueue.add(root);
    nodeToLevelMapping.put(root, 0);
    int currLevel = 0;
    int prevLevel = 0;
    while (!nodeQueue.isEmpty()) {
      TreeNode curr = nodeQueue.remove();
      currLevel = nodeToLevelMapping.get(curr);
      if (currLevel == 0) {
        finalResult.add(new ArrayList<Integer>() {{
          add(curr.val);
        }});
      } else if (prevLevel != currLevel) {
        getListForLevel(finalResult, levelToNodeMapping, prevLevel);
      }
      prevLevel = currLevel;
      addChildrenToQueue(curr, nodeQueue, currLevel, nodeToLevelMapping, levelToNodeMapping);
    }
    getListForLevel(finalResult, levelToNodeMapping, currLevel);
    return finalResult;
  }

  private void getListForLevel(List<List<Integer>> finalResult, Map<Integer, List<Integer>> levelToNodeMapping, int currLevel) {
    List<Integer> integers = getLevel(currLevel, levelToNodeMapping);
    if (integers.size() > 0) {
      finalResult.add(integers);
    }
  }

  private List<Integer> getLevel(int level, Map<Integer, List<Integer>> inverseMappings) {
    return inverseMappings.containsKey(level) ? inverseMappings.get(level) : new ArrayList<>();
  }

  private void addChildrenToQueue(TreeNode rootNode, Queue<TreeNode> q, int currLevel,
                                  Map<TreeNode, Integer> mappings, Map<Integer, List<Integer>> inverseMapping) {
    if (rootNode.left != null) {
      q.add(rootNode.left);
      mappings.put(rootNode.left, currLevel + 1);
      if (inverseMapping.containsKey(currLevel + 1)) {
        List<Integer> values = inverseMapping.get(currLevel + 1);
        values.add(rootNode.left.val);
      } else {
        inverseMapping.put(currLevel + 1, new ArrayList<>() {{
          add(rootNode.left.val);
        }});
      }
    }
    if (rootNode.right != null) {
      q.add(rootNode.right);
      mappings.put(rootNode.right, currLevel + 1);
      if (inverseMapping.containsKey(currLevel + 1)) {
        List<Integer> values = inverseMapping.get(currLevel + 1);
        values.add(rootNode.right.val);
      } else {
        inverseMapping.put(currLevel + 1, new ArrayList<>() {{
          add(rootNode.right.val);
        }});
      }
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
