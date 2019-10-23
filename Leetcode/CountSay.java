public class CountSay {
    public String countAndSay(int n) {
        String next = "1";
        String ans = "1";
        for (int i = 1; i <= n; i++) {
            if (i != 1) 
             {
                next = countSay(next);
                if (i == n)
                ans = next;
            }            
        }
        return ans;
    }
    
    public String countSay (String s) {
        char lastChar = 'x', currChar;
        int count = 0;
        boolean allDone = false;
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            currChar = s.charAt(i);
            if (lastChar == 'x') {
                lastChar = currChar;
                count++;
            } else if (lastChar == currChar) {
                count++;
            } else {
                // lastChar != currChar                
                str.append(count).append(lastChar);
                count = 1;
            }
            lastChar = currChar;          
        }
        if (!allDone)
            str.append(count).append(lastChar);
        //System.out.println ("returning "+str.toString());
        return str.toString();
    }   
}