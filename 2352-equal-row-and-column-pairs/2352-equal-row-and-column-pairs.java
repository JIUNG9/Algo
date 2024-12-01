class Solution {
    public int equalPairs(int[][] grid) {
        //same element and same order
        //같은 순서라면 총합으로 구할 수 없다.
        //첫ROW부터 시작해서, 모든 COL이 원소가 같다면 하나씩 증가하면서 확인한다. 이렇게 모든 ROW를 확인한다. 만약 다르다면 다음 ROW를 확인하고, 같다면 정답을 추가한다. 모든 것이 끝났을 때 정답을 반환한다.

        int len = grid.length;
        int answer = 0;
        
        for(int i =0; i < len; i++){
            for(int k = 0; k < len; k++){
                boolean flag = true;
                for(int j = 0; j < len; j++){
                    if(grid[i][j] != grid[j][k]){
                        flag = false;
                    }
            }
            if(flag) answer++;

            }
       
        }
        return answer;
    }
}