class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        else if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[2] + dp[0];

        int answer = Math.max(Math.max(dp[0],dp[1]),dp[2]);

        for(int i = 3; i < nums.length; i++){
            dp[i] = nums[i] + Math.max(dp[i-3], dp[i-2]);
            answer = Math.max(dp[i], answer);
        }
        return answer;



    }
}