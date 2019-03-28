public class Solution6 {
    public static void main (String args[]) {
        System.out.println ("Compressed version of the string is "+compress(args[0]));
    }

    private static String compress (String a) {
        int charactersSaved = 0;
        char x, currChar = 32;
        StringBuilder str = new StringBuilder();
        int currCount = 0;
        for (int i = 0; i< a.length(); i++) {
            x = a.charAt(i);
            if (i == 0) {
                currChar = x;
                str.append(x);
                currCount+=1;
            } else {
                if (x == currChar) {
                    ++currCount;
                } else {
                    str.append(String.valueOf(currCount)).append(x);
                    currChar = x;
                    charactersSaved += (currCount - 2);
                    currCount = 1;
                }
                if (i == a.length() - 1) {
                    str.append(String.valueOf(currCount));
                    charactersSaved += (currCount - 2);
                    System.out.print("Char saved "+charactersSaved);
                }
            }
        }
        if (charactersSaved >= 0) {
            return str.toString();
        } else {
            return a;
        }
   }
}