class Solution {
    public boolean canJump(int[] nums) {

        if(nums.length == 1){
            return true;
        }

        boolean[] dp = new boolean[nums.length];

        if(nums[0]!=0) dp[0] = true;

        for(int i =0; i < nums.length; i++){
            if(dp[i]){
                for(int j = i; j <= i + nums[i] && j < dp.length; j++){
                    dp[j] = true; 
                }
            }
        }

        return dp[nums.length-1];


    }
}