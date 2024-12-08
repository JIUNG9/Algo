class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int windowSum = 0;
        for(int i = 0; i < k; i++){
            windowSum +=nums[i];
        }
        sum = windowSum;

        for(int i = k; i < nums.length; i++){
            windowSum -= nums[i-k];
            windowSum += nums[i];
            sum = Math.max(sum, windowSum);
        }

        return (double)sum / k;
    }
}