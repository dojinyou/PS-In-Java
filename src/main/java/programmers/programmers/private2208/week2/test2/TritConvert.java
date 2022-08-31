package programmers.programmers.private2208.week2.test2;

public class TritConvert {

  public int solution(int n) {
    String trit = convert10To3(n);

    String reversedTrit = reverse(trit);

    return convert3To10(reversedTrit);
  }

  private int convert3To10(String reversedTrit) {
    int result = 0;

    char[] tritArray = reversedTrit.toCharArray();

    for (int i = 0; i < tritArray.length; i++) {
      int value = Integer.parseInt(String.valueOf(tritArray[tritArray.length - 1 - i]));
      result += value * Math.pow(3, i);
    }

    return result;
  }

  private String convert10To3(int n) {
    StringBuilder sb = new StringBuilder();

    int remainder = n;
    while (remainder / 3 != 0) {
      sb.append(remainder % 3);
      remainder /= 3;
    }
    sb.append(remainder % 3);

    return sb
        .reverse()
        .toString();
  }

  private String reverse(String trit) {
    StringBuilder sb = new StringBuilder();

    for (char num : trit.toCharArray()) {
      sb.append(num);
    }
    return sb
        .reverse()
        .toString();
  }
}
