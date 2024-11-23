import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answerList = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            // Skip duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = len - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    answerList.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for the second number
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for the third number
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return answerList;
    }
}
