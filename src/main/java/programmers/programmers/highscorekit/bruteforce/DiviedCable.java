package programmers.programmers.highscorekit.bruteforce;

public class DiviedCable {
  /**
   *
   * @param n n개의 송전탑 (2~100)
   * @param wires - 송전탑 사이의 전선 (n-1) / 원소는 [v1,v2]로 v1과 v2 사이의 전선을 의미
   * @return 나눠진 두 송전탑 트리의 차이에 절대값
   */

  private int result;
  private int numOfTower;
  private boolean[][] wireMap;
  private boolean[] visited;

  public int solution(
      int n,
      int[][] wires
  ) {
    result = n;
    numOfTower = n;
    initWireMap(wires);

    searchDiviedPoint(1);

    return result;
  }

  private void initWireMap(
      int[][] wires
  ) {
    visited = new boolean[numOfTower + 1];
    wireMap = new boolean[numOfTower + 1][numOfTower + 1];

    for (int[] wire : wires) {
      int from = wire[0];
      int to = wire[1];
      wireMap[from][to] = true;
      wireMap[to][from] = true;
    }
  }

  private int searchDiviedPoint(
      int i
  ) {
    visited[i] = true;
    int count = 1;

    for (int next = 1; next < wireMap[i].length; next++) {
      if (!visited[next] && wireMap[i][next]) {
        int num = searchDiviedPoint(next);
        updateResult(num);
        count += num;
      }
    }
    visited[i] = false;
    updateResult(count);

    return count;
  }

  private void updateResult(int num) {
    int localResult = Math.abs((2 * num)- numOfTower);
    result = Math.min(localResult, result);
  }
}
