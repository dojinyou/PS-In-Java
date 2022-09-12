/**
 *  solve: 1분
 */


package programmers.programmers.private2208.week4;

import java.util.Arrays;

public class Solution1 {
  public double solution(int[] arr) {
    return Arrays.stream(arr).average().getAsDouble();
  }
}
