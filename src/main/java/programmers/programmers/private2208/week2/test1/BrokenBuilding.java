package programmers.programmers.private2208.week2.test1;

public class BrokenBuilding {
  // 보드 높이 : Board.length <= 1000
  // 보드 넓이 : Board[0].length <= 1000
  // 내구도 : Board[0][0] <= 1000
  // 스킬 개수 : skill.length <= 250,000

  private static final int SKILL_ATTACK = 1;
  private static final int SKILL_HEAL = 2;
  public static final int MIN_ROW_IDX = 1;
  private static final int MIN_COL_IDX = 2;
  public static final int MAX_ROW_IDX = 3;
  private static final int MAX_COL_IDX = 4;
  public static final int SKILL_TYPE_IDX = 0;
  private static final int DEGREE_IDX = 5;

  public int solution(
      int[][] board,
      int[][] skill
  ) {
    updateBoard(board, skill);
    return getCountOfNotBrokenBuilding(board);
  }

  private int getCountOfNotBrokenBuilding(int[][] board) {
    int count = 0;

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (0 < board[i][j]) {
          count++;
        }
      }
    }
    
    return count;
  }

  private static void updateBoard(
      int[][] board,
      int[][] skill
  ) {
    // 이걸 어떻게 효율적으로??
    for (int[] skillInfo : skill) {
      // 250,000 -> 이걸 줄여야 한다? 어떻게? 중복 지우기? 아니면 면적별로 구분?
      // 완벽하게 대체 가능할 경우 합치기?
        // 완벽하게 대치는 것들을 찾아야함.
        // 큰 거에서 작은 것들을 찾는다?

      int degree = skillInfo[DEGREE_IDX];
      for (int i = skillInfo[MIN_ROW_IDX]; i <= skillInfo[MAX_ROW_IDX]; i++) {
        for (int j = skillInfo[MIN_COL_IDX]; j <= skillInfo[MAX_COL_IDX]; j++) {
          if (SKILL_ATTACK == skillInfo[SKILL_TYPE_IDX]) {
            board[i][j] -= degree;
          } else if (SKILL_HEAL == skillInfo[SKILL_TYPE_IDX]) {
            board[i][j] += degree;
          }
        }
      }
    }
  }
}
