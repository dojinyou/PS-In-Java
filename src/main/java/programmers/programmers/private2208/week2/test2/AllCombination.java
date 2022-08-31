package programmers.programmers.private2208.week2.test2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AllCombination {

  public int[] solution(int[] numbers) {
    int[] combinations = getAllCombinationByAdd(numbers);

    Arrays.sort(combinations);

    return combinations;
  }

  private int[] getAllCombinationByAdd(int[] numbers) {
    int maxSize = numbers.length * (numbers.length - 1) / 2;
    Set<Integer> combinations = new HashSet<>(maxSize);

    for (int i = 0; i < numbers.length; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        combinations.add(numbers[i] + numbers[j]);
      }
    }

    return combinations
        .stream()
        .mapToInt(Integer::intValue)
        .toArray();
  }
}
