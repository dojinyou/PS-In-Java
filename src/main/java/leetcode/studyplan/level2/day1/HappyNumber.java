package leetcode.studyplan.level2.day1;

import java.util.HashSet;
import java.util.Set;

/**
 * 1. Starting with any positive integer, replace the number by the sum of the squares of its digits.
 *  -> 0이 아닌 숫자로 시작해서 각 자리 수를 제곱합니다.
 * 2. Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 *  -> 해당 프로세스를 반복하빈다. 뒤에 결과가 1가 같아지거나 1을 포함하지 않았을 때까지
 * 3. Those numbers for which this process ends in 1 are happy.
 *  -> 최종적으로 숫자가 1이면 행복한 수입니다.
 */
public class HappyNumber {

    private final static int TARGET = 1;

    public boolean isHappy(int n) {
        int checkNumber = n;
        Set<Integer> prevNumbers = new HashSet<>();
        while (!prevNumbers.contains(checkNumber)) {
            prevNumbers.add(checkNumber);
            checkNumber = process(checkNumber);

            if (checkNumber == TARGET) return true;
        }
        return false;
    }

    private int process(int prevNumber) {
        int sum = 0;
        int currentNumber = prevNumber;

        do {
            int remain = currentNumber % 10;
            sum += remain * remain;

            currentNumber /= 10;
        } while(currentNumber != 0);

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(81));
    }
}
