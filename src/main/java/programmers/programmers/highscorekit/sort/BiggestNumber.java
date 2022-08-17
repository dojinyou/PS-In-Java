package programmers.programmers.highscorekit.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BiggestNumber {
  public String solution(int[] numbers) {

    return Integer
        .valueOf(Arrays
                     .stream(numbers)
                     .mapToObj(MyNumber::new)
                     .sorted()
                     .map(myNumber -> String.valueOf(myNumber.numbers))
                     .collect(Collectors.joining()))
        .toString();
  }

  class MyNumber implements Comparable<MyNumber> {
    private final char[] numbers;

    MyNumber(int numbers) {
      this.numbers = String
          .valueOf(numbers)
          .toCharArray();
    }

    @Override
    public int compareTo(MyNumber o) {
      int length = numbers.length;
      int otherLength = o.numbers.length;
      for (int i = 0; i < 4; i++) {
        int thisIdx = i < length ? i : 0;
        int otherIdx = i < otherLength ? i : 0;

        if (numbers[thisIdx] == o.numbers[otherIdx]) {
          continue;
        }

        return o.numbers[otherIdx] - numbers[thisIdx];
      }

      int lastNum;

      if (length < otherLength) {
        lastNum = o.numbers[otherLength - 1];
        for (char number : numbers) {
          if (lastNum == number) {
            continue;
          }
          return lastNum - number;
        }
      }

      if (otherLength < length) {
        lastNum = numbers[length - 1];
        for (char number : o.numbers) {
          if (lastNum == number) {
            continue;
          }
          return lastNum - number;
        }
      }

      return 0;
    }
  }
}
