class Solution {
    public boolean[] visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
      //키를 가져야만 방문할 수 있다.
      //첫 문부터 시작하여 키를 얻고, 얻은 키를 통해 해당 문을 방문한 다. 이때 모든 것을 방문할 수 있으면 true 아니라면 false
      //2 <= n <= 1000, 0 <= rooms[i][j] < n
        //첫 번째 문부터 방문하여 키를 얻는다. 이후 첫 번째 문은 방문하지 않는다. 이후 얻은 키들을 통해, 해당 키들이 가르키는 방들을 방문한다. 이후 해당 문 또한 방문하지 않는다. 이렇게 모든 방문을 조회했을 때, 모든 방문을 조회했다면 true, 아니라면 false
        visited = new boolean[rooms.size()];
        dfs(0, rooms);
        return canEnterAll(visited);
        

    }
    public void dfs(int key, List<List<Integer>> rooms){        
        if(!visited[key]){
            List<Integer> keyList = rooms.get(key);
            visited[key] = true;
            for(Integer k : keyList){
                dfs(k, rooms);
            }
        }

        
         

    }

    public boolean canEnterAll(boolean[] visited){
        for(boolean b: visited){
            if(!b) return false;
        }
        return true;
    }
}