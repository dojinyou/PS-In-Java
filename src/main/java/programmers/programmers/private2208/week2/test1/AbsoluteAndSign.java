package programmers.programmers.private2208.week2.test1;

public class AbsoluteAndSign {
  public int solution(
      int[] absolutes,
      boolean[] signs
  ) {
    int result = 0;

    for (int i = 0; i < absolutes.length; i++) {
      if (signs[i]) {
        result += absolutes[i];
      } else {
        result -= absolutes[i];
      }
    }

    return result;
  }
}
