package problemsolving.programmers.private2208.week3.test1;

public class GymSuit {

  private int[] gymSuit;

  public int solution(
      int n,
      int[] lost,
      int[] reserve
  ) {
    init(n, lost, reserve);

    return borrowGymSuit();
  }

  private int borrowGymSuit() {
    int result = 0;

    for (int i = 1; i < gymSuit.length; i++) {

      if (gymSuit[i] < 0 && borrow(i)) {
        continue;
      }

      result++;

    }
    return result;
  }

  private boolean borrow(int i) {
    if (0 < gymSuit[i]) {
      return false;
    }

    if (1 <= i && 0 < gymSuit[i - 1]) {
      gymSuit[i - 1]--;
      gymSuit[i]++;
      return false;
    }

    if (i < gymSuit.length - 1 && 0 < gymSuit[i + 1]) {
      gymSuit[i + 1]--;
      gymSuit[i]++;
      return false;
    }

    return true;
  }

  private void init(
      int n,
      int[] lost,
      int[] reserve
  ) {
    gymSuit = new int[n + 1];

    for (int lostId : lost) {
      gymSuit[lostId]--;
    }

    for (int reserveId : reserve) {
      gymSuit[reserveId]++;
    }
  }

}
