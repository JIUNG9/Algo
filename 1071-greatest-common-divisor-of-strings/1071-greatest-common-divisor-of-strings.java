class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!str1.concat(str2).equals(str2.concat(str1))) return "";
        int res = gcd(str1.length(), str2.length());
        return str1.substring(0,res);

    }
    public int gcd(int a,int b){
        return b == 0 ? a : gcd(b,a%b);
    }
}