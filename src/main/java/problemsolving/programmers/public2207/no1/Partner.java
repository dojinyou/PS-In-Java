package problemsolving.programmers.public2207.no1;

public class Partner {
  public final int[] countX = new int[10];
  public final int[] countY = new int[10];

  public String solution(
      String StringX,
      String StringY
  ) {
    StringX
        .chars()
        .forEach(i -> countX[i - '0']++);
    StringY
        .chars()
        .forEach(i -> countY[i - '0']++);

    StringBuilder sb = new StringBuilder();

    for (int i = 9; i >= 0; i--) {
      if (countX[i] != 0 && countY[i] != 0) {
        sb.append(String
                      .valueOf(i)
                      .repeat(Math.min(countX[i], countY[i])));
      }
    }

    String result = sb.toString();

    if (result.isBlank()) {
      return "-1";
    }

    if (result
        .chars()
        .filter(value -> value != '0')
        .count() == 0) {
      return "0";
    }

    return result;
  }
}
