class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i < len; i++){
            if(i == len) dp[i] = Math.max(dp[i-2], dp[i-1]);
            else dp[i] = Math.min(dp[i-2], dp[i-1]) + cost[i];
        }
        return Math.min(dp[len-1], dp[len-2]);
        
    }
}