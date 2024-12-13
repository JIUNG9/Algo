class Solution {
    public List<Boolean> kidsWithCandies(int[] c, int e) {

        List<Boolean> answer = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < c.length; i++){
            max = Math.max(max,c[i]);
        }

        for(int i =0 ; i < c.length; i++){
            if(max <= c[i] + e) {
                answer.add(true);
            }
            else{
                answer.add(false);
            }
        }


    

        return answer;
        
    }
}