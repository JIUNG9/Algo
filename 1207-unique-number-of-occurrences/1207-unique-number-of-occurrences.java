class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        List<Integer> list = map.values().stream().sorted((i1,i2) ->  i1-i2).collect(Collectors.toList());
        for(int i = 1; i < list.size(); i++){
            if(list.get(i-1).equals(list.get(i))){
                return false;
            }
        }
        return true;
    }
}