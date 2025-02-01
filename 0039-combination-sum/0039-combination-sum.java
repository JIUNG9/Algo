class Solution {
    private List<List<Integer>> answerList;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        answerList = new ArrayList<>();
        dfs(candidates, 0,target, new ArrayList<>(),0);
        return answerList;

    }
    public void dfs(int[] c , int sum, int target, List<Integer> list, int depth){
        if(sum == target){
            List<Integer> copy = new ArrayList<>(list);
            answerList.add(copy);
        }
        for(int i = depth; i < c.length; i++){
            if(c[i] + sum <= target){
                list.add(c[i]);
                dfs(c, sum + c[i], target, list, i);
                list.remove(list.get(list.size()-1));
            }
        }
    }
}