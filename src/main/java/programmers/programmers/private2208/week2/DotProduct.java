package programmers.programmers.private2208.week2;

public class DotProduct {
  public int solution(
      int[] a,
      int[] b
  ) {
    int result = 0;

    for (int i = 0; i < a.length; i++) {
      result += a[i] * b[i];
    }

    return result;
  }
}
