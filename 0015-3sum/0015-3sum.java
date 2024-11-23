import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> answerList = new ArrayList<>();
        int len = nums.length;


        for(int i = 0; i < len; i++){
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int sum = nums[i];
            int left = i+1;
            int right = len -1;
            while(left < right){
                if(sum + nums[left] + nums[right] == 0){
                    answerList.add(List.of(nums[i],nums [left], nums[right]));
                    left++;
                    while(left < len && nums[left-1] == nums[left]){
                        left++;
                    }
                }
                else if(sum + nums[left] + nums[right] < 0){
                    left++;
                }
                else{
                    right--;
                }

            }
        }

        return answerList;
    }

    
}