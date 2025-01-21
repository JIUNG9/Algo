class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;

        for(Integer i : rooms.get(0)) set.add(i);
        while(true){
            Set<Integer> copy = new HashSet<>(set);
            for(Integer i : set){
                if(!visited[i]){ 
                    visited[i] = true;
                    for(Integer key :rooms.get(i)) copy.add(key);
                }
            }
            if(copy.size() == set.size()) break;
            set = copy;
        }
        
        return isAllVisited(visited);
    }
    public boolean isAllVisited(boolean[] v){
        for(boolean b : v){
            if(!b) return false;
        }
        return true;
    }
}