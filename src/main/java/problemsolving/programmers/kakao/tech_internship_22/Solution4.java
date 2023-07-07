package problemsolving.programmers.kakao.tech_internship_22;

import java.util.Arrays;

public class Solution4 {

  int[][] paths;

  int minRouteIntensity = Integer.MAX_VALUE;
  int minRouteSummit = 0;

  public int[] solution(
      int n,
      // 산의 지점수
      int[][] paths,
      // 등산로의 정보
      int[] gates,
      // 출입구의 정보
      int[] summits
      // 산봉우리의 정보
  ) {
    init(n, paths, summits);

    Arrays.sort(summits);
    findMinIntensityRoute(gates, summits);

    return new int[]{minRouteSummit, minRouteIntensity};
  }

  private void findMinIntensityRoute(
      int[] gates,
      int[] summits
  ) {
    for (int gate : gates) {
      int[] intensityRoutes = getMinIntensityRoutesFrom(gate);
      for (int summit : summits) {
        int minIntensity = intensityRoutes[summit];
        if (minRouteSummit == 0 || minIntensity < minRouteIntensity) {
          minRouteIntensity = minIntensity;
          minRouteSummit = summit;
        }
      }
    }
  }

  private int[] getMinIntensityRoutesFrom(int gate) {
    int[] minIntensityRoutes = new int[paths.length];
    Arrays.fill(minIntensityRoutes, Integer.MAX_VALUE);
    minIntensityRoutes[gate] = 0;
    boolean[] visited = new boolean[paths.length];

    updateRoutes(minIntensityRoutes, visited, gate);

    return minIntensityRoutes;
  }

  private void updateRoutes(
      int[] minIntensityRoutes,
      boolean[] visited,
      int mountainPoint
  ) {
    visited[mountainPoint] = true;

    for (int nextMountainPoint = 1; nextMountainPoint < paths[mountainPoint].length; nextMountainPoint++) {
      int cost = paths[mountainPoint][nextMountainPoint];

      if (cost == 0 || // current -> next 불가능
          minIntensityRoutes[mountainPoint] == Integer.MAX_VALUE || // start -> current 불가능
          minIntensityRoutes[nextMountainPoint] < Math.max(minIntensityRoutes[mountainPoint], cost)) { // 비용이 줄지 않는 경우
        continue;
      }

      minIntensityRoutes[nextMountainPoint] = Math.max(minIntensityRoutes[mountainPoint], cost);
    }

    int minCostMountainPoint = getMinCostMountainPoint(minIntensityRoutes, visited);
    if (minCostMountainPoint != 0) {
      updateRoutes(minIntensityRoutes, visited, minCostMountainPoint);
    }
  }

  private int getMinCostMountainPoint(
      int[] minIntensityRoutes,
      boolean[] visited
  ) {
    int minIntensityMountainPoint = 0;
    int minIntensity = Integer.MAX_VALUE;

    for (int mountainPoint = 1; mountainPoint < minIntensityRoutes.length; mountainPoint++) {
      if (visited[mountainPoint]) {
        continue;
      }

      int intensity = minIntensityRoutes[mountainPoint];
      if (minIntensityMountainPoint == 0 || intensity < minIntensity) {
        minIntensityMountainPoint = mountainPoint;
        minIntensity = intensity;
      }
    }

    return minIntensityMountainPoint;
  }

  private void init(
      int n,
      int[][] paths,
      int[] summits
  ) {
    boolean[] isSummit = new boolean[n+1];
    for (int summit: summits) {
      isSummit[summit] = true;
    }

    this.paths = new int[n + 1][n + 1];
    for (int[] path : paths) {
      int point1 = path[0];
      int point2 = path[1];
      int cost = path[2];

      if (!isSummit[point1]) {
        this.paths[point1][point2] = cost;
      }
      if (!isSummit[point2]) {
        this.paths[point2][point1] = cost;
      }
    }
  }

  public static void main(String[] args) {
    new Solution4().solution(
        7,
        new int[][]{{1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}},
        new int[]{3, 7},
        new int[]{1, 5}
    );
  }
}
