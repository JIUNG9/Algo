class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int idx = 0;
        int len = nums.length;
       while(idx + 1 < len){
            if(nums[idx] == nums[idx+1]){
                idx+=2;
            }
            else{
                return nums[idx];
            }
       }
        return nums[len-1];
    }
}