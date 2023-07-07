package problemsolving.programmers.highscorekit.bruteforce;

import java.util.ArrayList;
import java.util.List;

public class MockExam {

  public static final int NUM_OF_STUDENTS = 3;

  public int[] solution(int[] answers) {
    int[] scores = new int[NUM_OF_STUDENTS];

    for (int i = 0; i < answers.length; i++) {
      int answer = answers[i];

      checkAnswer(scores, i, answer);
    }

    int highestScore = 0;
    List<Integer> highestScoreStudentIds = new ArrayList<>(NUM_OF_STUDENTS);

    for (int i = 0; i < NUM_OF_STUDENTS; i++) {
      if (highestScore < scores[i]) {
        highestScore = scores[i];
        highestScoreStudentIds.clear();
        highestScoreStudentIds.add(i+1);
        continue;
      }

      if (highestScore == scores[i]) {
        highestScoreStudentIds.add(i+1);
      }
    }

    return highestScoreStudentIds
        .stream()
        .mapToInt(Integer::intValue)
        .toArray();
  }

  private static void checkAnswer(
      int[] scores,
      int i,
      int answer
  ) {
    for (ChoiceRule rule : ChoiceRule.values()) {
      if (rule.choice(i) == answer) {
        scores[rule.ordinal()]++;
      }
    }
  }

  enum ChoiceRule {
    ONE {
      private final int[] choicePattern = new int[]{1, 2, 3, 4, 5};

      @Override
      public int choice(int i) {
        return choicePattern[i % choicePattern.length];
      }
    },
    TWO {

      private final int[] choicePattern = new int[]{2, 1, 2, 3, 2, 4, 2, 5};

      @Override
      public int choice(int i) {
        return choicePattern[i % choicePattern.length];
      }
    },
    THREE {
      private final int[] choicePattern = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

      @Override
      public int choice(int i) {
        return choicePattern[i % choicePattern.length];
      }
    };

    public abstract int choice(int i);
  }
}
