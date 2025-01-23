class Solution {
    private int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
    public int orangesRotting(int[][] grid) {
        int answer = 0;
        Queue<int[]> q = getRottingLocations(grid);

        while(!q.isEmpty()){
            int[] arr = q.poll();
            int y = arr[0];
            int x = arr[1];
            int minute = arr[2];
            answer = Math.max(minute, answer);

            for(int[] m : move){
                int movedY = m[0] + y ;
                int movedX = m[1] + x ;
                if(movedY < grid.length && movedX < grid[0].length && movedY >= 0 &&  movedX >= 0 && grid[movedY][movedX] != -1 && grid[movedY][movedX]!=0){
                    grid[movedY][movedX] = -1;
                    q.add(new int[]{movedY, movedX, minute+1});
                }
            }
        }
        return isAllRotten(grid) == true ? answer : -1;

    }
    public Queue<int[]> getRottingLocations(int[][] grid){
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2) {q.add(new int[]{i,j,0}); grid[i][j] = -1;}
            }
        }
        return q;
        }
    public boolean isAllRotten(int[][] grid){
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) return false;
            }
        }
        return true;
    }

    }
