class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();



        for(char c : magazine.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for(char c : ransomNote.toCharArray()){
            map.put(c, map.getOrDefault(c,0)-1);
        }
        long count = map.values().stream().filter(i -> i < 0).count();
        return count > 0 ? false : true;
    }
}