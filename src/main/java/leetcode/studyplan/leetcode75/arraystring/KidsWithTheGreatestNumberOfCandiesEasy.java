package leetcode.studyplan.leetcode75.arraystring;

import java.util.Arrays;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandiesEasy {
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		var existMaxCandy = Arrays.stream(candies).max().orElse(0);
		return Arrays.stream(candies).mapToObj(candy -> (candy + extraCandies) >= existMaxCandy).toList();
	}
}
