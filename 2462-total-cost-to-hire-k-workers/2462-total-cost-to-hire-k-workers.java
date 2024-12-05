class Solution {
    public long totalCost(int[] costs, int k, int c) {
       //k명을 뽑을 때까지, 왼쪽 지원자를  candidates 만큼 저장하고, 오른쪽의 지원자를  candidate를 저장한다. 각 저장소에가 가장 작은 값을 뽑아, 비교한 이후, 가장 작은 값 만을 뽑는다, 이후 뽑았으면 다시 각 저장소에 candidate의 만큼의 인원을 채운다. 만약 모든 인원을 각각의 저장소에 다 채웠다면, 해당 저장소에서 가장 작은 값을 k개에서 남은 인원 수만큼 뽑아내어 정답을 반환한다.
       int answer = 0;
        int i = 0;
        int j = costs.length-1;
        PriorityQueue<Integer> pqLeft= new PriorityQueue<>();
        PriorityQueue<Integer> pqRight= new PriorityQueue<>();
       while(k-- > 0){

        while(i <= j && pqLeft.size() < c){
            pqLeft.add(costs[i++]);
        }

        while(i <= j && pqRight.size() < c){
            pqRight.add(costs[j--]);
        }
        if(!pqLeft.isEmpty() && !pqRight.isEmpty()){
            if(pqLeft.peek() <= pqRight.peek()){
                answer+=pqLeft.poll();
            }
            else{
                answer+=pqRight.poll();
            }
        }
        else if(pqLeft.isEmpty()){
            answer+=pqRight.poll();
        }
        else{
            answer+=pqLeft.poll();
        }
       }
       return answer;
    }
}