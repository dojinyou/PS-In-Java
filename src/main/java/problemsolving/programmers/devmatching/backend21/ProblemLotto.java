package problemsolving.programmers.devmatching.backend21;

public class ProblemLotto {
  // Source : https://programmers.co.kr/learn/courses/30/lessons/77484
  private static final int MAX_RANK = 6;

  public int[] solution(int[] lottos, int[] winNums) {
    // 0의 개수 구하기
    int numOfZero = getCountZeroNumbers(lottos);

    // 최소 매칭 개수 구하기.
    int numOfMinMatchingNumber = getCountMatchedNumbers(lottos, winNums);

    int expectedMaxRank = getRank(numOfMinMatchingNumber);
    int expectedMinRank = getRank(numOfMinMatchingNumber + numOfZero);

    return new int[]{ expectedMinRank, expectedMaxRank};
  }

  private int getRank(int numOfMinMatchingNumber) {
    if (numOfMinMatchingNumber == 0) {
      numOfMinMatchingNumber++;
    }
    return MAX_RANK - numOfMinMatchingNumber + 1;
  }

  private int getCountZeroNumbers(int[] lottos) {
    final int targetNumber = 0;
    int count = 0;
    for (int lottoNumber : lottos) {
      if (lottoNumber == targetNumber) {
        count++;
      }
    }
    return count;
  }

  private int getCountMatchedNumbers(int[] lottos, int[] winNumbers) {
    int matchedNumber = 0;

    for (int lottoNumber: lottos) {
      for (int winNumber: winNumbers) {
        if (lottoNumber == winNumber) {
          matchedNumber++;
          break;
        }
      }
    }

    return matchedNumber;
  }
}
