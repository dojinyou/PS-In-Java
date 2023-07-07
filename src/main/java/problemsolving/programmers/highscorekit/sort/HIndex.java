package problemsolving.programmers.highscorekit.sort;

import java.util.Arrays;

public class HIndex {
  public int solution(int[] citations) {

    Arrays.sort(citations);

    int result = 0;

    for (int i = 0; i < citations.length; i++) {
      int timesCited = citations[i];
      int numOfPapers = citations.length - i;

      if (numOfPapers < timesCited) {
        result = Math.max(result, numOfPapers);
        break;
      }

      result = timesCited;

    }

    return result;
  }
}
