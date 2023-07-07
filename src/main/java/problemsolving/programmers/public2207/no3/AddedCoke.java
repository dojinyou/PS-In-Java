package problemsolving.programmers.public2207.no3;

public class AddedCoke {
  public int solution(int a, int b, int n) {
    return getAddedCoke(a,b,n) - n;
  }

  private int getAddedCoke(int a, int b, int n) {
    if (n < a) {
      return n;
    }

    int addedCoke = (n / a) * b;
    int leftover = n % a;

    return n - leftover + getAddedCoke(a, b, addedCoke + leftover);
  }
}
