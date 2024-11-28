class Solution {
    public int[] dailyTemperatures(int[] t) {
        
        //현재 온도를 저장하고, 현재 온도에서 며칠이 지나야 이후에 온도가 더 따뜻해질지를 구하여 정답을 반환한다.
        //저장 -> 저장소, 며칠이 지나야(순서 신경 써야한다.) -> 상태가 업데이트 되어야한다, 반영해야한다. idx의 위치는 해당 날짜를 의미하고 idx + x에 따뜻해졌다는 것은 x일 이후에 따뜻해졌다는 것을 의미한다. 따라서 해당 온도와, idx 현재 위치를 저장한다. 이후에 해당 온도보다 더 따뜻한 온도가 나타났을 때, 현재 idx와 저장한 idx를 빼서 저장했던 answer[idx] = idx+x - idx 를 저장한다.
        //현재보다 더 따뜻한 온도를 찾기 위해 오름차순으로 정렬한 PQ를 사용하기로 한다.


        //우선 정답 반환 배열을 입력 값의 길이만큼으로 설정한다, PQ를 선언하고 오름차순으로 하게한다.
        //PQ에 첫 온도와 idx를 넣는다. 이후 모든 것을 순회하면서 PQ에 무언가가 존재하고 현재 확인하는 온도가 더 크다면 answer[저장했던 값] = 현재 idx - 저장했던 값을 업데이트하고 안에 있던 것을 업데이트한다. 그리고 현재 확인하는 온도가 더 클 때까지 반복한다. 그리고 난 이후에 현재 확인하는 것을 다시 PQ에 집어넣는다, 현재 idx와 온도 이것을 모든 것을 순회한 이후에 answer 반환

        /**
            int[] answer = new int[입력 값 길이]
            pq = new PQ(오름차순);
            pq.add(new int[]{0,temp[0]});

            for(i = 1부터 len까지)
                    while(pq가 비지 않았고 pq의 온도보다 현재 확인하는 온도가 더 클 때까지)
                        int[] 이전 정보 = pq.pop();
                        answer[이전 idx] = 현재 idx - 이전 idx

                    현재 확인하는 것 pq.add(new int[]{idx, temp[idx]});

         */


        int[] answer = new int[t.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1,arr2)-> arr1[1] - arr2[1]);
        pq.add(new int[]{0,t[0]});

        for(int i = 1 ; i < t.length; i++){
            int currentIdx = i;
            int currentTemp = t[i];
            while(!pq.isEmpty() && pq.peek()[1] < currentTemp){
                int[] arr = pq.poll();
                int prevIdx = arr[0];
                int prevTemp = arr[1];
                answer[prevIdx] = currentIdx - prevIdx;
                
            }
            pq.add(new int[]{currentIdx, currentTemp});
        }

        return answer;
    }
}