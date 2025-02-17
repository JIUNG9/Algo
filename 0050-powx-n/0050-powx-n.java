class Solution {
    public double myPow(double x, int n) {
        // if(n == 0 || x == 1) return 1;

        // if(n < 0){
        //     x = 1/x;
        // }
        // int range = (n < 0) ? -n : n;
        // double num = 1d;

        // for(int i = 0; i < range; i++){
        //     num *= x;
        // }
        // return num;
        return Math.pow(x,n);
    }
}