class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i + k - 1 < nums.length; i++){
            int sum = 0;
            for(int j = i; j < i+k; j++){
                sum+=nums[j];
            }
            answer = Math.max(sum,answer);
        
        }

        return (double)answer / k;
    }
}