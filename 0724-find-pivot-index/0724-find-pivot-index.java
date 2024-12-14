class Solution {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] dpAsc =  new int[len];
        int[] dpDesc =  new int[len];

        for(int i = 0; i < len; i++){
            if(i==0){
                dpAsc[0] = nums[i];
                dpDesc[len-1] = nums[len-1];
                continue;
            }
            dpAsc[i]+=(dpAsc[i-1] + nums[i]);
            dpDesc[len-i-1]+=(dpDesc[len-i] + nums[len-i-1]);
        }

        for(int i = 0; i < len; i++){
            if(dpAsc[i]==dpDesc[i]) return i;
        }
        return -1;

 
    }




}