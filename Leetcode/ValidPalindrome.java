public class ValidPalindrome {

  public static void main(String[] args) {
    System.out.println(isPalindrome("race a car"));
  }

  public static boolean isPalindrome(String s) {
    char start, end;
    if (s.length() == 0) {
      return true;
    }
    for (int i = 0, j = s.length() - 1; i <= j; i += 0) {
      start = s.charAt(i);
      end = s.charAt(j);
      while (!Character.isLetterOrDigit(start)) {
        i += 1;
        if (i < s.length())
          start = s.charAt(i);
        else
          return true;
      }
      while (!Character.isLetterOrDigit(end)) {
        j -= 1;
        if (j > 0)
          end = s.charAt(j);
        else
          return true;
      }
      if (start != end) {
        if (Character.isLetter(start) && Character.isLetter(end)) {
          if ((Math.abs(start - end) != 32)) {
            return false;
          }
        } else {
          return false;
        }
      }
      i += 1;
      j -= 1;
    }
    return true;
  }
}
