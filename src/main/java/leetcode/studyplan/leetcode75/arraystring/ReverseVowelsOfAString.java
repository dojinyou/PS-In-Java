package leetcode.studyplan.leetcode75.arraystring;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

public class ReverseVowelsOfAString {

	private static final Set<Character> setOfVowels = Set.of('a', 'e', 'o', 'u','i', 'A', 'E', 'O', 'U', 'I');
	private static final char REPLACE_CHAR = '%';

	public String reverseVowels(String s) {
		var stack = (Deque<Character>) new ArrayDeque<Character>();
		var sb = new StringBuilder();

		for(int i = 0; i < s.length(); i++) {
			var character = s.charAt(i);

			if (setOfVowels.contains(character)) {
				stack.push(character);
				sb.append(REPLACE_CHAR);
				continue;
			}

			sb.append(character);
		}

		for(int i = 0; i < sb.length(); i++) {
			var character = sb.charAt(i);
			if (character == REPLACE_CHAR) {
				var newChar = stack.pop();
				sb.setCharAt(i, newChar);
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		var solution = new ReverseVowelsOfAString();
		var TEST_CASE_INPUT_IDX = 0;
		var TEST_CASE_OUTPUT_IDX = 1;
		// input size: 1<= input.length <= 3.10^5
		var testCases = new String[][] {
			{"a","a"},
			{"e","e"},
			{"i","i"},
			{"o","o"},
			{"u","u"},
			{"q","q"},
			{"qa","qa"},
			{"qab","qab"},
			{"aqe","eqa"},
		};

		for(int i = 0; i < testCases.length ; i++) {
			var testCase = testCases[i];
			var input = testCase[TEST_CASE_INPUT_IDX];
			var output = testCase[TEST_CASE_OUTPUT_IDX];
			var result = solution.reverseVowels(input);
			checkResult(i, input, output, result);
		}
	}

	private static void checkResult(int idx,String input, String expect, String actual) {
		var format = " (input = %s\texpect = %s\tactual = %s)";
		var isMatch = expect.equals(actual);
		var result = isMatch ? "PASS" : "FAIL";

		System.out.print((idx+1)+"번째 Test case result: "+result);
		var additionalInfo = isMatch ? "" : String.format(format, input, expect, actual);
		System.out.println(additionalInfo);
	}
}
