/**
 *  solv: 8분
 */
package programmers.programmers.private2208.week4.test2;

public class Solution1 {
  public int solution(int n, int m) {
    int count = 0;

    for (int i = n; i <= m; i++) {
      if(isPalindrome(i)) {
        count++;
      }
    }


    return count;
  }

  private boolean isPalindrome(int num) {
    return isPalindrome(String.valueOf(num));
  }

  private boolean isPalindrome(String numString) {
    int len = numString.length();

    if (len <= 1) {
      return true;
    }

    return numString.charAt(0) == numString.charAt(len - 1) && isPalindrome(numString.substring(1, len - 1));
  }
}
