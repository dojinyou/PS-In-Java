package problemsolving.programmers.public2207.no1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Parcel {

  int count = 0;
  public int solution(int[] order) {
    int orderIdx = 0;

    Deque<Integer> subBelt = new ArrayDeque<>();
    int currentOrderItem = order[orderIdx];

    for (int i = 1; i <= order.length; i++) {
      while (!subBelt.isEmpty()) {
        if (subBelt.peek() != currentOrderItem) {
          break;
        }
        subBelt.pop();

        count++;
        orderIdx++;

        if (order.length == orderIdx) {
          return count;
        }
        currentOrderItem = order[orderIdx];
      }

      if (i == currentOrderItem) {
        count++;
        orderIdx++;

        if (order.length == orderIdx) {
          return count;
        }

        currentOrderItem = order[orderIdx];
        continue;
      }

      subBelt.push(i);
    }

    while (!subBelt.isEmpty()) {
      if (subBelt.peek() != currentOrderItem) {
        break;
      }
      subBelt.pop();

      count++;
      orderIdx++;

      if (order.length == orderIdx) {
        return count;
      }
      currentOrderItem = order[orderIdx];
    }

    return count;
  }
}
