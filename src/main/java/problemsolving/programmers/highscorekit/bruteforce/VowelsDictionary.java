/**
 *  프로그래머스 Lv.2 / 84512 / 모음 사전
 *  https://school.programmers.co.kr/learn/courses/30/lessons/84512
 *  solve: 40분
 */
package problemsolving.programmers.highscorekit.bruteforce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VowelsDictionary {

  public static final int MAX_WORD_LENGTH = 5;
  private final char[] vowelArray = new char[]{'A', 'E', 'I', 'O', 'U'};

  private final List<String> idxToVowel = new ArrayList<>();

  private final Map<String, Integer> vowelToIdx = new HashMap<>();

  public int solution(String word) {
    initVowel();

    return vowelToIdx.get(word);
  }

  private void initVowel() {
    updateVowel(new char[MAX_WORD_LENGTH], 0);
    idxToVowel.sort(String::compareTo);

    for (int i = 0; i < idxToVowel.size(); i++) {
      String word = idxToVowel.get(i);
      vowelToIdx.put(word, i + 1);
    }
  }

  private void updateVowel(
      char[] chars,
      int depth
  ) {
    if (depth == MAX_WORD_LENGTH) {
      return;
    }

    for (char vowel : vowelArray) {
      for (int i = depth + 1; i < MAX_WORD_LENGTH; i++) {
        chars[i] = ' ';
      }
      chars[depth] = vowel;
      idxToVowel.add(String.valueOf(chars).trim());
      updateVowel(chars, depth + 1);
    }
  }

  public static void main(String[] args) {
    new VowelsDictionary().solution("AAAAE");
  }
}
