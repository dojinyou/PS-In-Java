/**
 * solve: 2분
 */

package programmers.programmers.private2208.week4;

public class Solution2 {
  boolean solution(String s) {
    int countP = 0;
    int countY = 0;
    s = s.toLowerCase();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'y') {
        countY++;
      }

      if (s.charAt(i) == 'p') {
        countP++;
      }
    }


    return countP == countY;
  }
}
