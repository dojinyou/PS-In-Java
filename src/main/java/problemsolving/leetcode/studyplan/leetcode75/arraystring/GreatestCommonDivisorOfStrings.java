package problemsolving.leetcode.studyplan.leetcode75.arraystring;

public class GreatestCommonDivisorOfStrings {

	public static final String HAS_NOT_COMMON_STRING = "";

	public String gcdOfStrings(String str1, String str2) {
		var commonStringLength = getCommonStringLength(str1, str2);
		if (commonStringLength == 0) return HAS_NOT_COMMON_STRING;

		while (0 < commonStringLength
			&& (isNotConsistOf(str1, commonStringLength) || isNotConsistOf(str2, commonStringLength))) {
			commonStringLength--;
		}

		return commonStringLength > 0 ? str1.substring(0, commonStringLength) : HAS_NOT_COMMON_STRING;
	}

	private int getCommonStringLength(String str1, String str2) {
		int minLength = Math.min(str1.length(), str2.length());
		StringBuilder sb = new StringBuilder(minLength);

		for(int i = 0; i < minLength; i++) {
			var char1 = str1.charAt(i);
			var char2 = str2.charAt(i);

			if (char1 != char2) break;
			sb.append(char1);
		}

		return sb.length();
	}

	private boolean isNotConsistOf(String str, int subStringLength) {
		if (str.length() % subStringLength != 0) return true;

		for(int i = 0; i < str.length(); i+= subStringLength) {
			for(int j = 0; j < subStringLength; j++) {
				if (str.charAt(j) != str.charAt(i+j)) return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		var inputs = new String[][] {
			// {"ABCABC", "ABC"},
			// {"ABABAB", "ABAB"},
			// {"LEET", "CODE"},
			// {"ABCDEF", "ABC"},
			{
				"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",
				"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
			}
		};

		var outputs = new String[] {
			// "ABC",
			// "AB",
			// HAS_NOT_COMMON_STRING,
			// HAS_NOT_COMMON_STRING,
			"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
		};

		var solution = new GreatestCommonDivisorOfStrings();

		for(int i = 0; i < inputs.length; i++) {
			var input = inputs[i];
			var str1 = input[0];
			var str2 = input[1];
			var output = outputs[i];
			var result = solution.gcdOfStrings(str1, str2);

			if (!output.equals(result)) {
				System.out.println("Not Match");
				System.out.println("str1 = "+str1+", str2 = "+str2);
				System.out.println("output = "+output+", result = "+result);
			}
		}

	}
}
