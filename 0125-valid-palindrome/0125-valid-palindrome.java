class Solution {
    public boolean isPalindrome(String s) {
        
        s = s.toLowerCase();
        String str = "";

        for(char c : s.toCharArray()){
            if(Character.isAlphabetic(c) || Character.isDigit(c)){
                str = str.concat(String.valueOf(c));        
            }            
        }
        int len = str.length();
        for(char c : str.toCharArray()){
            if(c!=str.charAt(--len)) return false;
        }
        return true;
    }
}