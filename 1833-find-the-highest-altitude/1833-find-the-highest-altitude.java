class Solution {
    public int largestAltitude(int[] g) {
        int[] dp = new int[g.length+1];
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < dp.length; i++){
            dp[i]=dp[i-1] + g[i-1];
        }
        for(int i = 0; i < dp.length; i++){
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}