package programmers.programmers.highscorekit.bruteforce;

import java.util.HashSet;
import java.util.Set;

public class FindPrimeNumber {

  private final Set<Integer> numberPermutation = new HashSet<>();

  public int solution(String numbers) {
    setUpPermutation(numbers.toCharArray(), new boolean[numbers.length()], "");

    return countPrimeNumber();
  }

  private int countPrimeNumber() {
    int result = 0;
    int[] permutation = numberPermutation
        .stream()
        .mapToInt(Integer::intValue)
        .toArray();

    for (int number : permutation) {
      if (isPrimeNumber(number)) {
        result++;
      }
    }
    return result;
  }

  private boolean isPrimeNumber(int number) {
    if (number < 2) {
      return false;
    }

    for (int i = 2; i < number; i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }

  private void setUpPermutation(
      char[] numbers,
      boolean[] isVisited,
      String prevNumber
  ) {
    for (int i = 0; i < numbers.length; i++) {
      if (!isVisited[i]) {
        isVisited[i] = true;
        String newNumber = prevNumber + numbers[i];

        numberPermutation.add(Integer.valueOf(newNumber));
        setUpPermutation(numbers, isVisited, newNumber);

        isVisited[i] = false;
      }
    }

  }
}
