class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c!='*') sb.append(String.valueOf(c));
            else{
                sb = sb.delete(sb.length()-1, sb.length());
            }
        }
        return sb.toString();
    }
}