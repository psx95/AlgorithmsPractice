import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;

public class ThreeSum {
  public static void main(String Args[]) {
    System.out.println("Enter the number of elements");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println("Enter the elements");
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println("Result - " + Arrays.toString(threeSum(arr).toArray()));
    sc.close();
  }

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    Set<List<Integer>> result = new HashSet<>();
    HashMap<Integer, Integer> indexMapping = formHashMap(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      int currNum = nums[i];
      if (currNum == 0 && i == indexMapping.get(0)) {
          break;
      }
      for (int j = i + 1; j < nums.length - 1; j++) {
        int partialSum = currNum + nums[j];
        if (indexMapping.containsKey(0 - partialSum) && indexMapping.get(0 - partialSum) > j) {
          ArrayList<Integer> integers = new ArrayList<>();
          integers.add(currNum);
          integers.add(nums[j]);
          integers.add(0 - partialSum);
          result.add(integers);
        }
      }
    }
    return new ArrayList<>(result);
  }

  private HashMap<Integer, Integer> formHashMap(int[] nums) {
    HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      integerIntegerHashMap.put(nums[i], i);
    }
    return integerIntegerHashMap;
  }

}