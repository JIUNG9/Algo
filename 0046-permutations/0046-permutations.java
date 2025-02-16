class Solution {
    private List<List<Integer>> answerList;
    public List<List<Integer>> permute(int[] nums) {
        answerList = new ArrayList<>();
        dfs(new ArrayList<>(), nums, new boolean[nums.length]);
        return answerList;
        
    }
    public void dfs(List<Integer> list, int[] nums, boolean[] visited){
        if(list.size() == nums.length){
            answerList.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(nums[i]);
                dfs(list, nums,visited);
                list.remove(list.get(list.size()-1));
                visited[i] = false;
            }
        }
    }
}