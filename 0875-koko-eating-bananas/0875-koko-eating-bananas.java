class Solution {
    public int minEatingSpeed(int[] p, int h) {
        Arrays.sort(p);
        int len = p.length;
        int max = p[len-1];
        int answer = Integer.MAX_VALUE;

        int[] pointers = initPointer(max);
        int left = pointers[0];
        int right = pointers[1];



        while(left <= right){
            int sum = right + left;
            int remainder = sum % 2;
            int mid = remainder == 1 ? sum / 2 + 1 : sum / 2;
            if(canEatAll(p,h,mid)){
                answer = Math.min(mid, answer);
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return answer;


    }
    public boolean canEatAll(int[] piles, int h, int mid){
        for(int p : piles){
            if( p <= mid) h-=1;
            else{
                h = p % mid != 0 ? h - (p / mid + 1) : h - (p / mid);
            }
        }
        return h < 0 ? false : true;

    }
    public int[] initPointer(int biggest){
        return new int[]{1,(biggest * 2 + 1)};
    }
    
}