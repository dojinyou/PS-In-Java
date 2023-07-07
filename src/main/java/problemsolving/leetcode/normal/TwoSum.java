package problemsolving.leetcode.normal;


public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        final var result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            var num1 = nums[i];
            for (int j = i; j < nums.length; j++) {
                var num2 = nums[j];

                if (num1 + num2 == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }

        return result;
    }

}
