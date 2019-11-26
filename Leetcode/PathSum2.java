import java.util.ArrayList;
import java.util.List;

import Leetcode.SameTree.TreeNode;

public class PathSum2 {
  private List<List<Integer>> answer;

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    answer = new ArrayList<>();
    return null;
  }

  public List<List<Integer>> findSum(TreeNode root, int sum, List<Integer> currList, int acc) {
    if (root == null) {
      if (acc == sum) {
        answer.add(currList);
      }
      return answer;
    } else {
      currList.add(root.val);
      findSum(root.left, sum, currList, sum + root.val);
      currList.remove(currList.size() - 1);
      findSum(root.right, sum, currList, sum + root.val);
    }
  }
}
