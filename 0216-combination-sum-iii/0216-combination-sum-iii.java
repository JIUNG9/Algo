class Solution {
    List<List<Integer>>answerList;
    public List<List<Integer>> combinationSum3(int k, int n) {
        answerList = new ArrayList<>();
        dfs( 1, k, n, new ArrayList<>());
        return answerList;
    }
    public void dfs(int num, int k, int n, List<Integer> list) 
    {
        if(list.size() == k  && getSum(list) == n){
            List<Integer> temp = new ArrayList<>(list);
            answerList.add(temp);
        }
        for(int i = num; i <= n; i++){
            if(list.size() < k && getSum(list) < n){
                list.add(i);
                dfs(i + 1, k , n ,list);
                list.remove(list.get(list.size()-1));
            }
        }
    }
    public int getSum(List<Integer> list){
        int sum = 0;
        for(Integer i : list){
            sum+=i;
        }
        return sum;
    }
}