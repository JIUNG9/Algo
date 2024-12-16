class Solution {
    public int longestSubarray(int[] nums) {
        int windowIdx = 0;
        int idx = 0;
        int len = nums.length;
        int max = 0;
        int answer = 0;
        while(idx < len && nums[idx++]!=0){
            max++;
        }
        answer = Math.max(answer,max);
        if(answer == nums.length) return answer-1;
        while(idx < len){
            while(idx < len && nums[idx]==1){
                max++;
                idx++;
            }
            answer = Math.max(answer, max);

            while(windowIdx < idx && nums[windowIdx++]!=0){
                max--;
            }
            idx++;


            answer = Math.max(answer,max);
        }
        return answer;
    }
}