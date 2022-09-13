/**
 *  solve: 5분
 */

package programmers.programmers.private2208.week4.test2;

import java.util.HashMap;

public class Solution2 {
  public int solution(int[] poketmonIds) {
    int numUniquePoketmon = getNumUniquePoketmon(poketmonIds);
    return Math.min(numUniquePoketmon, poketmonIds.length / 2);
  }

  private int getNumUniquePoketmon(int[] poketmonIds) {
    HashMap<Integer, Integer> poketmonIdToCount = new HashMap<>(poketmonIds.length);

    for (int id : poketmonIds) {
      int count = poketmonIdToCount.getOrDefault(id, 0);
      poketmonIdToCount.put(id, count + 1);
    }

    return poketmonIdToCount.values().size();
  }
}
