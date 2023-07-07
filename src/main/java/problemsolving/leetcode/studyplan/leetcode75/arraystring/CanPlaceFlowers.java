package problemsolving.leetcode.studyplan.leetcode75.arraystring;

public class CanPlaceFlowers {

	private static final int EMPTY = 0;
	private static final int PLANTED = 1;

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		var countPossiblePlatedPoint = 0;
		var idx = 0;
		while(idx < flowerbed.length) {
			if (flowerbed[idx] == PLANTED) {
				idx++;
				continue;
			}

			var isNotLeftPlanted = idx == 0 || flowerbed[idx - 1] == EMPTY;
			var isNotRightPlanted = idx == (flowerbed.length - 1) || flowerbed[idx + 1] == EMPTY;

			if (isNotLeftPlanted && isNotRightPlanted) {
				countPossiblePlatedPoint++;
				idx++;
			}
			idx++;
		}

		return countPossiblePlatedPoint >= n;
	}

	public static void main(String[] args) {
		var input = new int[] {1,0,0,0,0,1};
		var n = 2;

		var solution = new CanPlaceFlowers();
		var result = solution.canPlaceFlowers(input, n);

		System.out.println("result = "+result);
	}
}
