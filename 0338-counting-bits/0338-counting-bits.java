class Solution {
    int num = 1;
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        if(n != 0) dp[1] = 1;
        for(int i = 2; i <= n; i++){
            if(i == num * 2) {dp[i] = 1; num*=2;}
            else{
                dp[i] = dp[i-num] + 1;
            }
        }
        return dp;
    }
}