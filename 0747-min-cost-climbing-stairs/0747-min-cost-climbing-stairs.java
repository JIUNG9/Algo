class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //첫 숫자나, 두 번째 숫자로 시작하여 작은 값을 선택해 요금을 지불하고, 이후에도 첫 스탭이나, 두 번째 스탭으로 이동하여, 가장 작은 값을 선택한다 -> MIN 최솟값이므로 Queue를 사용한다. 만약 현재 값에서 원스텝이나 투스텝을 이동했을 때, 정답에 도달한다면 정답 값은 현재 값으로 업데이트한다.(이미 정상에 도달했으므로 요금을 지불할 필요 없다.)
        int len  = cost.length;
        int[] dp = new int[len+1];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i =2; i <= len; i++){
            if(i == len) dp[i] = Math.min(dp[i-2],dp[i-1]);
            else dp[i] = cost[i] + Math.min(dp[i-2],dp[i-1]);
        }
   
        return dp[len];
    }
}