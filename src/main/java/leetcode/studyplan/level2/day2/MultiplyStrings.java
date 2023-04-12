package leetcode.studyplan.level2.day2;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * num1, num2 is non-negative integers
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * 1 <= num1.length, num2.length <= 200
  */

public class MultiplyStrings {


    public static final int UNIT = 10;

    public String multiply(String num1, String num2) {
        var len1 = num1.length();
        var len2 = num2.length();
        var maxLen = len1 + len2;
        var result = new int[maxLen];
        

        for (int i = 0; i < len2; i++) {
            var idx2 = len2 - 1 - i;
            var digit2 = Character.getNumericValue(num2.charAt(idx2));

            for (int j = 0; j < len1; j++) {
                var idx1 = len1 - 1 - j;
                var digit1 = Character.getNumericValue(num1.charAt(idx1));

                var multiple = digit1 * digit2;

                var addPosition = j;
                while(multiple != 0) {
                    result[i+addPosition] += multiple % UNIT;
                    multiple /= UNIT;
                    if (result[i+addPosition] >= UNIT) {
                        multiple += result[i+addPosition] / UNIT;
                        result[i+addPosition] %= UNIT;
                    }
                    addPosition++;
                }
            }
        }

        return toString(result);
    }

    private String toString(int[] result) {
        var isNotStart = true;
        var sb = new StringBuilder();

        for (int i = 0; i < result.length; i++) {
            var digit = result[result.length - 1 - i];

            if (isNotStart && digit == 0) {
                continue;
            }

            isNotStart = false;
            sb.append(digit);
        }

        return sb.length() != 0 ? sb.toString() : "0";
    }

    public static void main(String[] args) {
        var solution = new MultiplyStrings();
        var inputs = new String[][] {
                {"2", "3"},
                {"123", "456"},
                {"0", "0"},
        };

        var expects = new String[] {
                "6",
                "56088",
                "0"
        };

        for (int i = 0; i < inputs.length; i++) {
            var input = inputs[i];
            var output = solution.multiply(input[0], input[1]);

            var expect = expects[i];
            var match = output.equals(expect);

            if (!match) {
                System.out.println("input = "+ Arrays.toString(input));
                System.out.println("output = "+ output);
            }
        }
    }
}
