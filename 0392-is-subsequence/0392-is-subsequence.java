class Solution {
    public boolean isSubsequence(String s, String t) {
        int sIdx = 0;
        for(int i = 0; i < t.length(); i++){
            if(sIdx < s.length() &&s.charAt(sIdx) == t.charAt(i)){
                sIdx++;
            }
        }
        if(sIdx == s.length()) return true;
        return false;
    }
}