class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answerList = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            String value = str;
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(value);
        }

        for(List<String> value : map.values()){
            answerList.add(value);
        }
        return answerList;

    }

}