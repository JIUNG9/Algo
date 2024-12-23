class Solution {
    public int[] successfulPairs(int[] s, int[] p, long su) {
        //binary search
        Arrays.sort(p);
        int len = p.length;
        int[] answer = new int[s.length];
        int answerIdx = 0;
        for(int i : s)
        {   
            int left =0;
            int right = len - 1;
            int mid = (left + right) / 2;
            long product = (long) p[mid] * (long)i;
            int maxIdx = right;
            
            while(left < right){
                if(product >= su){
                    right = mid - 1;
                    
                }
                else left = mid + 1;

                mid = (left + right) / 2;
                product = (long) p[mid] * (long)i;

            }
            //at last mid is smaller than the su increase
            if(product < su ) mid+=1;            
            answer[answerIdx++] = len - mid;
        }
        return answer;


    }
}