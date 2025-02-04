class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int len = nums.length;
        int sum = 0;
        int answer = Integer.MAX_VALUE;

        while(left < len){
            if(sum >= target || right == len){
                sum-=nums[left++];
            }
            else{
                sum+=nums[right++];
            }
            if(sum >= target) {
                answer = Math.min(right - left , answer); 
             }
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;

    }
}