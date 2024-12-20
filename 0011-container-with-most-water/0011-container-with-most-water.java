class Solution {
    public int maxArea(int[] h) {
        //It should check the all of the cases.
        
        int left = 0;
        int right = h.length-1;
        int answer = 0;
        while(left < right){
            answer = Math.max(answer, Math.min(h[left], h[right]) * (right - left));
            if(h[left] < h[right]){
                left++;
            }
            else{
                right--;
            }


        }
        return answer;

    
}
}