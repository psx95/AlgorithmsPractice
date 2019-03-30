public class Solution1 {
    public static void main (String... args) {
        System.out.println (isUnique(args[0]));
        System.out.println ("Without additional array "+isUniqueWithoutArray(args[0]));
    }

    private static boolean isUnique(String s) {
        int a[] = new int[128];         
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (a[x] == 1) {
                return false;
            } else {
                a[x] = 1;
            }        
        }
        return true;
    }

    private static boolean isUniqueWithoutArray(String s) {
        for (int i = 0; i< s.length(); i++) {
            for (int j= i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}