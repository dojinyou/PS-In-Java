package programmers.programmers.highscorekit.bruteforce;

public class Fatigue {

  public static final int MIN_NEED_FATIGUE_IDX = 0;
  public static final int COST_FATIGUE_IDX = 1;

  public int solution(
      int initFatigue,
      int[][] dungeonInfos
  ) {
    return getBestRoutine(
        initFatigue,
        dungeonInfos,
        new boolean[dungeonInfos.length],
        new boolean[dungeonInfos.length],
        0
    );
  }

  private int getBestRoutine(
      int fatigue,
      int[][] dungeonInfos,
      boolean[] isVisited,
      boolean[] isClear,
      int depth
  ) {
    if (depth == dungeonInfos.length) {
      return 0;
    }

    for (int i = 0; i < dungeonInfos.length; i++) {
      if (!isVisited[i]) {
        depth++;
        isVisited[i] = true;
        int result1 = 0;
        int result2 = getBestRoutine(fatigue, dungeonInfos, isVisited, isClear, depth);

        if (dungeonInfos[i][MIN_NEED_FATIGUE_IDX] <= fatigue) {
          isClear[i] = true;
          int nextFatigue = fatigue - dungeonInfos[i][COST_FATIGUE_IDX];
          result1 = getBestRoutine(nextFatigue, dungeonInfos, isVisited, isClear, depth) + 1;
        }

        return Math.max(result1, result2);
      }
    }

    return 0;
  }
}
