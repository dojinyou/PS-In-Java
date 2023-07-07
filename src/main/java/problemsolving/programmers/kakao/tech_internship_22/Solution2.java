/**
 * 프로그래머스 LV.2 / 118667 / 두 큐 합 같게 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/118667
 * solve: 25분
 */

package problemsolving.programmers.kakao.tech_internship_22;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution2 {
  public int solution(
      int[] queue1,
      int[] queue2
  ) {
    int totalCount = (queue1.length + queue2.length) * 2;

    long sum1 = getSum(queue1);
    long sum2 = getSum(queue2);

    if ((sum1 + sum2) % 2 == 1) {
      return -1;
    }

    Queue<Integer> q1 = initQueue(queue1);
    Queue<Integer> q2 = initQueue(queue2);

    int count = 0;
    while (sum1 != sum2) {
      count++;
      if (count > totalCount) {
        count = -1;
        break;
      }
      if (sum1 > sum2) {
        int num = q1.poll();
        sum1 -= num;
        sum2 += num;
        q2.add(num);
      } else {
        int num = q2.poll();
        sum1 += num;
        sum2 -= num;
        q1.add(num);
      }
    }

    return count;
  }

  private Queue<Integer> initQueue(int[] queue1) {
    Queue<Integer> queue = new ArrayDeque<>();
    for (int num: queue1) {
      queue.add(num);
    }
    return queue;
  }

  private long getSum(int[] queue1) {
    long sum = 0;

    for (int num : queue1) {
      sum += num;
    }

    return sum;
  }
}
