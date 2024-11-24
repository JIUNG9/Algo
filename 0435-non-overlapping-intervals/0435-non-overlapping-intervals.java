class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //입력값 length 1
        //겹치는 것을 지운 것의 최소 개수
        //overlapped -> 한 지점의 시작점과 끝 지점 사이에 다른 점의 시작점이 존재하는 것
        //[1,2],[1,3] 중 어떤 것을 잘라내야할까? 긴 길이를 가진 것은 겹칠 확률이 더 높다. 즉 항상 짧은 것을 잘라내지 않는 것이 이득이다. -> !!잘라낸 다음 업데이트를 하지 않았음 !!
        //시작점을 기준으로 정렬하고 시작점이 같다면, 끝지점이 짧은 것을 기준으로 정렬한 이후, 지정했던 끝지점보다 현재 확인하는 다른 시작점이 더 작다면 해당 것이 존재할 때까지 다 잘라내고 정답 값도 증가 -> 만약 겹치는 것이 없다면, endpoint를 현재 검사하는 원소의 끝 부분으로 업데이트

        /**
        pseudo code
        sort by start point asc, when the start point is same sort by end point asc as well

        int endpoint = intervals[0][1];
        for(1 to len){
            if(endpoint > intervals[i][0]){
                answer++;
                continue;
            }
            else{
                endpoint = intervals[i][1];
            }
        }

         */

         int len = intervals.length;
         int answer = 0;
         Arrays.sort(intervals,(arr1,arr2)->{
            return arr1[0] - arr2[0];
         });
        int endpoint = intervals[0][1];
        
         for(int i = 1; i < len; i++){
            if(endpoint > intervals[i][0]){
                answer++;
                endpoint = Math.min(endpoint, intervals[i][1]);
            }
            else{
                endpoint = intervals[i][1];
            }
         }
         return answer;

    }
}