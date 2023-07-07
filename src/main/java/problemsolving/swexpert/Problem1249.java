package problemsolving.swexpert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Problem1249 {
  public static void main(String[] args) throws FileNotFoundException {
    System.setIn(new FileInputStream("res/1249input.txt"));
    Scanner sc = new Scanner(System.in);

    final int numOfTestCase = Integer.parseInt(sc.nextLine());

    for (int testCase = 1; testCase <= numOfTestCase; testCase++) {
      int answer = searchLoad(sc);
      System.out.println("#" + testCase + " " + answer);
    }
  }

  private static int searchLoad(Scanner sc) {
    final int notVisitedValue = -1;
    final int mapSize = Integer.parseInt(sc.nextLine());
    int[][] recoveryTimeMap = new int[mapSize][mapSize];
    int[][] totalRecoveryTimeMap = new int[mapSize][mapSize];
    for (int i = 0; i < mapSize; i++) {
      Arrays.fill(totalRecoveryTimeMap[i], notVisitedValue);
    }

    final int targetX = mapSize - 1;
    final int targetY = mapSize - 1;

    final int[][] direction = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    final int directionXIdx = 0;
    final int directionYIdx = 1;

    initMap(sc, mapSize, recoveryTimeMap);

    final Queue<SearchInfo> queue = new ArrayDeque<>();
    final SearchInfo firstLocation = new SearchInfo(0, 0, 0);
    queue.add(firstLocation);
    totalRecoveryTimeMap[0][0] = 0;
    int minTotalRecoveryTime = Integer.MAX_VALUE;
    while (!queue.isEmpty()) {
      final SearchInfo currentLocation = queue.poll();

      if (currentLocation.locationX == targetX
          && currentLocation.locationY == targetY) {
        if (currentLocation.totalRecoveryTime < minTotalRecoveryTime) {
          minTotalRecoveryTime = currentLocation.totalRecoveryTime;
          continue;
        }
      }

      for (int i = 0; i < 4; i++) {
        final int nextX = currentLocation.locationX + direction[i][directionXIdx];
        final int nextY = currentLocation.locationY + direction[i][directionYIdx];

        if (nextX < 0 || mapSize <= nextX || nextY < 0 || mapSize <= nextY) {
          continue;
        }

        final int nextRecoveryTime =
            currentLocation.totalRecoveryTime + recoveryTimeMap[nextX][nextY];

        if (totalRecoveryTimeMap[nextX][nextY] == notVisitedValue
            || totalRecoveryTimeMap[nextX][nextY] > nextRecoveryTime) {
          totalRecoveryTimeMap[nextX][nextY] = nextRecoveryTime;
          queue.add(new SearchInfo(nextX, nextY, nextRecoveryTime));
        }
      }
    }
    return minTotalRecoveryTime;
  }

  private static void initMap(Scanner sc, int mapSize, int[][] recoveryTimeMap) {
    for (int row = 0; row < mapSize; row++) {
      char[] recoverTimeRow = sc.nextLine().toCharArray();

      for (int col = 0; col < mapSize; col++) {
        int recoverTime = Character.getNumericValue(recoverTimeRow[col]);
        recoveryTimeMap[row][col] = recoverTime;
      }
    }
  }

  private static class SearchInfo {
    final int locationX;
    final int locationY;
    final int totalRecoveryTime;

    private SearchInfo(int locationX, int locationY, int totalRecoveryTime) {
      this.locationX = locationX;
      this.locationY = locationY;
      this.totalRecoveryTime = totalRecoveryTime;
    }
  }
}
