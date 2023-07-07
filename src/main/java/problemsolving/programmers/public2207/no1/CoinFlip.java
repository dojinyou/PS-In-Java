package problemsolving.programmers.public2207.no1;

public class CoinFlip {

  public int solution(int[][] beginning, int[][] target) {
    final int W = beginning.length;
    final int H = beginning[0].length;
    int[][] diff = new int[W][H];

    setUpDiff(beginning, target, W, H, diff);

    return getCount(diff);
  }

  private int getCount(int[][] diff) {


    return 0;
  }

  private static void setUpDiff(
      int[][] beginning,
      int[][] target,
      int W,
      int H,
      int[][] diff
  ) {
    for (int i = 0; i < W; i++) {
      for (int j = 0; j < H; j++) {
        if (beginning[i][j] != target[i][j]) {
          diff[i][j]++;
        }
      }
    }
  }
}
