class Solution {
    public String removeStars(String s) {
        //별이 있는 자리에서 왼쪽의 문자열을 삭제한다. 이때 삭제할 때 별 또한 삭제한다. 모든 별이 삭제됐을 때 정답을 반환한다.
        //순서대로 별을 만났을 때  별 가장  왼쪽에 있는 것을 삭제한다. -> n^2은 되지 않는다, 상태를 저장해야하고 순서를 보장해야한다.
        //가장 왼쪽에 *이 아닌 것을 사용하라했으니 FILO 구조를 취한다. -> Stack
        //Stack을 사용하여, 문자를 하나씩 담고, 별이 나온다면 이전에 저장했던 것이 존재한다면 가장 위에 있는 것을 pop한다. 
        //만약 *이 먼저 오는 경우에는? 삭제한다. returh the string after all stars have been removed

        /**
        
            pseudo
            stk;
            while(전체 순회)
                if(현재 확인하는 것이 알파벳이라면) stk.push();
                if(stk가 비어있지 않고 현재 확인하는 문자가 * 라면) stk.pop();

            while(stk가 비지 않을 때까지)
                StringBuilder.append(stk.pop());

                return builder.reverse().toString();
         */
        Stack<String> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;

         while(i < s.length()){
            char c = s.charAt(i);
            if(c!='*'){
                stk.push(String.valueOf(c));
            }
            else{
                if(!stk.isEmpty()) stk.pop();
            }
            i++;
         }
         while(!stk.isEmpty()){
            sb.append(stk.pop());
         }
         return sb.reverse().toString();
    }
}