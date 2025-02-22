class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> idxMap = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            if(!idxMap.containsKey(nums[i])) idxMap.put(nums[i],i);
            else{
                if(i - idxMap.get(nums[i]) <= k) return true;
                else idxMap.put(nums[i],i);
            }
        }
        return false;

    }
}