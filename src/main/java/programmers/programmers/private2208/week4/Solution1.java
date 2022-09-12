/**
 *  프로그래머스 / 12944 / 평균 구하기
 *  https://school.programmers.co.kr/learn/courses/30/lessons/12944
 *  solve: 1분
 */


package programmers.programmers.private2208.week4;

import java.util.Arrays;

public class Solution1 {
  public double solution(int[] arr) {
    return Arrays.stream(arr).average().getAsDouble();
  }
}
