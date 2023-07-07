/**
 *  프로그래머스 LV.3 / 118668 / 코딩 테스트 공부
 *  https://school.programmers.co.kr/learn/courses/30/lessons/118668
 *  fail: 1시간, add 풀이 참고
 */
package problemsolving.programmers.kakao.tech_internship_22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {
  private static final int IDX_ALP_REQ = 0;
  private static final int IDX_COP_REQ = 1;
  private static final int IDX_ALP_RES = 2;
  private static final int IDX_COP_RES = 3;
  private static final int IDX_COST = 4;
  public static final int MAX_ALP = 150;
  public static final int MAX_COP = 150;

  private int[][] dp;

  private int targetAlp = 0;
  private int targetCop = 0;

  private List<Problem> problemList;

  public int solution(
      int alp,
      int cop,
      int[][] problems
  ) {
    init(alp, cop, problems);

    updateDp(alp, cop);

    return dp[targetAlp][targetCop];
  }

  private void updateDp(
      int alp,
      int cop
  ) {
    for (int currentAlp = alp; currentAlp <= targetAlp; currentAlp++) {
      for (int currentCop = cop; currentCop <= targetCop; currentCop++) {
        for (Problem problem : problemList) {
          if (!problem.isSolve(currentAlp, currentCop)) {
            continue;
          }

          int solvedAlp = Math.min(currentAlp + problem.alpRes, targetAlp);
          int solvedCop = Math.min(currentCop + problem.copRes, targetCop);

          dp[solvedAlp][solvedCop] = Math.min(dp[solvedAlp][solvedCop], dp[currentAlp][currentCop] + problem.cost);
        }
      }
    }
  }

  private void init(
      int alp,
      int cop,
      int[][] problems
  ) {
    initDp(alp, cop);

    initProblems(problems);
  }

  private void initProblems(int[][] problems) {
    problemList = new ArrayList<>(problems.length + 2);

    problemList.add(new Problem(0, 1, 0, 0, 1));
    problemList.add(new Problem(0, 0, 0, 1, 1));

    for (int[] problem : problems) {
      targetAlp = Math.max(targetAlp, problem[IDX_ALP_REQ]);
      targetCop = Math.max(targetCop, problem[IDX_COP_REQ]);

      problemList.add(new Problem(
          problem[IDX_ALP_REQ],
          problem[IDX_ALP_RES],
          problem[IDX_COP_REQ],
          problem[IDX_COP_RES],
          problem[IDX_COST]
      ));
    }
  }

  private void initDp(
      int alp,
      int cop
  ) {
    dp = new int[MAX_ALP + 1][MAX_COP + 1]; // i, i 능력을 얻는 데 걸리는 최소 시간.

    for (int[] row : dp) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }

    for (int i = 0; i <= alp; i++) {
      for (int j = 0; j <= cop; j++) {
        dp[i][j] = 0;
      }
    }
  }

  public static void main(String[] args) {
    new Solution3().solution(0, 0, new int[][]{{0, 0, 2, 1, 2}, {4, 5, 3, 1, 2}, {4, 11, 4, 0, 2}, {10, 4, 0, 4, 2}});
  }

  class Problem {
    final int alpReq;
    final int alpRes;
    final int copReq;
    final int copRes;
    final int cost;

    public Problem(
        int alpReq,
        int alpRes,
        int copReq,
        int copRes,
        int cost
    ) {
      this.alpReq = alpReq;
      this.alpRes = alpRes;
      this.copReq = copReq;
      this.copRes = copRes;
      this.cost = cost;
    }

    public boolean isSolve(
        int currentAlp,
        int currentCop
    ) {
      return alpReq <= currentAlp && copReq <= currentCop;
    }
  }
}
