package programmers.programmers.highscorekit.heap;

import org.junit.jupiter.api.Test;

class DoublePriorityQueueTest {

  @Test
  void test() {
    var a = new DoublePriorityQueue();
    int[] result = a.solution(
        new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}
    );

    for (int b : result) {
      System.out.println(b);
    }
  }
}
