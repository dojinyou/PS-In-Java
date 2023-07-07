package problemsolving.programmers.public2207.no3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class HamburgerStore {

  private final int BREAD_NUMBER = 1;
  private final int VEGETABLE_NUMBER = 2;
  private final int MEET_NUMBER = 3;
  private final int[] HAMBER_PATTERN = new int[]{1, 2, 3, 1};
  private Deque<Integer> ingredientStore;
  private int count = 0;

  public int solution(int[] ingredients) {
    ingredientStore = new ArrayDeque<>();

    for (int ingredient : ingredients) {
      ingredientStore.push(ingredient);
      checkIngredientStore();
    }

    return count;
  }

  private void checkIngredientStore() {
    if (ingredientStore.size() < HAMBER_PATTERN.length) {
      return;
    }
    int[] temp = new int[HAMBER_PATTERN.length];

    for (int i = HAMBER_PATTERN.length - 1; i >= 0; i--) {
      temp[i] = ingredientStore.pop();
    }

    if (!Arrays.equals(HAMBER_PATTERN, temp)) {
      for (int i = 0; i < HAMBER_PATTERN.length; i++) {
        ingredientStore.push(temp[i]);
      }
      return;
    }

    count++;
  }
}
