class Solution {
    public int rob(int[] n) {
        //two case -> 홀수번째 털기, 짝수 번째 털기
        //반례: 홀수, 짝수 케이스가 아닌 경우에 정답이 나올 수 있는가? -> [2,1,1,2] 예시, 상태를 지녀야한다. Stack Queue? 순차적으로 해결하는 것이 아니다. 모든 케이스를 확인해야한다. 입력값이 100이다. dfs로 접근한다. Permutation 방식으로 접근한다. 모든 원소를 시작점부터 시작하여, 현재 것을 방문하지 않았다면 방문하고,max 값을 업데이트, 다음 시작점 idx는 i+2이다.
        //실패한 이유 -> decision tree -> 2^n -> use the memoization
        //memoization -> 홀수, 짝수 / + 2개를 건너 뛰는 경우
        //answer을 어떤 값으로 초기화? dp[0], dp[1], dp[2] 중에 가장 큰 값
        //[1,2,3,9,2]
        int len = n.length;
        int[] dp = new int[len];
        int answer = -1;
        if(len == 1) return n[0];
        if(len == 2) return n[0] > n[1] ? n[0] : n[1];
        if(len == 3) return n[0] + n[2]> n[1] ? n[0]  + n[2]: n[1];
        dp[0] = n[0];
        dp[1] = n[1];
        dp[2] = dp[0] + n[2];
        answer = Math.max(dp[2],dp[1]);

        for(int i = 3; i < n.length; i++){
            dp[i] = Math.max(dp[i-2] + n[i], dp[i-3] + n[i]);
            answer = Math.max(answer,dp[i]);


        }
        return answer;

     

    }
 

 
}