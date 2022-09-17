/**
 *  프로그래머스 Lv.1 / 118666 / 성격 유형 검사하기
 *  https://school.programmers.co.kr/learn/courses/30/lessons/118666
 *
 */
package programmers.programmers.kakao.tech_internship_22;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

  public static final int STANDARD_SCORE = 4;

  Score[] scores = new Score[]{new Score("RT"), new Score("CF"), new Score("JM"), new Score("AN")};
  Map<Character, Integer> mapCharToIdx = new HashMap<>(8);

  public String solution(
      String[] survey,
      int[] choices
  ) {
    init();

    for (int i = 0; i < survey.length; i++) {
      addScore(survey[i], choices[i]);
    }

    return getResult();
  }

  private String getResult() {
    StringBuilder sb = new StringBuilder();
    for (Score score: scores) {
     sb.append(score.getType());
    }

    return sb.toString();
  }

  private void addScore(
      String question,
      int choice
  ) {
    int scoreIdx = mapCharToIdx.get(question.charAt(0));
    scores[scoreIdx].addScore(question, choice);
  }

  private void init() {
    mapCharToIdx.put('R', 0);
    mapCharToIdx.put('T', 0);
    mapCharToIdx.put('F', 1);
    mapCharToIdx.put('C', 1);
    mapCharToIdx.put('M', 2);
    mapCharToIdx.put('J', 2);
    mapCharToIdx.put('A', 3);
    mapCharToIdx.put('N', 3);
  }

  class Score {
    final String type;
    int value = 0;

    Score(String type) {
      this.type = type;
    }

    void addScore(
        String question,
        int value
    ) {
      this.value += question.equals(type) ? value - STANDARD_SCORE : STANDARD_SCORE - value;
    }

    char getType() {
      return value <= 0 ? type.charAt(0) : type.charAt(1);
    }
  }
}
