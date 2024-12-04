class Solution {
    public int[] asteroidCollision(int[] as) {
        Stack<Integer> stk = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < as.length; i++){
            if(as[i] > 0) stk.push(as[i]);
            else{
                boolean flag = false;
                while(!stk.isEmpty() && Math.abs(stk.peek()) <= Math.abs(as[i])){
                    int value = stk.pop();
                    //양쪽이 크기가 같은 경우 더 이상 부수지 못한다.
                    if(value == -as[i]) {
                        flag = true;
                        break;
                    }
                }
                //만약 아무것도 존재하지 않고(양수가 존재하지 않고), 모두 파괴한 경우, 또한 동시에 파괴되지 않은 경우
                if(stk.isEmpty() && !flag) list.add(as[i]);
            }
        }
        int size = stk.size() + list.size();
        int[] answer = new int[size];
        int idx = answer.length -1;
        while(!stk.isEmpty()){
            answer[idx--] = stk.pop();
        }
        for(int i = idx; i >= 0; i--){
            answer[i] = list.get(i);
        }
        return answer;
    }
}