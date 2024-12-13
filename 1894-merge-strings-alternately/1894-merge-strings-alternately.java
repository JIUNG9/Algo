class Solution {
    public String mergeAlternately(String w1, String w2) {
        int p1 = 0;
        int p2 = 0;
        int w1Len = w1.length();
        int w2Len = w2.length();
        StringBuilder sb = new StringBuilder();
        while(p1 < w1Len || p2 < w2Len){
            if(p1 < w1Len){
                sb.append(w1.substring(p1,p1+1));
                p1++;
            }
            if(p2 < w2Len){
                sb.append(w2.substring(p2,p2+1));
                p2++;
            }
        }
        return sb.toString();
    }
}