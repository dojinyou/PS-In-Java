package toss.challenge22;

/**
 *  숫자로만 이루어진 문자열 s가 있습니다. (0 <=  s.length < 1,000)
 *  아래의 조건을 모두 만족하는 숫자를 '멋쟁이 숫자'라고 합니다.
 *
 *  [조건]
 *  1. 길이가 3인 s의 substring을 10진수로 읽은 숫자이다.
 *  2. 각 자리의 숫자가 모두 같다.
 *
 *  구현사항
 *  문자열s를 입력받아 멋쟁이 숫자를 리턴하는 함수를 만들어주세요.
 *
 *  만약, 멋쟁이 숫자가 여러 개 존재하는 경우에는 가장 큰 수를 리턴합니다.
 *  만약, 가장 큰 멋쟁이 숫자가 000이라면 0을 리턴합니다.
 *  만약, 멋쟁이 숫자가 존재하지 않다면 -1을 리턴합니다.
 */
public class GoodNumber {

    private static final int TARGET_SUBSTRING_LENGTH = 3;
    private static final int MAX_GOOD_NUMBER_INITIAL_NUMBER = 9;

    protected int solution(String originNumberString) {
        var goodNumbers = createGoodNumbers(originNumberString);
        return convertResponse(goodNumbers);
    }

    private boolean[] createGoodNumbers(String originNumberString) {
        int originSize = originNumberString.length();
        boolean[] goodNumbers = new boolean[MAX_GOOD_NUMBER_INITIAL_NUMBER + 1];

        for (int i = 2; i < originSize; i++) {
            char subStringNumber1 = originNumberString.charAt(i - 2);
            char subStringNumber2 = originNumberString.charAt(i - 1);
            char subStringNumber3 = originNumberString.charAt(i);

            if (subStringNumber1 == subStringNumber2 && subStringNumber1 == subStringNumber3) {
                int goodNumberInteger = subStringNumber1 - '0';
                goodNumbers[goodNumberInteger] = true;

                if (goodNumberInteger == MAX_GOOD_NUMBER_INITIAL_NUMBER) {
                    break;
                }
            }
        }

        return goodNumbers;
    }

    private int convertResponse(boolean[] containGoodNumbers) {
        for (int i = 9; i >= 0; i--) {
            if (containGoodNumbers[i]) {
                return i * 111;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        var numOfTestcase = 3;
        var inputs = new String[] {"12223", "111999333", "123"};
        var outputs = new int[] {222, 999, -1};
        
        var goodNumber = new GoodNumber();
        for (int i = 0; i < numOfTestcase; i++) {
            var input = inputs[i];
            var output = outputs[i];

            var result = goodNumber.solution(input);
            if (result != output) {
                System.out.println("input: "+input+", output: "+output+", result: "+result);
            } else {
                System.out.println("pass");
            }
        }
    }
}
