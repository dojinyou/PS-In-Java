package programmers.programmers.highscorekit.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class CorrectParenthesis {
  private final char openParenthesis = '(';
  private final char closeParenthesis = ')';
  private final Deque<Character> stack = new ArrayDeque<>();

  boolean solution(String parenthesisString) {
    return isCorrect(parenthesisString.toCharArray());
  }

  private boolean isCorrect(char[] parenthesisCharArray) {
    for (char newParenthesis : parenthesisCharArray) {
      stack.push(newParenthesis);

      if (newParenthesis != closeParenthesis) {
        continue;
      }

      if (stack.size() < 2) {
        return false;
      }

      char parenthesis = stack.pop();
      char otherParenthesis = stack.pop();

      if (!isPairParenthesis(otherParenthesis, parenthesis)) {
        return false;
      }
    }

    return stack.size() == 0;
  }

  private boolean isPairParenthesis(char parenthesis, char other) {
    return parenthesis == openParenthesis && other == closeParenthesis;
  }
}
