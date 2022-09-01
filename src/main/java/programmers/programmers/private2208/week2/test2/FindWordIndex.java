package programmers.programmers.private2208.week2.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindWordIndex {
  public static final int MAX_SIZE = (5 * 2) + (10 * 3);
  private final String[] DEFAULT_CHAR_LIST = new String[]{"A", "E", "I", "O", "U"};
  private final Map<String, Integer> wordToIdxMapper = new HashMap<>(MAX_SIZE);

  public int solution(String word) {
    initMapper();

    return wordToIdxMapper.get(word);
  }

  private void initMapper() {
    List<String> wordList = getSortedCombinationWords();

    Collections.sort(wordList);

    for (int i = 0; i < wordList.size(); i++) {
      wordToIdxMapper.put(wordList.get(i), i + 1);
    }
  }

  private List<String> getSortedCombinationWords() {
    List<String> wordList = new ArrayList<>(MAX_SIZE);

    initCombinationWords(wordList, null, DEFAULT_CHAR_LIST.length, 0);

    return wordList;
  }

  private void initCombinationWords(
      List<String> wordList,
      List<String> addedWordList,
      int targetDepth,
      int depth
  ) {
    if (targetDepth == depth) {
      return;
    }

    if (depth == 0) {
      wordList.addAll(Arrays.asList(DEFAULT_CHAR_LIST));
      initCombinationWords(wordList, wordList, targetDepth, depth + 1);
      return;
    }

    List<String> newAddedWordList = new ArrayList<>(wordList.size() * DEFAULT_CHAR_LIST.length);

    for (String word : addedWordList) {
      for (String defaultChar : DEFAULT_CHAR_LIST) {
        newAddedWordList.add(word + defaultChar);
      }
    }
    wordList.addAll(newAddedWordList);
    initCombinationWords(wordList, newAddedWordList, targetDepth, depth + 1);
  }
}
