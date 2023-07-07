package problemsolving.programmers.highscorekit.bruteforce;

public class Carpet {
  public int[] solution(
      int brown,
      int yellow
  ) {
    double dived = brown / 4.0 + 1;
    int a = (int)Math.ceil(dived);
    int b = (int)Math.floor(dived);

    while (isNotMatch(yellow, a, b)) {
      a++;
      b--;
    }
    return new int[]{a, b};
  }

  private static boolean isNotMatch(
      int yellow,
      int a,
      int b
  ) {
    return yellow != (a - 2) * (b - 2);
  }
}
