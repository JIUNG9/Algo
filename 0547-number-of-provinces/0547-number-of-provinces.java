class Solution {
    private int answer = 0; 
    private boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        //1번노드부터 시작해서 연결된 것을 모두 연결하여, 하나의 간선으로 여긴다. 이때 이미 연결된 간선은 다시 연결하지 않고 방문처리하여 연결된 것으로 여긴다.
        //모든 노드를 확인 했을 때, 연결되지 않아서, 해당 노드를 확인한 경우만큼의 경우의 수를 반환한다.
        visited = new boolean[isConnected.length];
        for(int i = 0; i < isConnected.length; i++){
            if(!visited[i]){
                visited[i] = true;
                answer++;
                dfs(i, isConnected);
            }
        }
        return answer;
    }
    public void dfs(int from,int[][] graph){
        for(int i = 0; i < graph.length; i++){
            if(graph[from][i] == 1 && !visited[i]){
                visited[i] = true;
                dfs(i, graph);
            }
        }
    }
}