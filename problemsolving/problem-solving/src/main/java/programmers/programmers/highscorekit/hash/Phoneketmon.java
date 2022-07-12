package programmers.programmers.highscorekit.hash;

import java.util.HashMap;
import java.util.Map;

public class Phoneketmon {
  // Problem Link : https://school.programmers.co.kr/learn/courses/30/lessons/1845
  private static final int MIN_NUM = 0;

  public int solution(int[] phoneketmons) {
    final int MAX_NUM = phoneketmons.length / 2;
    return getMaxOfPhoneketmonType(phoneketmons, MAX_NUM);
  }

  private int getMaxOfPhoneketmonType(int[] phoneketmons, final int MAX_NUM) {
    Map<Integer, Integer> phoneketmonIdToNum = new HashMap<>();

    init(phoneketmons, phoneketmonIdToNum);

    final int numOfPhoneketmonType = phoneketmonIdToNum.size();

    return Math.min(MAX_NUM, numOfPhoneketmonType);
  }

  private void init(int[] phoneketmons, Map<Integer, Integer> phoneketmonIdToNum) {
    for (int phoneketmonId : phoneketmons) {
      int numOfPhonketmon = phoneketmonIdToNum.computeIfAbsent(phoneketmonId,
                                                               key -> MIN_NUM);
      phoneketmonIdToNum.put(phoneketmonId, numOfPhonketmon);
    }
  }
}
