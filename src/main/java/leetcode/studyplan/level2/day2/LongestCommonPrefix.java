package leetcode.studyplan.level2.day2;

public class LongestCommonPrefix {
    private static final String EMPTY = "";

    public String longestCommonPrefix(String[] words) {
        StringBuilder sb = new StringBuilder(words[0]);

        for (String word: words) {
            if (word.length() < sb.length()) {
                sb.setLength(word.length());
            }
            for (int i = 0; i < sb.length(); i++) {
                if (word.charAt(i) == sb.charAt(i)) {
                    continue;
                }

                if (i == 0) {
                    return EMPTY;
                }

                sb.setLength(i);
                break;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        var solution = new LongestCommonPrefix();
        var inputs = new String[][]{
                {"flower","flow","flight"},
                {"dog","racecar","car"},
                {"ab","a"},
        };
        var outputs = new String[] {
                "fl",
                EMPTY,
                "a",
        };

        for (int i = 0; i < inputs.length; i++) {
            var input = inputs[i];
            var output = outputs[i];

            var result = solution.longestCommonPrefix(input);

            var match = result.equals(output);
            System.out.println("match = "+ match);
            if (!match) System.out.println("result = "+result+", output = "+output);
        }
        

    }

}
