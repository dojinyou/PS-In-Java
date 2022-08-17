package programmers.programmers.highscorekit.heap;

import java.util.LinkedList;
import java.util.List;

public class DoublePriorityQueue {

  public int[] solution(String[] operations) {
    MyDPQ list = new MyDPQ();

    for (String operation : operations) {
      list.apply(operation);
    }

    return new int[]{list.getMax(), list.getMin()};

  }

  class MyDPQ {
    private final List<Integer> list = new LinkedList<>();

    public void apply(String operation) {
      String[] splitedOperation = operation.split(" ");

      String command = splitedOperation[0];
      int value = Integer.parseInt(splitedOperation[1]);

      if (command.equals("D")) {
        if (value == 1) {
          removeMax();
        } else if (value == -1) {
          removeMin();
        }
        return;
      }
      if (command.equals("I")) {
        insert(value);
        return;
      }
      throw new IllegalArgumentException();
    }

    private void insert(int value) {
      if (list.isEmpty()) {
        list.add(value);
        return;
      }

      for (int idx = 0; idx < list.size(); idx++) {
        if (value < list.get(idx)) {
          list.add(idx, value);
          return;
        }
      }

      insertLast(value);
    }

    private void insertLast(int value) {
      list.add(list.size(), value);
    }

    private void removeMax() {
      if (!list.isEmpty()) {
        list.remove(list.size() - 1);
      }
    }

    private void removeMin() {
      if (!list.isEmpty()) {
        list.remove(0);
      }
    }

    public int getMax() {
      if (list.isEmpty()) {
        return 0;
      }
      return list.get(list.size() - 1);
    }

    public int getMin() {
      if (list.isEmpty()) {
        return 0;
      }
      return list.get(0);
    }
  }
}
