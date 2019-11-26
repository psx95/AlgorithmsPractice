import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UncommonWords {
    public String[] uncommonFromSentences(String A, String B) {
        String[] arrA = A.split("\\s+");
        String[] arrB = B.split("\\s+");
        HashMap<String, Integer> mapA = createMap(arrA);
        HashMap<String, Integer> mapB = createMap(arrB);
        Set<String> ans = new HashSet<>();
        for (Map.Entry<String, Integer> entry : mapA.entrySet()) {
            if (entry.getValue() == 1) {
                String word = entry.getKey();
                if (mapB.get(word) == null) {
                    ans.add(word);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : mapB.entrySet()) {
            if (entry.getValue() == 1) {
                String word = entry.getKey();
                if (mapA.get(word) == null) {
                    ans.add(word);
                }
            }
        }
        String[] res = new String[ans.size()];
        return ans.toArray(res);
    }
    
    public HashMap<String, Integer> createMap(String[] arr) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            if (map.containsKey(word)) {
                int count = mapA.get(word);
                count++;
                map.put(word, count);
            } else {
                map.put(word, 1);
            }
        }
        return map;
    }
}