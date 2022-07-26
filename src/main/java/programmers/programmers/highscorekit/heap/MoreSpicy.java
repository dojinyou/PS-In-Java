package programmers.programmers.highscorekit.heap;

import java.util.PriorityQueue;

public class MoreSpicy {
  private PriorityQueue<Integer> foodHeap;

  public int solution(int[] scoville, int K) {
    foodHeap = new PriorityQueue<>();
    initFoodHeap(scoville);
    return makeSpicy(K);
  }

  private void initFoodHeap(int[] scoville) {
    for (int foodSpicy : scoville) {
      foodHeap.add(foodSpicy);
    }
  }

  private int makeSpicy(int k) {
    int count = 0;
    while (1 < foodHeap.size()) {
      int minFoodSpicy = foodHeap.peek();
      if (k <= minFoodSpicy) {
        return count;
      }

      combineFood();
      count++;

    }

    if (k <= foodHeap.peek()) {
      return count;
    }

    return -1;
  }

  private void combineFood() {
    int food1 = foodHeap.poll();
    int food2 = foodHeap.poll();
    int newFood = food1 + food2 * 2;
    foodHeap.add(newFood);
  }
}
