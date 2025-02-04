class Solution {
    private List<List<Integer>> answerList;
    private boolean[] visited;
    public List<List<Integer>> combine(int n, int k) {
        answerList = new ArrayList<>();
        visited = new boolean[n+1];
        dfs(new ArrayList<>(), k,n);
        return answerList;
        
    }
    public void dfs(List<Integer> list, int k, int n){
        if(list.size() == k){
            answerList.add(new ArrayList<>(list));
        }
        else{
            for(int i = 1 ; i <= n; i++){
                if(!visited[i] && list.size() < k && (list.size() == 0 || list.get(list.size()-1) < i))
                {
                    visited[i] = true;
                    list.add(i);
                    dfs(list, k,n);
                    list.remove(list.indexOf(i));
                    visited[i] = false;
                }
            }
        }
    }
}