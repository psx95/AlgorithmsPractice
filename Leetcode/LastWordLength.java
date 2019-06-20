import java.util.Scanner;

class LastWordLength {
    public static void main (String Args[]) {
        Scanner sc = new Scanner (System.in);
        System.out.println ("Enter a String");
        String s = sc.next();
        System.out.println ("Length of last word of string is "+lengthOfLastWord(s));
        sc.close();
    }

    private static int lengthOfLastWord(String s) {
        int length = s.length();
        boolean lastWordStarted = false;
        int ans = 0;
        for (int i=length -1; i >=0; i--) {
            char x = s.charAt(i);
            if (x == 32) {
                if (lastWordStarted){
                    return ans;
                }
            } else {
                ans++;
                lastWordStarted = true;
            }
        }
        return ans;
    }
}