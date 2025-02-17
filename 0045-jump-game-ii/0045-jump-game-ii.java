class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int val = nums[i];
            for(int j = i+1; j <= i + val && j < nums.length; j++){
                if(dp[j] == 0) dp[j] = dp[i] + 1;
                else dp[j] = Math.min(dp[i]+1, dp[j]);
            }
        }
        return dp[nums.length - 1];
    }

}