package problemsolving.programmers.private2208.week3.test1;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

public class DeduplicationArray {
  public int[] solution(int[] arr) {
    return deduplicate(arr);
  }

  private int[] deduplicate(int[] arr) {
    Deque<Integer> deduplicatedList = new LinkedBlockingDeque<>(arr.length);

    for (int num : arr) {
      if (!deduplicatedList.isEmpty() && deduplicatedList.peekLast() == num) {
        continue;
      }

      deduplicatedList.addLast(num);
    }

    return deduplicatedList
        .stream()
        .mapToInt(Integer::intValue)
        .toArray();
  }
}
