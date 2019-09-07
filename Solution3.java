import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution3 {
    public static void main (String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements");
        int n = 1;
        n = sc.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(threeSum(nums));
        sc.close();
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> a = new ArrayList<List<Integer>>();
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        ArrayList<Integer> uniqueElements = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                ArrayList<Integer> indices = hashMap.get(nums[i]);
                indices.add(i);
                hashMap.put(nums[i], indices);
            } else {
                uniqueElements.add(nums[i]);
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                hashMap.put(nums[i], temp);
            }
        }
        for (int i = 0; i < uniqueElements.size() - 1; i++) {
            int currElement = uniqueElements.get(i);
            List<Integer> currList = new ArrayList<>();
            for (int j = i+1; j < uniqueElements.size(); j++) {
                int nextElement = uniqueElements.get(j);               
                int findElement = (-1)*(currElement+nextElement);
                if (hashMap.containsKey(findElement) && findElement!=currElement && findElement!=nextElement) {
                    currList.add(currElement);
                    currList.add(nextElement);
                    currList.add((-1)*(currElement+nextElement));
                    a.add(currList);            
                    break;
                }
            }        
        }
        return a;
    }

    public static String longestCommonPrefix(String[] strs) {
        String longestCommon = "";
        StringBuilder common = new StringBuilder("");
        for (String currWord : strs) {            
            if (i == 0) {
                longestCommon = currWord;
            } else {
                int counter = 0;
                common.setLength(0);
                for (int j = 0; j < Math.min(currWord.length(), longestCommon.length()); j++) {
                    char x = longestCommon.charAt(counter++); // character from longestCommon
                    char y = currWord.charAt(j); // character from currWord
                    if (x == y) {
                        common.append(x);
                    } else {
                        break;
                    }
                }
                longestCommon = common.toString();        
            }
            if (longestCommon.equals("")){
                break;
            }
        }
        return longestCommon;        
    }
}