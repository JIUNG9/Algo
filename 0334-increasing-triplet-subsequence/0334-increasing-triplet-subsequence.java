class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        
        for (int num : nums) {
            if (num <= a) {
                a = num;
            } else if (num <= b) {
                b = num;
            } else if(num > a && num > b){
                return true;
            }
        }
        
        return false;
    }
}