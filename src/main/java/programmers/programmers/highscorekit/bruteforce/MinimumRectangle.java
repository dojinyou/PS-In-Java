package programmers.programmers.highscorekit.bruteforce;

public class MinimumRectangle {

  public int solution(int[][] sizes) {

    int maxLongerSize = 0;
    int maxShorterSize = 0;

    for (int[] wantedSizeInfo : sizes) {
      int size1 = wantedSizeInfo[0];
      int size2 = wantedSizeInfo[1];

      maxShorterSize = Math.max(Math.min(size1, size2), maxShorterSize);
      maxLongerSize = Math.max(Math.max(size1, size2), maxLongerSize);
    }

    return maxShorterSize * maxLongerSize;
  }
}
