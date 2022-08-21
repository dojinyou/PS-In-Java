package programmers.programmers.highscorekit.bruteforce;

public class Fatigue {

  public final int MIN_NEED_FATIGUE_IDX = 0;
  public final int COST_FATIGUE_IDX = 1;
  public int[][] dungeons;
  public boolean[] isVisited;

  public int maxDepth = 0;

  public int solution(
      int initFatigue,
      int[][] dungeonInfos
  ) {

    dungeons = dungeonInfos;
    isVisited = new boolean[dungeonInfos.length];

    findMaxDepth(initFatigue, 0);

    return maxDepth;
  }

  private void findMaxDepth(
      int fatigue,
      int depth
  ) {

    for (int i = 0; i < dungeons.length; i++) {
      if (!isVisited[i] && dungeons[i][MIN_NEED_FATIGUE_IDX] <= fatigue) {
        isVisited[i] = true;
        int afterFatigue = fatigue - dungeons[i][COST_FATIGUE_IDX];
        findMaxDepth(afterFatigue, depth + 1);
        isVisited[i] = false;
      }
    }

    maxDepth = Math.max(maxDepth, depth);
  }
}
