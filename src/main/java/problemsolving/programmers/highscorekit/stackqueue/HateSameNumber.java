package problemsolving.programmers.highscorekit.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

public class HateSameNumber {
  public int[] solution(int[] numbers) {
    return removeContinousNumber(numbers);
  }

  private int[] removeContinousNumber(int[] numbers) {
    Deque<Integer> deque = new LinkedList<>();

    for (int number: numbers) {
      if (deque.isEmpty() || deque.peekLast() != number) {
        deque.add(number);
      }
    }

    return deque.stream().mapToInt(Integer::intValue).toArray();
  }
}
