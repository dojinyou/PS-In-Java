package problemsolving.programmers.public2207.no1;

import java.util.HashMap;

public class XYZMart {

  public int solution(
      String[] want,
      int[] number,
      String[] discount
  ) {
    return getCountSignUp(want, number, discount);
  }

  private int getCountSignUp(
      String[] want,
      int[] number,
      String[] discount
  ) {

    HashMap<String, Integer> wantMap = new HashMap<>();
    for (int i = 0; i < want.length; i++) {
      wantMap.put(want[i], i);
    }

    int count = 0;
    int NUM_OF_WANT_ITEM = 10;

    for (int i = 0; i < discount.length; i++) {
      if (discount.length < i + NUM_OF_WANT_ITEM) {
        break;
      }
      boolean isPossible = true;
      int[] check = number.clone();

      for (int j = 0; j < NUM_OF_WANT_ITEM; j++) {
        String discountItem = discount[i + j];

        if (!wantMap.containsKey(discountItem) || check[wantMap.get(discountItem)] == 0) {
          isPossible = false;
          break;
        }
        check[wantMap.get(discountItem)]--;
      }

      if (isPossible) {
        count++;
      }

    }

    return count;
  }
}
