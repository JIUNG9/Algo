class Solution {
    public int minFlips(int a, int b, int c) {
        int answer = 0;
        while(a !=0 || b!= 0 || c!=0){
            int aBit = a & 1;
            int bBit = b & 1;
            int cBit = c & 1;
            if(aBit == 1 && bBit == 1 && cBit ==1) answer+=0;
            else answer+=Math.abs((aBit + bBit) - cBit);
            a >>= 1;
            b >>= 1;
            c >>= 1;

        }
        return answer;
    }
}