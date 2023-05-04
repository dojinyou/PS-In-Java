package leetcode.studyplan.level2.day5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import Utils.TestUtils;

public class LongestPalindromebyConcatenatingTwoLetterWords {

	public int longestPalindrome(String[] words) {
		var result = 0;
		Map<String, Integer> wordSet = new HashMap<>();
		var countDuplicatedCharacters = 0;

		for(var word: words) {
			var isDuplicatedCharacters = word.charAt(0) == word.charAt(1);

			var reversedWord = String.copyValueOf(new char[] {word.charAt(1), word.charAt(0)});
			if (wordSet.containsKey(reversedWord) && wordSet.get(reversedWord) > 0) {
				result += 4;
				wordSet.put(reversedWord, wordSet.get(reversedWord) - 1);
				if (isDuplicatedCharacters) countDuplicatedCharacters--;
				continue;
			}

			wordSet.put(word, wordSet.getOrDefault(word, 0) + 1);
			if (isDuplicatedCharacters) countDuplicatedCharacters++;
		}

		if (countDuplicatedCharacters > 0) result += 2;

		return result;
	}

	public static void main(String[] args) {
		var solution = new LongestPalindromebyConcatenatingTwoLetterWords();
		var inputs = new String[][] {
			{"lc","cl","gg"},
			{"ab","ty","yt","lc","cl","ab"},
			{"cc","ll","xx"},
			{"dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"},
			{"qo","fo","fq","qf","fo","ff","qq","qf","of","of","oo","of","of","qf","qf","of"},
		};

		var outputs = new int[] {
			6,
			8,
			2,
			22,
			14,
		};

		for(int i = 0; i < inputs.length; i++) {
			var input = inputs[i];
			var expect = outputs[i];
			var result = solution.longestPalindrome(input);

			TestUtils.printResult(i, expect, result);
		}
	}
}
