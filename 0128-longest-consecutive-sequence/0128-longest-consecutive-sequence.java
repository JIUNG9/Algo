class Solution {
    public int longestConsecutive(int[] nums) {
        //정렬을 한 뒤, 숫자가 연속적이라면 인덱스를 증가시키면서 연속적인 숫자의 개수도 업데이트한다. 더 이상 연속하지 않을 때의 개수와 이전의 최대로 길었던 연속했던 숫자와 비교해 큰 것으로 정답을 업데이트한다.
        //또한 같다면 연속적이다. -> 반례 0 1 1 2
        /**

            int crnt = nums[0];
            while(전체 순회, i =1부터고 len보다 작다)
                int seq = 0; // 자기 자신 포함
                while(crnt + 1과 nums[i]가 같다면, i는 len보다 작아야한다) crnt를 nums[i]로 업데이트, seq++; i++;
                seq와 answer중 가장 큰 값으로 answer업데이트

            answer반환
            //3 (crnt) 4(i)
         */
         //0 0 1 2 3 4 5 6 7 8
         //0 1 1 2
         //-1 -1 0 1 3 4 5 6 7 8 9
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int answer =0;
        int i = 1;
        int len = nums.length;
        while(i < len){
            int seq = 1;
            while(i < len && nums[i-1] + 1 == nums[i]){
                seq++; i++;
                while(i < len && nums[i-1] == nums[i]){
                    i++;
                }
            }
            i++;
            answer = Math.max (answer,seq);
        }
    
    return answer;
}
}