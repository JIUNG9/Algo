class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = dirMostOccurence(nums, target,Dir.left);
        int right = dirMostOccurence(nums, target,Dir.right);

        return new int[]{left,right};
    }
    public int dirMostOccurence(int[] nums, int target, Dir dir){
        int left = 0;
        int right = nums.length - 1;
        int mid = (left+right)/2;
        int cache = mid;
        boolean flag = false;

        while(left <= right){
            if(dir==Dir.left){
                if(nums[mid] >= target){
                    if(nums[mid] == target) {flag = true; cache = mid;}
                    right = mid -1;
                }
                else{
                    left = mid + 1;
                }
            }
            else{
                if(nums[mid] > target){
                    right = mid - 1;
                }
                else{
                    if(nums[mid] == target) {flag = true; cache = mid;}
                    left = mid + 1;
                }
            }
            mid = (left + right) / 2;
        }

        if(!flag) return -1;
        return cache;

    }

    enum Dir{
        left, right;
    }
}