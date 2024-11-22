class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        //음수 값의 소행성은 왼쪽으로, 양수 값의 소행성은 오른쪽으로 움직인다.
        //소행성이 충돌할 떄,절댓값이 큰 것이 살아남고, 절댓값이 같다면 둘 다 파괴된다.
        //최종적으로 남은 소행성들을 반환한다.
        //1. 음수 값의 소행성이 먼저 나온다면 해당 소행성은 충돌하지 않고, 살아남는다.
        //2. 충돌한 소행성 중, 살아남은 것을 다시 또 이후에 오는 것과 충돌하는지 확인하여 연쇄적으로 충돌을 처리한다.
        //해당 소행성들을 존재하는 모두 순차적으로 정리한다

        /**
            pseudo code
            while(전체 순회)
                만약 현재 값이 양수라면 스택에 저장
                만약 현재 값이 음수이고, 양수인 것이 아무것도 존재하지 않는 경우 저장(나중에 순차적으로 꺼내기 위함임)
                만약 현재 값이 음수이고, 양수인 값과 절댓값이 같다면 음수인 값을 팝
                만약 현재 값이 음수이고, 이전에 존재하던 양수인 값보다 절댓값이 크다면 저장됐던 소행성을 파괴하고, 이전에 존재하던 소행성이 또한 양수라면, 같은 조건으로 파괴한다.
                
            모든 것을 끝냈을 때, 존재하는 것들을 순차적으로 정답에 담아 반환한다.
        
         */
         Stack<Integer> stk = new Stack<>();
         for(int i : asteroids){
            if(i > 0){
                stk.push(i);
            }
            else{
                while(!stk.isEmpty() && stk.peek() > 0 && -i > stk.peek()){
                    stk.pop();
                }
                if(stk.isEmpty() || (!stk.isEmpty() && stk.peek() < 0) ){
                    stk.push(i);
                }
                else if(!stk.isEmpty() && stk.peek() == -i){
                    stk.pop();
                }
            }
         }
        int[] answer = new int[stk.size()];
        for(int k = stk.size() -1 ; k >= 0; k--){
            answer[k] = stk.pop();
        }
        return answer;

    }

}