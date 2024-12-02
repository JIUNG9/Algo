class Solution {
    List<Integer> powerOf2;

    public void initList(){
        powerOf2 = new ArrayList<>();
        powerOf2.add(0);
        powerOf2.add(1);
        while(powerOf2.get(powerOf2.size()-1) < 1000000){
            powerOf2.add(powerOf2.get(powerOf2.size()-1)*2);
        }
    }
    public int[] countBits(int n) {
        // n개를 반환

        /**
        2 = 10
        3 = 11
        4= 100
        5 = 101
        6 = 110
        7 = 111
        8 = 1000
        9 = 1001
        10 = 1010

        16 = 10000 
        17 = dp[17-8]

        */
        initList();
        int[] dp = new int[n+1];
        int m = 2;

        if(n == 0) return new int[]{0};
        else if(n == 1) return new int[]{0,1};
        else if(n == 2) return new int[]{0,1,1};

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for(int i = 3; i <= n; i++){
            if(powerOf2.contains(i)) {
                m*=2;
                dp[i] = 1;
            }
            else{
                
                dp[i] = 1 + dp[i-m];
            }

        }
        return dp;
        
        
    }
}