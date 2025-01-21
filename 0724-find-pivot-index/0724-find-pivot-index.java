class Solution {
    public int pivotIndex(int[] nums) {
        int answer = -1;
        int len = nums.length;
        int[] a = new int[len];
        int[] b = new int[len];
        a[0] = nums[0];
        b[len-1] = nums[len-1];
        System.out.println("a[0]: "+ a[0]);
        System.out.println("b[len-1]: "+ b[len-1]);
        for(int i = 1; i < len; i++){
            a[i] = nums[i] + a[i-1];
            b[len-i-1] = nums[len - i - 1] + b[len - i];
        }
        for(int j = 0; j < len; j++){
            if(a[j] == b[j]) return j;
        }
        return answer;
    }
}