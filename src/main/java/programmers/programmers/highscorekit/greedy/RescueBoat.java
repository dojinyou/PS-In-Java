package programmers.programmers.highscorekit.greedy;

import java.util.Arrays;

public class RescueBoat {

	private static final int MIN_WEIGHT = 40;
	private static final int MAX_WEIGHT = 240;

	public int solution(int[] peopleWeights, final int limit) {
		var limitWeight = limit - 2 * MIN_WEIGHT;
		var sortedPeopleWeights = createCountArray(peopleWeights);
		var currentMinWeight = getNextWeightByStep(sortedPeopleWeights, -1, 1);
		var currentMaxWeight = getNextWeightByStep(sortedPeopleWeights, sortedPeopleWeights.length, -1);
		var minCountBoat = 0;

		while(currentMinWeight <= currentMaxWeight) {
			var countCurrentMaxWeight = sortedPeopleWeights[currentMaxWeight];
			var countCurrentMinWeight = sortedPeopleWeights[currentMinWeight];

			if (currentMinWeight + currentMaxWeight > limitWeight) {
				minCountBoat += countCurrentMaxWeight;
				sortedPeopleWeights[currentMaxWeight] = 0;
				currentMaxWeight = getNextWeightByStep(sortedPeopleWeights, currentMaxWeight, -1);
				continue;
			}

			if (currentMinWeight == currentMaxWeight) {
				minCountBoat += Math.ceil(countCurrentMaxWeight / 2.0);
				sortedPeopleWeights[currentMaxWeight] = 0;
				currentMaxWeight--;
				continue;
			}

			var minCountCurrentWeight = Math.min(countCurrentMinWeight, countCurrentMaxWeight);
			minCountBoat += minCountCurrentWeight;
			sortedPeopleWeights[currentMinWeight] -= minCountCurrentWeight;
			sortedPeopleWeights[currentMaxWeight] -= minCountCurrentWeight;
			if (sortedPeopleWeights[currentMinWeight] == 0) currentMinWeight = getNextWeightByStep(sortedPeopleWeights, currentMinWeight, 1);
			if (sortedPeopleWeights[currentMaxWeight] == 0) currentMaxWeight = getNextWeightByStep(sortedPeopleWeights, currentMaxWeight, -1);
		}
		return minCountBoat;
	}

	private int[] createCountArray(int[] peopleWeights) {
		var sortedPeopleWeights = new int[MAX_WEIGHT - MIN_WEIGHT + 1];
		for(int weight: peopleWeights) {
			int index = weight - MIN_WEIGHT;
			sortedPeopleWeights[index]++;
		}
		return sortedPeopleWeights;
	}

	private int getNextWeightByStep(int[] array, int baseIdx, int step) {
		var currentIdx = baseIdx + step;

		while(0 <= currentIdx && currentIdx < array.length && array[currentIdx] == 0) currentIdx += step;

		return currentIdx;
	}

	public static void main(String[] args) {
		var solution = new RescueBoat();
		var inputs = new Input[] {
			new Input(new int[]{70, 50, 80, 50}, 100, 3),
			new Input(new int[]{70, 80, 50}, 100, 3),
		};

		for(var input : inputs) {
			var result = solution.solution(input.people, input.limit);
			if (result != input.answer) {
				System.out.println("people: "+ Arrays.toString(input.people)+", limit: "+ input.limit);
				System.out.println("answer:"+input.answer+", result: "+result);
			}
		}
	}
	record Input(int[] people, int limit, int answer) {}
}
