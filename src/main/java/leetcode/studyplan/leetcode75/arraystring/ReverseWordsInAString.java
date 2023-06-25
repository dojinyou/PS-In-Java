package leetcode.studyplan.leetcode75.arraystring;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * {@see <a href="https://leetcode.com/problems/reverse-words-in-a-string">문제 링크</a>}
 * <br>
 * Description:<br>
 * 	Given an input string s, reverse the order of the words.<br>
 * 	A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.<br>
 * 	Return a string of the words in reverse order concatenated by a single space.<br>
 * 	Note that s may contain leading or trailing spaces or multiple spaces between two words.<br>
 *  The returned string should only have a single space separating the words. Do not include any extra spaces.<br>
 */
public class ReverseWordsInAString {
	public String reverseWords(String s) {
		var stack = (Deque<String>) new ArrayDeque<String>();

		var sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			var character = s.charAt(i);

			if (!Character.isWhitespace(character)) {
				sb.append(character);
				continue;
			}

			if (sb.length() != 0) {
				stack.push(sb.toString());
				sb.setLength(0);
			}
		}

		if (sb.length() != 0) {
			stack.push(sb.toString());
			sb.setLength(0);
		}


		return String.join(" ", stack);
	}

	public static void main(String[] args) {
		var solution = new ReverseWordsInAString();
		var TEST_CASE_INPUT_IDX = 0;
		var TEST_CASE_OUTPUT_IDX = 1;
		// input size: 1<= input.length <= 3.10^5
		var testCases = new String[][] {
			{"the sky is blue", "blue is sky the"},
			{"  hello world  ", "world hello"},
			{"a good   example", "example good a"},
		};

		for(int i = 0; i < testCases.length ; i++) {
			var testCase = testCases[i];
			var input = testCase[TEST_CASE_INPUT_IDX];
			var output = testCase[TEST_CASE_OUTPUT_IDX];
			var result = solution.reverseWords(input);
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
