class Solution {
    public int[] productExceptSelf(int[] nums) {
        int idx = 0;
        int len = nums.length;
        int productWithout0 = getProductSumWithout0(nums);
        int[] answer = new int[len];

        int[] pre = getProductArr(nums, false);
        int[] post = getProductArr(nums, true);

        while(idx < nums.length){
     
             if(idx == 0){
                answer[idx] = post[idx+1];
                idx++;
            }
            else if(idx == len - 1){
                answer[idx] = pre[idx-1];
                idx++;
            }
            else{
                answer[idx] = pre[idx - 1] * post[idx+1];
                idx++;
            }
            
        }
        return answer;
    }
    public int[] getProductArr(int[] nums, boolean isReverse){
        int len = nums.length;
        int[] arr = new int[len];
        arr[0] = nums[0];
        arr[len-1] = nums[len-1];

        for(int i = 1; i < arr.length; i++){
            if(isReverse){
                arr[len-1-i] = arr[len-i] * nums[len-1-i];
            }
            else{
                arr[i] = arr[i-1] * nums[i];
            }
        }
        return arr;
    }
    public int getProductSumWithout0(int[] n){
        int sum = 1;
        boolean isAll0 = true;
        for(Integer i : n){
            if(i == 0) continue; 
            else{isAll0 = false; sum*=i;}
            
        }
        return isAll0 == true ? 0 : sum;
    }
}