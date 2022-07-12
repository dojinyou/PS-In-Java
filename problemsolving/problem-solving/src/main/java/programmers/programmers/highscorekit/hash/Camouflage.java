package programmers.programmers.highscorekit.hash;

import java.util.HashMap;
import java.util.Map;

public class Camouflage {
  // Problem : https://school.programmers.co.kr/learn/courses/30/lessons/42578
  private static final int CLOTH_TYPE_IDX = 1;

  private static final int MIN_NUM = 0;
  private static final int NUM_OF_NOT_CHOICE_CASE = 1;
  private static final int NUM_OF_ALL_NOT_CHOICE_CASE = 1;

  public int solution(String[][] cloths) {
    Map<String, Integer> clothTypeToNum = new HashMap<>();

    fillClothTypeToNum(cloths, clothTypeToNum);

    return getCombination(clothTypeToNum);
  }

  private int getCombination(Map<String, Integer> clothTypeToNum) {
    int numOfCombination = 1;

    for (int numOfClothType :clothTypeToNum.values()) {
      numOfCombination *= (numOfClothType + NUM_OF_NOT_CHOICE_CASE);
    }

    numOfCombination -= NUM_OF_ALL_NOT_CHOICE_CASE;

    return numOfCombination;
  }

  private void fillClothTypeToNum(String[][] cloths, Map<String, Integer> clothTypeToNum) {
    for (String[] cloth : cloths) {
      String clothType = cloth[CLOTH_TYPE_IDX];
      int numOfClothType = clothTypeToNum.computeIfAbsent(clothType, type -> MIN_NUM);

      clothTypeToNum.put(clothType, numOfClothType + 1);
    }
  }
}
