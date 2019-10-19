import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> finalRes = new ArrayList<>();
    List<Integer> one = new ArrayList<>();
    one.add(1);
    if (numRows >= 1)
      finalRes.add(one);
    List<Integer> two = new ArrayList<>();
    two.add(1);
    two.add(1);
    if (numRows >= 2)
      finalRes.add(two);
    for (int i = 2; i < numRows; i++) {
      List<Integer> prev = finalRes.get(i - 1);
      List<Integer> current = new ArrayList<>();
      current.add(1);
      for (int j = 0; j < prev.size() - 1; j++) {
        current.add(prev.get(j) + prev.get(j + 1));
      }
      current.add(1);
      finalRes.add(current);
    }
    return finalRes;
  }
}
