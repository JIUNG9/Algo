class Solution {
    public boolean isSubsequence(String s, String t) {
        int sPointer = 0;
        int sLen = s.length();
        for(char c : t.toCharArray()){
            if(sPointer == sLen) break;
            if(s.charAt(sPointer) == c) sPointer++;
        }
        return sPointer == sLen;
    }
}