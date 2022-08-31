package programmers.programmers.public2207.no2;

import java.util.Arrays;
import java.util.HashMap;

class FairTopping {

  private HashMap<Integer, Integer> leftHash = new HashMap<>();
  private HashMap<Integer, Integer> rightHash = new HashMap<>();

  private int count = 0;

  public int solution(int[] topping) {

    Arrays
        .stream(topping)
        .forEach(toppingNumber -> {
          rightHash.putIfAbsent(toppingNumber, 0);
          rightHash.put(toppingNumber, rightHash.get(toppingNumber) + 1);
        });
    Arrays
        .stream(topping)
        .forEach(toppingNumber -> {
          leftHash.putIfAbsent(toppingNumber, 0);
          leftHash.put(toppingNumber, leftHash.get(toppingNumber) + 1);

          rightHash.put(toppingNumber, rightHash.get(toppingNumber) - 1);

          if (rightHash.get(toppingNumber) == 0) {
            rightHash.remove(toppingNumber);
          }

          if (leftHash.size() == rightHash.size()) {
            count++;
          }
        });

    return count;
  }
}
