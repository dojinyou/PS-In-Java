package problemsolving.programmers.highscorekit.dynamicprogramming;

public class IntegerTriangle {
	public int solution(int[][] triangle) {
		var maxValue = 0;
		var sumTriangle = new int[triangle.length][];
		sumTriangle[0] = new int[]{ triangle[0][0]};

		for(int i = 1; i < triangle.length; i++) {
			sumTriangle[i] = new int[triangle[i].length];
			for(int j = 0; j < triangle[i].length; j++) {
				var currentValue = triangle[i][j];
				var prevValue1 = 0 <= j-1 ? sumTriangle[i-1][j-1] : 0;
				var prevValue2 = j < sumTriangle[i-1].length ? sumTriangle[i-1][j] : 0;

				sumTriangle[i][j] = Math.max(prevValue1, prevValue2) + currentValue;
				if (sumTriangle[i][j] > maxValue) maxValue = sumTriangle[i][j];
			}
		}

		return maxValue;
	}

	public static void main(String[] args) {
		var input = new int[][] {
			{7},
			{3, 8},
			{8, 1, 0},
			{2, 7, 4, 4},
			{4, 5, 2, 6, 5},
		};
		var output = 30;

		var result = new IntegerTriangle().solution(input);
		var isNotMatch = result != output;

		if (isNotMatch) {
			System.out.println("result = "+result);
			System.out.println("output = "+output);
		}
	}
}
