package programmers.programmers.public2207.no1;

import java.util.Arrays;

class Trio {

  private static final int CHECK_NUMBER = 0;

  private int count = 0;

  private int[] numbers;

  private boolean[] isVisited;

  public int solution(int[] number) {
    numbers = number;
    isVisited = new boolean[numbers.length];
    findTrio(0, new int[3], 0);

    return count;
  }

  private void findTrio(int startIdx, int[] combination, int depth) {
    if (depth == 3) {
      int sum = Arrays.stream(combination).sum();

      if (sum == CHECK_NUMBER) {
        count++;
      }
      return;

    }

    for(int i = startIdx; i < numbers.length; i++) {
      if (!isVisited[i]) {
        isVisited[i] = true;
        combination[depth] = numbers[i];
        findTrio(i + 1, combination, depth + 1);
        isVisited[i] = false;
      }
    }
  }

}
