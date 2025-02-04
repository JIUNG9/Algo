class Solution {
    public int uniquePathsWithObstacles(int[][] g) {
        int len = g.length;
        int row = g[0].length;
        int[][] dp = new int[len][row];

        for(int i = 0; i < len; i++){
            if(g[i][0] == 1) break;
            dp[i][0] = 1;
        }
        for(int j = 0; j < row; j++){
            if(g[0][j] == 1) break;
            dp[0][j] = 1;
        }

        for(int i = 1; i < len; i++){
            for(int j = 1; j < row; j++){
                if(g[i][j]==1) dp[i][j] = 0;
                else dp[i][j] = (dp[i-1][j] + dp[i][j-1]);
                System.out.println("dp: " + dp[i][j]);
            }
        }
        return dp[len-1][row-1];
    }
}