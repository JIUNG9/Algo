class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int answer = 0;
        Arrays.sort(intervals,(a,b)-> {
            if(a[1] == b[1]){
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });
        int idx = 1;
        int[] criteria = intervals[0];
        while(idx < intervals.length){
            if(criteria[1] > intervals[idx][0]){
                idx++;
                answer++;
            }
            else{
                criteria = intervals[idx++];
            }
        }

        return answer;
    }
}