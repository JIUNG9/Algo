class Solution {
    public int maxSubArray(int[] nums) {
        
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        int answer = nums[0];
        

        for(int i = 1; i < nums.length; i++){
            dp[i][0] = nums[i];
            dp[i][1] = nums[i] + Math.max(dp[i-1][0], dp[i-1][1]);
            answer = Math.max(Math.max(answer, dp[i][1]), dp[i][0]);
        }
        return nums.length == 1 ? nums[0] : answer;
    }
}