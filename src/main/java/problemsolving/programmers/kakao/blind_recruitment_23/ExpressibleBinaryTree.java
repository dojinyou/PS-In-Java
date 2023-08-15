package problemsolving.programmers.kakao.blind_recruitment_23;

import java.util.Arrays;

public class ExpressibleBinaryTree {

  private static final int INEXPRESSIBLE_NUMBER = 0;
  private static final int EXPRESSIBLE_NUMBER = 1;
  public static final char DUMMY_NODE_NUMBER = '0';
  public static final char OLD_CHAR = ' ';

  public int[] solution(long[] numbers) {
    int[] expressibleNumbers = new int[numbers.length];

    for (int i = 0; i < numbers.length; i++) {
      expressibleNumbers[i] =
          isExpressibleByBinaryTree(numbers[i]) ? EXPRESSIBLE_NUMBER : INEXPRESSIBLE_NUMBER;
    }

    return expressibleNumbers;
  }

  private boolean isExpressibleByBinaryTree(long number) {
    // 숫자를 이진수로 만든다.
    String binaryNumber = Long.toBinaryString(number); // 0  -> "0"

    // 왼쪽에 0 패딩을 넣어서 정해진 길이로 맞춘다.
    int targetLength = 1;
    while (targetLength < binaryNumber.length()) {
      targetLength <<= 1;
      targetLength += 1;
    }

    int paddingLength = targetLength - binaryNumber.length();
    String paddedBinaryNumber = binaryNumber;
    if (paddingLength != 0) {
      String formatString = "%0" + targetLength + "d";
      paddedBinaryNumber = String.format(formatString, Integer.valueOf(binaryNumber))
          .replace(OLD_CHAR, DUMMY_NODE_NUMBER);
    }

    // 루트를 제외하고 부모 없는 자식이 있어서는 안된다.
    // 루트는 어디인가? 길이값 절반
    int rootIndex = paddedBinaryNumber.length() / 2; // 0
    if (paddedBinaryNumber.charAt(rootIndex) == DUMMY_NODE_NUMBER
        && paddedBinaryNumber.length() > 1) {
      return false;
    }

    // 내가 더미가 아니라면 부모도 더미가 아니어야 한다.
    // -> false

    return true;
  }

  public static void main(String[] args) {
    var expressibleBinaryTree = new ExpressibleBinaryTree();
    var result = expressibleBinaryTree.solution(new long[]{7, 42, 5, 63, 111, 95});
    System.out.println(Arrays.toString(result));
  }
}
