package problemsolving.programmers.private2208.week3.test1;

public class FFunction {

  public long[] solution(long[] numbers) {
    return getFFunctionResults(numbers);
  }

  private long[] getFFunctionResults(long[] numbers) {
    long[] results = new long[numbers.length];

    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] <= 2 || numbers[i] % 2 == 0) {
        results[i] = numbers[i] + 1;
        continue;
      }

      results[i] = fFunction(numbers[i]);
    }
    return results;
  }

  private long fFunction(long number) {
    long pow = 1;
    while (pow < number) {

      if ((number % (pow * 4)) - (number % pow) <= pow + 1) {
        return number + pow;
      }
      pow *= 2;
    }
    return pow + number;
  }

  public static void main(String[] args) {
    FFunction f = new FFunction();
    for (int i = 0; i < 100; i++) {
      long[] result = f.solution(new long[]{i});
      System.out.println(i + " => " + result[0]);
    }
  }
}

/**
 *  10진수  2진수 2 4 8 16
 *  3       00011 1 3 3 3
 *  5       00101 1 1 5 5
 *  7       00111 1 3 7 7
 *  9       01001 1 1 1 9
 *  11      01011 1 3 3 11
 *  13      01101 1 1 5 13
 *  15      01111 1 3 7 15
 */
