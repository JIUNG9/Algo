class Solution {
    public void moveZeroes(int[] nums) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int idx = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]==0)q2.add(0);
            else q1.add(nums[i]);
        }
        while(!q1.isEmpty()){
            nums[idx++] = q1.poll();
        }
        while(!q2.isEmpty()){
            nums[idx++] = q2.poll();
        }
    }
}
