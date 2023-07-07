/**
 *  백준 / 11779 / 최소비용 구하기 2
 *  https://www.acmicpc.net/problem/11779
 *
 */

package problemsolving.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution11779 {

  int[][] routes;

  public void Solution() {
    init();
  }

  private void init() {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      StringTokenizer st;
      int numOfCities = Integer.parseInt(br.readLine());
      int numOfBus = Integer.parseInt(br.readLine());
      routes = new int[numOfCities + 1][numOfCities + 1];
      Arrays.fill(routes, Integer.MAX_VALUE);
      for (int i = 0; i < numOfBus; i++) {
        String[] readline = br
            .readLine()
            .split(" ");
        int from = Integer.parseInt(readline[0]);
        int to = Integer.parseInt(readline[1]);
        int cost = Integer.parseInt(readline[2]);

        routes[from][to] = cost;
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
