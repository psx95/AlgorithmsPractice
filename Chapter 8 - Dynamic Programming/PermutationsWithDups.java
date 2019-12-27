import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class PermutationsWithDups {
    private static List<String> result;

    public static void main(String[] args) {
        String word = args[0];
        result = new ArrayList<>();
        String acc = "";
        permuteDups(word, generateCountMap(word), acc);
        printList(result);
    }

    // runtime still n!
    private static void permuteDups(String str, Map<Character, Integer> countMap, String acc) {
        if (acc.length() == str.length()) {
            result.add(acc);
        } else {
            for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
                int count = entry.getValue();
                char key = entry.getKey();
                if (count > 0) {
                    countMap.put(key, count - 1);
                    permuteDups(str, countMap, acc + key); // so that acc does not change in the recursion stack
                    countMap.put(key, count); // resetting the count again for the next character
                }
            }
        }
    }

    private static Map<Character, Integer> generateCountMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char x;
        for (int i = 0; i < s.length(); i++) {
            x = s.charAt(i);
            int currentCount = map.getOrDefault(x, 0);
            map.put(x, currentCount + 1);
        }
        return map;
    }

    private static <T> void printList(List<T> list) {
        System.out.println("[");
        for (T data : list) {
            System.out.println("\t" + data);
        }
        System.out.println("]");
    }
}