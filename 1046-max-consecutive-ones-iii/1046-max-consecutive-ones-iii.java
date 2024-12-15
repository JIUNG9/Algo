class Solution {
    public int longestOnes(int[] nums, int k) {
        int idx = 0;
        int answer = 0;
        int windowIdx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(idx < nums.length && k > 0){
            if(nums[idx] == 0){
                k--;
                answer++;
            }
            else{
                answer++;
            }
            idx++;
        }
        pq.add(answer);

        while(idx < nums.length){
            if(nums[idx]==1) {
                answer++;
                idx++;
            }
            else{
                pq.add(answer);
                while(windowIdx < idx && nums[windowIdx]!=0){
                    windowIdx++;
                    answer--;
                }
                windowIdx++;
                idx++;
                pq.add(answer);

            }
        }
        return pq.poll();
    }
}